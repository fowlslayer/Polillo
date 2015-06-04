package com.example.classi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ProfiloFragment extends Fragment {

    LoginDataBaseAdapter loginDataBaseAdapter;

	public ProfiloFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_profilo, container, false);

        String userName = getArguments().getString("userName");


        loginDataBaseAdapter = new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        final TextView userChange = (TextView) rootView.findViewById(R.id.eMail);
        userChange.setText(userName);


        //import nome memorizzato
        String storedName=loginDataBaseAdapter.getNome(userName);
        //modifico password con quello salvato
        final TextView nameChange = (TextView) rootView.findViewById(R.id.name);
        nameChange.setText(storedName);
        //import cognonome memorizzato
        String storedSurname=loginDataBaseAdapter.getCognome(userName);
        //modifico password con quello salvato
        final TextView surnameChange = (TextView) rootView.findViewById(R.id.cognome);
        surnameChange.setText(storedSurname);
        //import telefono memorizzato
        String storedTelephone=loginDataBaseAdapter.getTelefono(userName);
        //modifico password con quello salvato
        final TextView telephoneChange = (TextView) rootView.findViewById(R.id.telefono);
        telephoneChange.setText(storedTelephone);



        Button aggiungiAttivita = (Button)rootView.findViewById(R.id.buttonAggiungiAttivitá);
        aggiungiAttivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AggiungiAttivita();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        Button mieAttivita = (Button)rootView.findViewById(R.id.buttonMieAttivita);
        mieAttivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MieAttivitaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        Button aggiungiAnnuncio = (Button)rootView.findViewById(R.id.buttonAggiungiAnnuncio);
        aggiungiAnnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AggiungiAnnuncio();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        Button mieiAnnunci = (Button)rootView.findViewById(R.id.buttonMieiAnnunci);
        mieiAnnunci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MieiAnnunci();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });




		return rootView;
	}

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}
