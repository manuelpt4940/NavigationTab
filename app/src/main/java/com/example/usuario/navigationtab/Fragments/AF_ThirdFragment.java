package com.example.usuario.navigationtab.Fragments;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.MainActivity;
import com.example.usuario.navigationtab.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AF_ThirdFragment extends Fragment {
    Button AFAvanzar3;
    ImageButton AFNext3;


    public AF_ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        AFNext3 = (ImageButton) view.findViewById(R.id.AFNext3);
        AFNext3.setVisibility(view.INVISIBLE);
        AFAvanzar3 = (Button) view.findViewById(R.id.AFAvanzar3);
        AFAvanzar3.setEnabled(false);

        AFAvanzar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.AF_Avanzar_ThirdFragment=true;
                Utilidades.HabilitacionEQ = true;
                if (Utilidades.AF_Avanzar_ThirdFragment) {
                    AFNext3.setVisibility(v.VISIBLE);
                }
            }
        });

        AFNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) getActivity()).refreshMenu(); //We call method to refresh the Gallery item
                ((MainActivity) getActivity()).displaySelectedScreen(R.id.nav_gallery);  //Code to change fragment Gallery

                //Code to select item in the menu
                NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
                //We need to call method from fragment, so I Use the MainActivity like intermediate.
                //((MainActivity) getActivity()).saltoTabsEquilibrio(1); Se hace desde el EquilibrioContent en la sección de onHidden
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (Utilidades.AF_Avanzar_SecondFragment){
                AFAvanzar3.setEnabled(true);
            }
            else{
                AFAvanzar3.setEnabled(false);
            }
        }
    }

    public interface OnFragmentInteractionListener {
    }
}
