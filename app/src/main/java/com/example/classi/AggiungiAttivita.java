package com.example.classi;


import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AggiungiAttivita extends Fragment {

    private ListaAttivita countries=new ListaAttivita();
    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_aggiungi_attivita, container, false);

        Button aggiungiAttivita =(Button)rootView.findViewById(R.id.aggiungiAttivita);

            aggiungiAttivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner sp = (Spinner) getActivity().findViewById(R.id.countries);
                String attivitaSelezionata = sp.getSelectedItem().toString();
                if(!attivitaSelezionata.equals("Scegli tipologia:"))
                {
                    Fragment fragment = new MieAttivitaFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
                    Toast.makeText(getActivity(), "Attivita' salvata correttamente", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getActivity(), "Seleziona una" +
                            " tipologia", Toast.LENGTH_LONG).show();
            }
        });

        // preparazione della ListView per l'elenco delle città
        listviewAdapter=new ArrayAdapter<String>(getActivity(), R.layout.row);

        // preparazione dello Spinner per mostrare l'elenco dei Paesi
        spinnerAdapter=new ArrayAdapter<String>(getActivity(), R.layout.row);
        spinnerAdapter.addAll(countries.getCountries());
        Spinner sp=(Spinner) rootView.findViewById(R.id.countries);
        sp.setAdapter(spinnerAdapter);




        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
              TextView txt = (TextView) arg0.findViewById(R.id.rowtext);
              String s = txt.getText().toString();
                if(s.equals("Scegli tipologia:"))
                {
                    txt.setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        return rootView;
    }
}
