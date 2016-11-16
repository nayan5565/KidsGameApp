package com.example.nayan.kidsgame.utils;

import android.content.Context;

import com.vungle.publisher.AdConfig;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VunglePub;


/**
 * Created by NAYAN on 9/20/2016.
 */
public class  VungleAdManager {
    final static VunglePub vunglePub = VunglePub.getInstance();
    private static VungleAdManager instance;

    public static VungleAdManager getInstance(Context context) {
        if (instance == null) {
            instance = new VungleAdManager();
            final String app_id = "57e1888280dcaa721e00004e";
            vunglePub.init(context, app_id);
        }

        return instance;
    }

    private VungleAdManager() {
        // initialize the Publisher SDK


    }

    public void play() {
        if (vunglePub.isAdPlayable()) ;
        vunglePub.playAd();
    }

    public void playAdOptions() {
        // create a new AdConfig object
        final AdConfig overrideConfig = new AdConfig();

        // set any configuration options you like.
        overrideConfig.setOrientation(Orientation.matchVideo);
        overrideConfig.setSoundEnabled(false);
        overrideConfig.setBackButtonImmediatelyEnabled(false);
        overrideConfig.setPlacement("storefront");
        //overrideConfig.setExtra1("LaunchedFromNotification");

        // the overrideConfig object will only affect this ad play.
        vunglePub.playAd(overrideConfig);
    }
}
