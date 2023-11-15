package com.example.costaricatravel.utils;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdsController {
    public static void displayBanner(AdView mAdView){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
