package com.cmput660.com.universityparking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ParkingWebViewClient extends WebViewClient {

    ProgressDialog _dialog ;
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith("youtube.com")) {
            return false;
        }


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }


}
