package com.example.usuario.navigationtab.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class EQ_FirstFragment extends Fragment {
Button EQAvanzar1;
ImageButton EQNext1;

    public EQ_FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_eq__first, container, false);
        // Inflate the layout for this fragment
        EQNext1 = (ImageButton) view.findViewById(R.id.EQNext1);
        EQNext1.setVisibility(view.INVISIBLE);
        //AFNext1.setEnabled(false);
        EQAvanzar1 = (Button) view.findViewById(R.id.EQAvanzar1);
        EQAvanzar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.EQ_Avanzar_FirstFragment=true;
                //AFNext1.setEnabled(Utilidades.AF_Avanzar_FirstFragment);
                if (Utilidades.EQ_Avanzar_FirstFragment) {
                    EQNext1.setVisibility(v.VISIBLE);
                }
                EQAvanzar1.setText("OKA");

            }
        });

        EQNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We need to call method from fragment, so I Use the MainActivity like intermediate.
                ((MainActivity)getActivity()).saltoTabsEquilibrio(1);

            }
        });
        return view;
    }

}
