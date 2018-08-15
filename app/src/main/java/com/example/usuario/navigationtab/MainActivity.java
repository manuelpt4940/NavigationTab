package com.example.usuario.navigationtab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.Fragments.AlcanceFuncionalContent;
import com.example.usuario.navigationtab.Fragments.AF_FirstFragment;
import com.example.usuario.navigationtab.Fragments.AF_SecondFragment;
import com.example.usuario.navigationtab.Fragments.AF_ThirdFragment;
import com.example.usuario.navigationtab.Fragments.EquilibrioContent;
import com.example.usuario.navigationtab.Fragments.EstadoFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AF_FirstFragment.OnFragmentInteractionListener, AF_SecondFragment.OnFragmentInteractionListener,
                AF_ThirdFragment.OnFragmentInteractionListener, AlcanceFuncionalContent.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        android.support.v4.app.Fragment fragment = null;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        //This is to create a tag from EquilibrioContent to use the jump tabs
        //fragmentManager.beginTransaction().add(R.id.contenedor, new EquilibrioContent(), "Equilibrio").commit();
        //fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Equilibrio")).commit();

        fragmentManager.beginTransaction().add(R.id.contenedor, new AlcanceFuncionalContent(), "Alcance").commit();



        Utilidades.HabilitacionAC=true;
        refreshMenu();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true); // code to selected in the begin the first fragment in the menu
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void refreshMenu(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menuNav = navigationView.getMenu();
        MenuItem nav_gallery = menuNav.findItem(R.id.nav_gallery);
        nav_gallery.setEnabled(Utilidades.HabilitacionAC);
        MenuItem nav_slideshow = menuNav.findItem(R.id.nav_gallery);
        nav_slideshow.setEnabled(Utilidades.HabilitacionEQ);

        //navigationView.setNavigationItemSelectedListener(this);
    }

    //Con éste método, hago la comunicación entre dos fragments. Aquí lo que hago es cambiar de pestañas por programación
    public void saltoTabsAlcance(int tab){
        FragmentManager fm = getSupportFragmentManager();
        AlcanceFuncionalContent fragment = (AlcanceFuncionalContent) fm.findFragmentByTag("Alcance");
        fragment.saltoTabs(tab);
    }

    public void saltoTabsEquilibrio(int tab){
        FragmentManager fms = getSupportFragmentManager();
        EquilibrioContent fragments = (EquilibrioContent) fms.findFragmentByTag("Equilibrio");
        fragments.saltoTabs(tab);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            Toast.makeText(this, "cerrar", Toast.LENGTH_SHORT).show();
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder alert_Exit = new AlertDialog.Builder(this);
            alert_Exit.setMessage("Do you want to disconnect with ESPPB+?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //super.onBackPressed();
                            //finish();
                            //MainActivity.this.onSuperBackPressed(); // where this method have super.onBackPressed()
                            startActivity(new Intent(MainActivity.this, Devices.class));
                                //draw.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); this code in Intent Devices.class to avoid reload mainactivity
                            //MainActivity.this.finish();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alert_Exit.create();
            alert.setTitle("ALERT!");
            alert.show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

        return true;
    }

    public void displaySelectedScreen(int id){
        android.support.v4.app.Fragment fragment = null;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        switch(id){
            case R.id.nav_camera:
                //Each block create a fragment if doesn't exist, but if it exist, just call him and hide the others fragments
                if (fragmentManager.findFragmentByTag("Alcance") != null) {
                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("Alcance")).commit();
                }else{
                    fragmentManager.beginTransaction().add(R.id.contenedor, new AlcanceFuncionalContent(), "Alcance").commit();
                }
                if (fragmentManager.findFragmentByTag("Equilibrio") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Equilibrio")).commit();
                }
                if (fragmentManager.findFragmentByTag("Estado") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Estado")).commit();
                }
                break;
            case R.id.nav_gallery:
                if (fragmentManager.findFragmentByTag("Equilibrio") != null) {
                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("Equilibrio")).commit();
                }else{
                    fragmentManager.beginTransaction().add(R.id.contenedor, new EquilibrioContent(), "Equilibrio").commit();
                }
                if (fragmentManager.findFragmentByTag("Alcance") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Alcance")).commit();
                }
                if (fragmentManager.findFragmentByTag("Estado") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Estado")).commit();
                }
                //fragment = new Second();
                break;
            case R.id.nav_manage:
                if (fragmentManager.findFragmentByTag("Estado") != null) {
                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("Estado")).commit();
                }else{
                    fragmentManager.beginTransaction().add(R.id.contenedor, new EstadoFragment(), "Estado").commit();
                }
                if (fragmentManager.findFragmentByTag("Alcance") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Alcance")).commit();
                }
                if (fragmentManager.findFragmentByTag("Equilibrio") != null){
                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Equilibrio")).commit();
                }
                 /*if (fragmentManager.findFragmentByTag("Third") != null) {
                fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("Third")).commit();
            }else{
                fragmentManager.beginTransaction().add(R.id.contenedor, new AF_ThirdFragment(), "Third").commit();
            }
            if (fragmentManager.findFragmentByTag("First") != null){
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("First")).commit();
            }
            if (fragmentManager.findFragmentByTag("Second") != null){
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Second")).commit();
            }
            if (fragmentManager.findFragmentByTag("Alcance") != null){
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("Alcance")).commit();
            }
*/
                break;

        }
        if (fragment != null){
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contenedor, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


    }



}
