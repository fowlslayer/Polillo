package com.example.classi;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MieAttivitaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_mie_attivita, container, false);

        setCustomTitle("Le mie Attivita'");

        Button attivita = (Button)rootView.findViewById(R.id.unAttivita);
        attivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment fragment = new MyAttivitaAbbigliamentoFragment();
               FragmentManager fragmentManager = getFragmentManager();
               fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
               //Intent logIn = new Intent(getActivity(), AttivitaActivity.class);

               //startActivity(logIn);
            }
        });
        return rootView;

    }

    //gestione titolo
    public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

}
