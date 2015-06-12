package com.example.classi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class News extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cronaca);
    }

    public void onButtonClick(View v) {
        Intent c = new Intent(News.this, Web.class);


        switch (v.getId()) {
            case R.id.jazz:
                c.putExtra("url", "http://www.ilcittadinomb.it/stories/Cronaca/festival-jazz-nel-centro-di-monza-e-molto-altro-che-cosa-fare-nel-weekend_1124591_11/");
                break;
            case R.id.sonica:
                c.putExtra("url", "http://www.ilcittadinomb.it/stories/Cultura%20e%20Spettacoli/subsonica-day-nei-cinema-col-biglietto-si-porta-un-amico-gratis-al-brianza-ro_1124383_11/");
                break;

        }
    }
}
