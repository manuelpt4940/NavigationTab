package com.example.usuario.navigationtab.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.MainActivity;
import com.example.usuario.navigationtab.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AF_FirstFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    Button AFAvanzar1;
    ImageButton AFNext1;


    public AF_FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first, container, false);


        AFAvanzar1 = (Button) view.findViewById(R.id.AFAvanzar1);
        AFAvanzar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.AF_Avanzar_FirstFragment=true;
                AFAvanzar1.setText("OKA");



            }
        });

        AFNext1 = (ImageButton) view.findViewById(R.id.AFNext1);
        AFNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We need to call method from fragment, so I Use the MainActivity like intermediate.
                ((MainActivity)getActivity()).saltoTabsAlcance(1);

            }
        });


        return view;
    }




    public interface OnFragmentInteractionListener {
    }
}
