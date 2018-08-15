package com.example.usuario.navigationtab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.usuario.navigationtab.Clases.Utilidades;

public class Devices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_devices);
        Button B_nav = (Button) findViewById(R.id.B_nav);
        B_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent draw = new Intent(Devices.this, MainActivity.class);
                draw.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(draw);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_Exit = new AlertDialog.Builder(this);
        alert_Exit.setMessage("Do you want Close ESPPB+?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //When I Close de app, with following code I reload all Utiliti Variables to reload the app
                        Utilidades U = new Utilidades();
                        U.actualizar();

                        finishAffinity();

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
