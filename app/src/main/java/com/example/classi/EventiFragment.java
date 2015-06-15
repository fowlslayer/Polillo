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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EventiFragment extends Fragment {

    private ListaMesi countries=new ListaMesi();
    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_eventi, container, false);

        setCustomTitle("Eventi");

        setHasOptionsMenu(true);

        // preparazione della ListView per l'elenco delle città
        listviewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.row);

        // preparazione dello Spinner per mostrare l'elenco dei Paesi
        spinnerAdapter=new ArrayAdapter<String>(getActivity(), R.layout.row);
        spinnerAdapter.addAll(countries.getCountries());
        Spinner sp=(Spinner) rootView.findViewById(R.id.mesi);
        sp.setAdapter(spinnerAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

             @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                 Spinner sp=(Spinner) getActivity().findViewById(R.id.mesi);
                 String meseSelezionato = sp.getSelectedItem().toString();
                 if(meseSelezionato.equals("Gennaio") ||
                         meseSelezionato.equals("Marzo") ||
                         meseSelezionato.equals("Maggio") ||
                         meseSelezionato.equals("Luglio") ||
                         meseSelezionato.equals("Settembre") ||
                         meseSelezionato.equals("Novembre"))
                 {
                     final TextView titoloChange =
                             (TextView) getActivity().findViewById(R.id.titoloAttivita);
                     titoloChange.setText("Largo ai Giovani");

                     final TextView descrizioneChange =
                             (TextView) getActivity().findViewById(R.id.descrizioneAttivita);
                     descrizioneChange.setText("Diamo spazio ai nuovi artisti di farsi conoscere " +
                             "in una serata dedicata completamente alla musica e al divertimento.");

                     final TextView dataChange =
                             (TextView) getActivity().findViewById(R.id.dataAttivita);
                     dataChange.setText("l'iniziativa sara' a mesi alterni il primo sabato del mese");

                     final TextView luogoChange =
                             (TextView) getActivity().findViewById(R.id.luogoAttivita);
                     luogoChange.setText("Piazza della fontana (Centro)");


                 }
                 else
                 {
                     final TextView titoloChange =
                             (TextView) getActivity().findViewById(R.id.titoloAttivita);
                     titoloChange.setText("Mercato dell' Usato");

                     final TextView descrizioneChange =
                             (TextView) getActivity().findViewById(R.id.descrizioneAttivita);
                     descrizioneChange.setText("Mercatino delle pulci di Lissone, dove gli " +
                             "appassionati del antiquariato e del vintage si incontrano per " +
                             "scambiarsi oggetti all'aria aperta.");

                     final TextView dataChange =
                             (TextView) getActivity().findViewById(R.id.dataAttivita);
                     dataChange.setText("l'iniziativa sara' a mesi alterni la " +
                             "seconda domenica del mese");

                     final TextView luogoChange =
                             (TextView) getActivity().findViewById(R.id.luogoAttivita);
                     luogoChange.setText("Il mercatino sara' in piazza del mercato");
                 }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
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

    //gestione titolo
    public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

}
