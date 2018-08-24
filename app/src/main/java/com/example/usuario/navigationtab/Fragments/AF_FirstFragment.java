package com.example.usuario.navigationtab.Fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.usuario.navigationtab.Clases.Utilidades;
import com.example.usuario.navigationtab.MainActivity;
import com.example.usuario.navigationtab.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AF_FirstFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    Button AFAvanzar1;
    ImageButton AFNext1;
    ImageButton ImButton;
    TextView TV;
    String [] listitems;
    int checkItem=-1;  //Value to choose the item selected in radioButton AlertDialog


    public AF_FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first, container, false);

        ImButton = view.findViewById(R.id.imButton);
        TV = view.findViewById(R.id.TV);




        ImButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create list of items
                listitems = new String[]{"Inseguridad Adulto", "Inseguridad Evaluador", "No es posible"};
                AlertDialog.Builder mBuild = new AlertDialog.Builder(getActivity());
                mBuild.setTitle("Seleccione la razón");
                mBuild.setIcon(R.drawable.iconlist);
                mBuild.setSingleChoiceItems(listitems, checkItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItem = i;
                        TV.setText(listitems[i]);
                        dialog.dismiss();
                    }
                });
                mBuild.setNeutralButton("Cancelar Selección", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        checkItem = -1;
                        TV.setText("Fragmento 1");
                    }
                });
                AlertDialog mDialog = mBuild.create();
                mDialog.show();
            }
        });

        AFNext1 = (ImageButton) view.findViewById(R.id.AFNext1);
        AFNext1.setVisibility(view.INVISIBLE);
        //AFNext1.setEnabled(false);
        AFAvanzar1 = (Button) view.findViewById(R.id.AFAvanzar1);
        AFAvanzar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final ProgressDialog progressBar = new ProgressDialog(getActivity());
                progressBar.setIcon(R.drawable.ic_menu_share);
                progressBar.setCancelable(false);
                progressBar.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Code that takes a long time
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Code when a long time code is finished
                                progressBar.dismiss();
                                Utilidades.AF_Avanzar_FirstFragment=true;
                                //AFNext1.setEnabled(Utilidades.AF_Avanzar_FirstFragment);
                                if (Utilidades.AF_Avanzar_FirstFragment) {
                                    AFNext1.setVisibility(v.VISIBLE);
                                }
                                AFAvanzar1.setText("OKA");
                                ((MainActivity)getActivity()).enableTabsAlcance(1);
                            }
                        });

                    }
                }).start();


            }
        });


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

