package com.example.classi;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MieiAnnunci extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_miei_annunci, container, false);

        Button annuncio = (Button)rootView.findViewById(R.id.unAnnuncio);
        annuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new AnnuncioFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                //Intent logIn = new Intent(getActivity(), AttivitaActivity.class);

                //startActivity(logIn);
            }
        });

        return rootView;
    }
}
