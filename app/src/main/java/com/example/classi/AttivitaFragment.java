package com.example.classi;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AttivitaFragment extends Fragment{

    Button modifica, elimina, btnModifca, btnNonModifca, btnElimina, btnNonElimina;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attivita, container, false);

        modifica = (Button)rootView.findViewById(R.id.modifica_icona);
        elimina = (Button)rootView.findViewById(R.id.elimina_icona);

        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.modifica_attivita);
                dialog.setTitle("Vuoi modificare:");


                btnModifca  = (Button)dialog.findViewById(R.id.btnModificaAttivita);
                btnNonModifca = (Button)dialog.findViewById(R.id.btnNonModificaAttivita);

                btnModifca.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        Fragment fragment = new AggiungiAttivita();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        dialog.dismiss();
                    }
                });

                btnNonModifca.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.elimina_attivita);
                dialog.setTitle("Vuoi eliminare:");

                btnElimina  = (Button)dialog.findViewById(R.id.btnEliminaAttivita);
                btnNonElimina = (Button)dialog.findViewById(R.id.btnNonEliminaAttivita);

                btnElimina.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        Toast.makeText(getActivity(), "Attivita' eliminata", Toast.LENGTH_LONG).show();
                        Fragment fragment = new MieAttivitaFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        dialog.dismiss();
                    }
                });

                btnNonElimina.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        return rootView;
    }
}
