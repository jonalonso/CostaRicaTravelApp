package com.jsalazar.costaricatravel.utils;

import static com.jsalazar.costaricatravel.constants.adsValues.ADS_PERCENTAGE;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.jsalazar.costaricatravel.R;

import java.util.Random;

public class AdsController {
    private static InterstitialAd mInterstitialAd;
    public static void displayBanner(AdView mAdView){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public static void displayInterstitial(Activity context){
        int randomValue = new Random().nextInt(101);
        if (mInterstitialAd != null && randomValue< ADS_PERCENTAGE) {
            mInterstitialAd.show(context);
        }
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(context,context.getString(R.string.interstitial_ads), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }
}
