package com.example.classi;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MieAttivitaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_mie_attivita, container, false);


        Button attivita = (Button)rootView.findViewById(R.id.unAttivita);
        attivita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment fragment = new AttivitaFragment();
               FragmentManager fragmentManager = getFragmentManager();
               fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
               //Intent logIn = new Intent(getActivity(), AttivitaActivity.class);

               //startActivity(logIn);
            }
        });
        return rootView;

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
