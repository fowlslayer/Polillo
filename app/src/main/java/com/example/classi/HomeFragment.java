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


public class HomeFragment extends Fragment{

    public HomeFragment() {
    }

    Fragment fragment;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        setCustomTitle("Lissone Moderna");

        setHasOptionsMenu(true);

        //settaggio bottoni
        Button notizie_button = (Button) rootView.findViewById(R.id.buttonNewsCronaca);
        notizie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new NotizieFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
            }
        });

        Button bacheca_button = (Button) rootView.findViewById(R.id.buttonNewsComunicati);
        bacheca_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new BachecaVenditaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
            }
        });

        Button eventi_button = (Button) rootView.findViewById(R.id.buttonEventi);
        eventi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new EventiFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
            }
        });

        Button locali_button = (Button) rootView.findViewById(R.id.buttonLocaliNegozi);
        locali_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new LocaliNegoziFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();

            }
        });

        Button comune_button = (Button) rootView.findViewById(R.id.comune_button);
        comune_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ComunePageFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();
            }
        });

    return rootView;
    }

    public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        if(getArguments() != null) {
            String userName = getArguments().getString("userName");
            if (userName != null)
                inflater.inflate(R.menu.main, menu);
            else
                inflater.inflate(R.menu.menu_home_with_login, menu);
        }
        else
            inflater.inflate(R.menu.menu_home_with_login, menu);

        super.onCreateOptionsMenu(menu, inflater);

    }

    //inizializzo gestione dei click nel menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.isLogin:
                Fragment fragment = new LoginFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack( "tag" ).commit();


                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}