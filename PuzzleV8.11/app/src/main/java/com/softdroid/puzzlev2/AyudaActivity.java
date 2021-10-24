package com.softdroid.puzzlev2;


import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class AyudaActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        WebView webView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());


        webView.loadUrl("file:///android_asset/www/index.html");
    }
}