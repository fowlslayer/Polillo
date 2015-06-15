package com.example.classi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AggiungiAnnuncio extends Fragment {

    EditText editTextNomeAnnuncio, editTextRecapito, editTextPrezzo,
            editTextDescrizione;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_aggiungi_annuncio, container, false);

        setHasOptionsMenu(true);

        //
        editTextNomeAnnuncio = (EditText) rootView.findViewById(R.id.nomeAnnuncio);
        editTextRecapito = (EditText) rootView.findViewById(R.id.recapitoAnnuncio);
        editTextPrezzo = (EditText) rootView.findViewById(R.id.prezzoAnnuncio);
        editTextDescrizione = (EditText) rootView.findViewById(R.id.descrizioneAnnuncio);

        Button btnAggiungiAnnuncio = (Button) rootView.findViewById(R.id.btnAggiungiAnnuncio);
        btnAggiungiAnnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                final String nomeAnnuncio = editTextNomeAnnuncio.getText().toString();
                final String recapito = editTextRecapito.getText().toString();
                final String prezzo = editTextPrezzo.getText().toString();
                final String descrizione = editTextDescrizione.getText().toString();;

                if(nomeAnnuncio.equals("")
                        ||recapito.equals("")
                        ||prezzo.equals("")
                        ||descrizione.equals(""))
                {
                    Toast.makeText(getActivity(), "Dati mancanti", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    Fragment fragment = new MieiAnnunciFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("tag").commit();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_undo, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    //inizializzo gestione dei click nel menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.isUndo:
                Fragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}
