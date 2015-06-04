package com.example.classi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FavoritiGelateriaFragment extends Fragment {
    Button isFavorito;
    boolean favorito=true;
    int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_negozio_gelateria, container, false);

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_favoriti, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    //inizializzo gestione dei click nel menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.isFavorito:
                if (count == 0) {
                    //cambio la mia icona al click
                    item.setIcon(R.drawable.icon_non_preferito);
                    count++;
                } else
                {
                    item.setIcon(R.drawable.icon_preferito);
                    count = 0;
                }


            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
