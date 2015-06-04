package com.example.classi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;


public class Sport extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        final WebView webDote = (WebView) findViewById(R.id.webDote);
        final ImageButton comunicati = (ImageButton) findViewById(R.id.imageButtonDote);
        comunicati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webDote.loadUrl("http://www.comune.lissone.mb.it/flex/cm/pages/ServeBLOB.php/L/IT/IDPagina/6745");
            }
        });

    }
}
