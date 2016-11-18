package com.example.nayan.kidsgame.utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;

import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.model.MLevel;
import com.example.nayan.kidsgame.model.MSubLevel;

import java.util.ArrayList;

/**
 * Created by NAYAN on 8/25/2016.
 */
public class Utils {
    public static String IMAGE_ON = "one", IMAGE_OFF = "two";
    public static String ASSETS_DOWNLOAD_MASSAGE = "downloaded";
    public static String CONVERT_NUM = "downloaded";
    public static int EASY = 1, MEDIUM = 2, HARD = 3;
    public static ArrayList<MSubLevel> mSubLevelArrayList;
    public static ArrayList<MLevel> levels;
    public static ArrayList<MContents> contents;
    public static ArrayList<MLevel> English;
    public static ArrayList<MLevel> Maths;
    public static ArrayList<MLevel> Drawing;
    public static boolean isSoundPlay = true;
    static MediaPlayer mediaPlayer;

    public static void getSound(Context context, int path) {
        if (isSoundPlay) {

            if (mediaPlayer != null) {
                mediaPlayer.stop();
                //mediaPlayer.reset();
                mediaPlayer.release();
            }
            Log.e("CONTEXT", "value :" + context + ":" + path);
            mediaPlayer = MediaPlayer.create(context, path);
            mediaPlayer.start();
            Log.e("log", "playing");
        }
    }

    public static String convertNum(String num) {
        if (num.length() > 0) {
            num = num.replace("0", "০").replace("1", "১").replace("2", "২")
                    .replace("3", "৩").replace("4", "৪").replace("5", "৫")
                    .replace("6", "৬").replace("7", "৭").replace("8", "৮")
                    .replace("9", "৯");
        }


        return num;
    }
    public static String databasePassKey(String emailName, String deviceId){
        String firstChOfEmail=emailName.substring(0,1);
        String lastChOfEmail=emailName.substring(emailName.indexOf("@")-1,emailName.indexOf("@"));
        String firstNumOfDeviceId=deviceId.substring(0,1);
        String secondNumOfDeviceId=deviceId.substring(deviceId.length()-1);
        return firstChOfEmail+lastChOfEmail+firstNumOfDeviceId+secondNumOfDeviceId;
    }

    public static void zoom(View view, boolean isLeft) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.2f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.2f);
        animator2.setDuration(2000);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.start();
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.start();
    }

    public static void rotation(View view, boolean isLeft) {
        view.setPivotX(view.getX() + view.getWidth() / 2);
        view.setPivotY(view.getY() + view.getHeight() / 2);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", 0, 180);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.setDuration(2000);
        animator.start();
    }
    public static boolean isInternetOn(Context context) {

        try {
            ConnectivityManager con = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo wifi, mobile;
            wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobile = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if (wifi.isConnectedOrConnecting() || mobile.isConnectedOrConnecting()) {
                return true;
            }


        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

}
