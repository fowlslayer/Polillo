package com.example.classi;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;


public class Comunicati extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicati);

        final WebView webDote = (WebView) findViewById(R.id.webDote);
        final ImageButton comunicati = (ImageButton) findViewById(R.id.imageButtonDote);
        comunicati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                webDote.loadUrl("http://www.comune.lissone.mb.it/flex/cm/pages/ServeBLOB.php/L/IT/IDPagina/6745");
            }
        });

        final ImageButton expo = (ImageButton) findViewById(R.id.imageButtonExpo);
        expo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webDote.loadUrl("http://www.comune.lissone.mb.it/museo-arte-contemporanea");
            }
        });
    }
}