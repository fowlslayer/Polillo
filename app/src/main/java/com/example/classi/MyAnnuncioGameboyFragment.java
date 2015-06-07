package com.example.classi;

import android.app.Dialog;
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
import android.widget.Toast;


public class MyAnnuncioGameboyFragment extends Fragment{

    Button btnModifca, btnNonModifca, btnElimina, btnNonElimina;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_annuncio_gameboy, container, false);

        setCustomTitle("Gameboy");
        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_miei_oggetti, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    //inizializzo gestione dei click nel menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.isUndo:
                Fragment fragment = new MieiAnnunciFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;

            case R.id.action_modifica:
                final Dialog dialogModifica = new Dialog(getActivity());
                dialogModifica.setContentView(R.layout.dialog_modifica_attivita);
                dialogModifica.setTitle("Vuoi modificare:");
                btnModifca  = (Button)dialogModifica.findViewById(R.id.btnModificaAttivita);
                btnNonModifca = (Button)dialogModifica.findViewById(R.id.btnNonModificaAttivita);

                btnModifca.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        Fragment fragment = new AggiungiAnnuncio();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        dialogModifica.dismiss();
                    }
                });

                btnNonModifca.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        dialogModifica.dismiss();
                    }
                });

                dialogModifica.show();
                break;

            case R.id.action_elimina:
                final Dialog dialogElimina = new Dialog(getActivity());
                dialogElimina.setContentView(R.layout.dialog_elimina_attivita);
                dialogElimina.setTitle("Vuoi eliminare:");

                btnElimina  = (Button)dialogElimina.findViewById(R.id.btnEliminaAttivita);
                btnNonElimina = (Button)dialogElimina.findViewById(R.id.btnNonEliminaAttivita);

                btnElimina.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        Toast.makeText(getActivity(), "Annuncio' eliminato", Toast.LENGTH_LONG).show();
                        Fragment fragment = new MieiAnnunciFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        dialogElimina.dismiss();
                    }
                });

                btnNonElimina.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        dialogElimina.dismiss();
                    }
                });

                dialogElimina.show();
                break;
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
