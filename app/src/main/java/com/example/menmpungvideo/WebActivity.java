package com.example.menmpungvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView =findViewById(R.id.webView);
        webView.loadUrl("https://telkomuniversity.ac.id/");
    }
}
