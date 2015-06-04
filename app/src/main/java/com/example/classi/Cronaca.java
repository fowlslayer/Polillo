package com.example.classi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;


public class Cronaca extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronaca);
    }

    public void onButtonClick(View v) {
        Intent c = new Intent(Cronaca.this, Web.class);


        switch (v.getId()) {
            case R.id.imageButtonDie:
                c.putExtra("url", "http://www.ilcittadinomb.it/stories/Cultura%20e%20Spettacoli/quando-lissone-sfidava-la-biennale-di-venezia-una-mostra-e-finalmente-un-cata_1122221_11/");
                break;
            case R.id.imageButtonStaffetta:
                c.putExtra("url", "http://www.ilcittadinomb.it/stories/Cronaca/centenario-della-grande-guerra-a-lissone-il-ricordo-con-una-staffetta_1122445_11/");
                break;
            case R.id.imageButtonPola:
                c.putExtra("ur", "http://www.ilcittadinomb.it/stories/Cronaca/strage-al-museo-del-bardo-di-tunisi-uno-dei-ricercati-arrestato-nel-milanese_1121720_11/");
                break;
        }
    }
}

