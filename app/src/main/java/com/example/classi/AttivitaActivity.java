package com.example.classi;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Enrico on 25/05/2015.
 */
public class AttivitaActivity extends Activity{

    Button modifica,elimina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attivita);

        modifica = (Button)findViewById(R.id.modifica_icona);
        elimina = (Button)findViewById(R.id.elimina_icona);

        modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(AttivitaActivity.this);
                dialog.setContentView(R.layout.elimina_attivita);
                dialog.setTitle("Sei sicuro di voler modificare la tua attivita?");
                dialog.show();
            }
        });

        elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(AttivitaActivity.this);
                dialog.setContentView(R.layout.modifica_attivita);
                dialog.setTitle("Sei sicuro di voler eliminare la tua attivita?");
                dialog.show();
            }
        });
    }
}
