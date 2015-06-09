package com.example.classi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;


public class Sport extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
    }

    public void onButtonClick(View v) {
        Intent c = new Intent(Sport.this, Web.class);


        switch (v.getId()) {
            case R.id.ferrari:
                c.putExtra("url", "http://www.gazzetta.it/Formula-1/08-06-2015/f1-ferrari-austria-12080165893.shtml");
                break;
            case R.id.gp:
                c.putExtra("url", "http://www.gazzetta.it/Formula-1/07-06-2015/f1-mercedes-hamilton-rosberg-12076284434.shtml");
                break;
        }
    }
}
