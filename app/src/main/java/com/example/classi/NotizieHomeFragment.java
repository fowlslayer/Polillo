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
import android.widget.TextView;


public class NotizieHomeFragment extends Fragment{

    Fragment fragment =null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_notizie_home, container, false);

        setCustomTitle("Notizie");

        setHasOptionsMenu(true);


        final Button cronaca = (Button) rootView.findViewById(R.id.buttonNewsCronaca);
        cronaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new NotizieCronacaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("tag").commit();

            }
        });

        final Button economia = (Button) rootView.findViewById(R.id.buttonNewsEconomia);
        economia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new NotizieEconomiaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("tag").commit();
            }
        });

        final Button sport = (Button) rootView.findViewById(R.id.buttonNewsSport);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new NotizieSportFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("tag").commit();
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
