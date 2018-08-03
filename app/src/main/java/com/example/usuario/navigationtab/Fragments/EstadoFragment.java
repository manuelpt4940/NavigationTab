package com.example.usuario.navigationtab.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.usuario.navigationtab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EstadoFragment extends Fragment {


    public EstadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estado, container, false);
        Button B_sig = (Button) view.findViewById(R.id.B_sig);
        B_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),EstadoSubActivity1.class);
                in.putExtra("SubActivity","Nueva Pestaña");
                startActivity(in);

            }
        });
        return view;
    }

}
