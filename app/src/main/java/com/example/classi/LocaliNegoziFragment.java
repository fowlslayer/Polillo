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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class LocaliNegoziFragment extends Fragment {

    private ListaAttivita countries=new ListaAttivita();
    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;
    Button imageButton;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_locali_negozi, container, false);

        setHasOptionsMenu(true);

        setCustomTitle("Locali & Negozi");

        imageButton = (Button) rootView.findViewById(R.id.buttonSceltaAttivita);

        // preparazione della ListView per l'elenco delle città
        listviewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.row);

        // preparazione dello Spinner per mostrare l'elenco dei Paesi
        spinnerAdapter=new ArrayAdapter<String>(getActivity(), R.layout.row);
        spinnerAdapter.addAll(countries.getCountries());
        Spinner sp=(Spinner) rootView.findViewById(R.id.attivitaDaScegliere);
        sp.setAdapter(spinnerAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Spinner sp=(Spinner) getActivity().findViewById(R.id.attivitaDaScegliere);
                String attivitaSelezionata = sp.getSelectedItem().toString();

                if(attivitaSelezionata.equals("Gelateria"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_gelateria);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioGelateria);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioGelateria);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioGelateria);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioGelateria);
                    fragment = new NegozioGelateriaFragment();
                }

                if(attivitaSelezionata.equals("Abbigliamento"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_abbigliamento);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioAbbigliamento);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioAbbigliamento);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioAbbigliamento);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioAbbigliamento);

                    fragment = new NegozioAbbigliamentoFragment();

                }

                if(attivitaSelezionata.equals("Bar"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_bar);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioBar);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioBar);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioBar);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioBar);

                    fragment = new NegozioBarFragment();
                }

                if(attivitaSelezionata.equals("Disco e Pub"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_discoteca);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioDiscoteca);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioDiscoteca);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioDiscoteca);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioDiscoteca);

                    fragment = new NegozioDiscotecaFragment();
                }

                if(attivitaSelezionata.equals("Minimarket"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_minimarket);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioMinimarket);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioMinimarket);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioMinimarket);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioMinimarket);

                    fragment = new NegozioMinimarketFragment();
                }

                if(attivitaSelezionata.equals("Pizzeria"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_pizzeria);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioPizzeria);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioPizzeria);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioPizzeria);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioPizzeria);

                    fragment = new NegozioPizzeriaFragment();
                }

                if(attivitaSelezionata.equals("Ristorante"))
                {
                    //cambia l'immagine del bottone
                    imageButton.setBackgroundResource(R.drawable.negozio_ristorante);

                    final TextView titoloChange =
                            (TextView) getActivity().findViewById(R.id.titoloSceltaAttivita);
                    titoloChange.setText(R.string.titoloNegozioRistorante);

                    final TextView descrizioneChange =
                            (TextView) getActivity().findViewById(R.id.descrizioneSceltaAttivita);
                    descrizioneChange.setText(R.string.descrizioneNegozioRistorante);

                    final TextView orarioChange =
                            (TextView) getActivity().findViewById(R.id.orarioSceltaAttivita);
                    orarioChange.setText(R.string.orarioNegozioRistorante);

                    final TextView indirizzoChange =
                            (TextView) getActivity().findViewById(R.id.indirizzoSceltaAttivita);
                    indirizzoChange.setText(R.string.indirizzoNegozioRistorante);

                    fragment = new NegozioRistoranteFragment();
                }

                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
                    }
                });
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
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();

                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

}