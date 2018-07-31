package com.example.usuario.navigationtab.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AF_SecondFragment extends Fragment {

    Button AFAvanzar2;
    public AF_SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        AFAvanzar2 = (Button) view.findViewById(R.id.AFAvanzar2);
        AFAvanzar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilidades.AF_Avanzar_SecondFragment=true;
            }
        });
        AFAvanzar2.setEnabled(false);

        // Inflate the layout for this fragment
        return view;
    }

    //Verificar cada vez que se vea éste fragment, que ya haya completado el primer tab para activar todoo lo demás
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (Utilidades.AF_Avanzar_FirstFragment){
                AFAvanzar2.setEnabled(true);
            }
            else{
                AFAvanzar2.setEnabled(false);
            }
        }
    }

    public interface OnFragmentInteractionListener {
    }
}
