package com.example.usuario.navigationtab.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.usuario.navigationtab.Adapters.SeccionesAdapter;
import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlcanceFuncionalContent extends Fragment {

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public AlcanceFuncionalContent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_alcance_funcional_content, container, false);
        // Inflate the layout for this fragment



        View parent = (View) container.getParent();
        if (appBar == null) {
            appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
            pestanas = new TabLayout(getActivity());
            pestanas.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
            appBar.addView(pestanas);


            Utilidades.PestanaAlcanceFuncional=true;
            viewPager = vista.findViewById(R.id.idViewPagerAlcance);
            viewPager.setOffscreenPageLimit(3); // Evitar que se reinicie el fragment cuando paso del 1 al 3 y viceversa


            llenarViewPager(viewPager);


            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            pestanas.setupWithViewPager(viewPager);
        }
        //Utilidades.rotacion=1;

        return vista;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            appBar.removeView(pestanas);
        } else{
            if (Utilidades.PestanaAlcanceFuncional) {
                appBar.addView(pestanas);
                saltoTabs(0);
            }
        }
    }

    public void saltoTabs(int tab){
        pestanas.getTabAt(tab).select();
    }


    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter adapter = new SeccionesAdapter(getFragmentManager());
        adapter.addFragment(new AF_FirstFragment(),"First");
        adapter.addFragment(new AF_SecondFragment(),"Second");
        adapter.addFragment(new AF_ThirdFragment(),"Third");


        viewPager.setAdapter(adapter);
    }

    public interface OnFragmentInteractionListener {
    }
}