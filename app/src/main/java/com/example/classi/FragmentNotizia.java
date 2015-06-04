package com.example.classi;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentNotizia extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_notizie, container, false);

        final Button cronaca = (Button) rootView.findViewById(R.id.buttonCronaca);
        cronaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cronaca_intent = new Intent(getActivity(), Cronaca.class);
                startActivity(cronaca_intent);
            }
        });

        final Button comunicati = (Button) rootView.findViewById(R.id.buttonComunicati);
        comunicati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comunicati_intent = new Intent(getActivity(), Comunicati.class);
                startActivity(comunicati_intent);
            }
        });

        final Button sport = (Button) rootView.findViewById(R.id.buttonLocaliNegozi);
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sport_intent = new Intent(getActivity(), Sport.class);
                startActivity(sport_intent);
            }
        });

     return rootView;
    }
}
