package com.marketboost.layout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class menu2_Fragment extends Fragment {

    View rootview;
    @Nullable
    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        //identifies the webview
        WebView webView = (WebView) rootview.findViewById(R.id.webView);
        //loads the url
        webView.loadUrl("http://www.foodfindsasia.com/category/columnists/feed/");
        //cancels all hyperlinks
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        return rootview;
    }

}
