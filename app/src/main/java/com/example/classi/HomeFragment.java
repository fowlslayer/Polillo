package com.example.classi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        //settaggio bottoni
        Button notizie_button = (Button) rootView.findViewById(R.id.buttonCronaca);
        notizie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new NotizieFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        Button bacheca_button = (Button) rootView.findViewById(R.id.buttonComunicati);
        bacheca_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bacheca_intent = new Intent(getActivity(), LoginFragment.class);
                startActivity(bacheca_intent);
            }
        });

        Button eventi_button = (Button) rootView.findViewById(R.id.buttonEventi);
        eventi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new EventiFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

        Button locali_button = (Button) rootView.findViewById(R.id.buttonLocaliNegozi);
        locali_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new LocaliNegoziFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            }
        });

        Button comune_button = (Button) rootView.findViewById(R.id.comune_button);
        comune_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ComunePageFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            }
        });

    return rootView;
    }

     public void setCustomTitle(String title)
    {
        TextView textViewTitle = (TextView) getActivity().findViewById(R.id.mytext);
        textViewTitle.setText(title);
    }

}