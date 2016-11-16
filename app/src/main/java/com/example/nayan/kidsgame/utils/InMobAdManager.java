package com.example.nayan.kidsgame.utils;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by NAYAN on 9/22/2016.
 */

public class InMobAdManager {
    private static InMobAdManager instance;

    public static InMobAdManager getInstance(Context context) {
        if (instance == null) {
            instance = new InMobAdManager();
            MobileAds.initialize(context, "ca-app-pub-3852049226216249~9232307213");
        }
        return instance;
    }

    public void loadAd(AdView mAdView){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
