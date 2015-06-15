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
import android.widget.TextView;

public class ComunePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_comune, container, false);
        super.onCreate(savedInstanceState);

        setCustomTitle("Comune");

        setHasOptionsMenu(true);

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.abs_layout);
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
