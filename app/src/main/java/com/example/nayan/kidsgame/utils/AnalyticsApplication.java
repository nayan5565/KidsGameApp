package com.example.nayan.kidsgame.utils;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by NAYAN on 9/22/2016.
 */

public class AnalyticsApplication extends Application {
    private Tracker tracker;
    synchronized public Tracker getDefaultTracker(){
        if (tracker==null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            tracker = analytics.newTracker("UA-84563493-1");
        }
        return tracker;
    }
}
