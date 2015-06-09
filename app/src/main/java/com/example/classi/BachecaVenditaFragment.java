package com.example.classi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Angerfist on 31/05/2015.
 */
public class BachecaVenditaFragment extends Fragment {

    Fragment fragment;

    Button btnChitarra, btnDivano, btnMobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_bacheca_vendite, container, false);

        setHasOptionsMenu(true);

        btnChitarra = (Button) rootView.findViewById(R.id.buttonOggettoChitarra);
        btnChitarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new AnnuncioChitarraFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });
        btnDivano = (Button) rootView.findViewById(R.id.buttonOggettoDivano);
        btnDivano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new AnnuncioDivanoFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });
        btnMobile = (Button) rootView.findViewById(R.id.buttonOggettoMobile);
        btnMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new AnnuncioMobileFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });
        return rootView;
    }
}
