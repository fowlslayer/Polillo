package com.example.classi;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = getIntent().getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webbing);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.loadUrl(url);
    }
}