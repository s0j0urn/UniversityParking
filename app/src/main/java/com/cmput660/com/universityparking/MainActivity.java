package com.cmput660.com.universityparking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView parkingWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parkingWebView = (WebView) findViewById(R.id.webView);

        if (new CheckWiFi().isNetworkConnected(MainActivity.this)){
            parkingWebView.setWebViewClient(new ParkingWebViewClient());
            WebSettings parkingWebSettings = parkingWebView.getSettings();
            parkingWebSettings.setJavaScriptEnabled(true);
            parkingWebView.loadUrl("http://www.youtube.com");

        }
        else
        {
            parkingWebView.loadUrl("file:///android_asset/error.html");
        }
    }

    public void onBackPressed() {
        if(parkingWebView.canGoBack()) {
            parkingWebView.goBack();
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
