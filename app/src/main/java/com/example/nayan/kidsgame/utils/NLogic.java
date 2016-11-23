package com.example.nayan.kidsgame.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.activity.SubLevelActivity;
import com.example.nayan.kidsgame.adapter.Class3AdapterOfBangla;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.model.MLock;
import com.example.nayan.kidsgame.model.MSubLevel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by NAYAN on 8/20/2016.
 */
public class NLogic {
    private static final String MyPREFERENCE = "mypref";
    private int previousId, count, counter, clickCount, matchWinCount, previousType, gameWinCount, previousPoint, presentPoint, bestPoint;
    private static NLogic nLogic;

    private ArrayList<MContents> list;
    private SharedPreferences preferences;
    private Context context;
    private Handler handler = new Handler();
    private RecyclerView.Adapter gameAdapter;
    private MContents mContents = new MContents();
    //    private MLock mLock = new MLock();
    private Class3AdapterOfBangla class3Adapter;


    private NLogic() {

    }

    public static NLogic getInstance(Context context1) {

//        if (nLogic == null) {
//            nLogic = new NLogic();
//        }
        nLogic = new NLogic();
        nLogic.context = context1;

        return nLogic;

    }

    public void callData(ArrayList<MContents> list, RecyclerView.Adapter adapter) {
        this.list = list;
        this.gameAdapter = adapter;

//        Utils.bestPoint = Utils.presentPoint;
//        gameWinCount = mContents.getLevelWinCount();


    }

    public void setLevel(MContents mContents) {
        this.mContents = mContents;
    }

    private void saveDb() {
        MyDatabase db = new MyDatabase(context);
        MLock lock = new MLock();

        lock.setId(Global.SUB_LEVEL_ID);
        lock.setBestPoint(Utils.bestPoint);
        db.addLockData(lock);
        lock = new MLock();
        MSubLevel mSubLevel = SubLevelActivity.mSubLevels.get(Global.INDEX_POSISION + 1);
        lock.setId(mSubLevel.getLid());
        lock.setUnlockNextLevel(1);
        db.addLockData(lock);
//        db.addLevelFromJson(mContents);
    }


    public void showInformation(final int listSize) {
        presentPoint = pointCount(listSize);
        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Class1Activity Over");
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.row_dialog);
        TextView textView = (TextView) dialog.findViewById(R.id.txt);
        textView.setText("Point : " + presentPoint);
        Button newGame = (Button) dialog.findViewById(R.id.btnNewGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.getSound(context, R.raw.shuffle);
                resetList(listSize);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void textClick(MContents mContents, int listSize) {
        counter++;
        Log.e("counter", "is" + counter);

        //don't work if mid !=1 at first time because first time click count=1
        if (mContents.getMid() == clickCount + 1) {
            //clickcount store present mid
            clickCount = mContents.getMid();
            count++;
            Toast.makeText(context, mContents.getTxt(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "wrong click", Toast.LENGTH_SHORT).show();
        }
        if (count == listSize) {

            savePoint(listSize);
            resetList(listSize);
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_level_cleared);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            TextView txtPoint = (TextView) dialog.findViewById(R.id.txtLevelPoint);
            TextView txtBestPoint = (TextView) dialog.findViewById(R.id.txtLevelBestPoint);
            TextView txtScore = (TextView) dialog.findViewById(R.id.txtLevelScore);
            txtBestPoint.setText("" + Utils.bestPoint);
            txtScore.setText(presentPoint + "");
            if (presentPoint == 50) {
                txtPoint.setText(Utils.getIntToStar(1));
            } else if (presentPoint == 75) {
                txtPoint.setText(Utils.getIntToStar(2));
            } else if (presentPoint == 100) {
                txtPoint.setText(Utils.getIntToStar(3));
            } else txtPoint.setText(Utils.getIntToStar(0));
            dialog.show();
            Toast.makeText(context, "game over", Toast.LENGTH_SHORT).show();

        }


    }

    public void imageClick(final MContents mImage, int pos, final int listSize) {
        Log.e("Loge", "present id ::" + mImage.getPresentId());

//
        if (previousType == mImage.getPresentType() || count > 1 || mImage.getClick() == Utils.IMAGE_ON) {
            Log.e("previoustype", "same: " + mImage.getPresentType());
            Log.e("click over 1", "count: " + count);
            Toast.makeText(context, "same click", Toast.LENGTH_SHORT).show();
            return;
        }
        clickCount++;

        list.get(pos).setClick(Utils.IMAGE_ON);
        //list er position a click korbo set image on thakbe and
        // image match korle ota image on data thakbe karon oy image on data
        // thaka image abar click korle jate age click kora ase seta janabe
        gameAdapter.notifyDataSetChanged();
        count++;
        Log.e("click", "count: " + count);
        Utils.getSound(context, R.raw.click);
        if (count == 2) {

            if (previousId == mImage.getMid()) {
                Toast.makeText(context, "match", Toast.LENGTH_SHORT).show();
                Log.e("log", "matchwincount : " + matchWinCount);
                Log.e("preivious id", "MID : " + previousId);
                matchWinCount++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Utils.getSound(context, R.raw.match2);
                        count = 0;


                    }
                }, 800);


                if (matchWinCount == listSize / 2) {
//                    VungleAdManager.getInstance(context).play();
                    MSubLevel mSubLevel = SubLevelActivity.mSubLevels.get(Global.INDEX_POSISION + 1);
                    MLock mLock = new MLock();
                    mLock.setId(mSubLevel.getLid());
                    mLock.setUnlockNextLevel(1);
                    MyDatabase db = new MyDatabase(context);
                    db.addLockData(mLock);
                    Toast.makeText(context, "game over", Toast.LENGTH_SHORT).show();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            // Utils.getSound(context,R.raw.gameover);
//                           /* game.animation();*/
//                        }
//                    }, 1000);
                    //starting game over
//                    gameWinCount = mContents.getLevelWinCount();
                    gameWinCount++;
                    Log.e("log", "game over : " + gameWinCount);
//                    mContents.setLevelWinCount(gameWinCount);
//                    savePoint(listSize);
//                    showInformation(listSize);
                    resetList(listSize);
//                    matchWinCount = 0;
//                    Log.e("match win", "zero" + matchWinCount);
//                    count = 0;
//                    Log.e("count", "zero" + count);
//                    previousType = 0;
//                    Log.e("prevousType", "zero" + previousType);
//                    for (int i = 0; i < listSize; i++) {
////
//                        list.get(i).setClick(Utils.IMAGE_OFF);
//                    }
//
//                    gameAdapter.notifyDataSetChanged();
                }
//                previousType = 0;

                return;
            } else {

                final int perevious = previousType;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Utils.getSound(context, R.raw.fail);
                        for (int i = 0; i < listSize; i++) {
                            if (list.get(i).getPresentType() == perevious || list.get(i).getPresentType() == mImage.getPresentType()) {
                                list.get(i).setClick(Utils.IMAGE_OFF);
                                Toast.makeText(context, "did not match or same click", Toast.LENGTH_SHORT).show();
//
                            }
                        }
                        gameAdapter.notifyDataSetChanged();
                        count = 0;
                    }
                }, 1000);
                previousId = 0;
                previousType = 0;
                return;
            }
        }
        previousId = mImage.getMid();
        previousType = mImage.getPresentType();
    }


    private void resetList(int listSize) {
        for (int i = 0; i < listSize; i++) {
            list.get(i).setClick(Utils.IMAGE_OFF);
        }
        Collections.shuffle(list);
        clickCount = 0;
        matchWinCount = 0;
        previousType = 0;
        previousId = 0;
        count = 0;
        counter = 0;
        gameAdapter.notifyDataSetChanged();

    }

    private void savePoint(int listSize) {


        presentPoint = pointCount(listSize);
//        Utils.presentPoint = pointCount(listSize);
//
//        if (Utils.presentPoint > Utils.bestPoint) {
//            Utils.bestPoint = Utils.presentPoint;
//            saveDb();
//        }
        if (presentPoint > Utils.bestPoint) {

            Utils.bestPoint = presentPoint;
            saveDb();

        }

    }

    private int pointCount(int listSize) {
        int point = 50;

        if (counter == listSize) {
            point = 100;
        } else if (counter > listSize && counter <= listSize + listSize / 2) {
            point = 75;
        }
        Log.e("pint", "point is" + point);
        return point;
    }

    public String showHistory() {

        Dialog dialog = new Dialog(context);
        dialog.setTitle("Status");
        dialog.setContentView(R.layout.row_d_best_point);
        TextView textView = (TextView) dialog.findViewById(R.id.txtBetPoint);
//        textView.setText("best point: " + mContents.getBestpoint() + "\nWin count : " + mContents.getLevelWinCount());
        TextView textView1 = (TextView) dialog.findViewById(R.id.txtTotalWin);
//        textView1.setText("no of total win: " + gameWinCount + "");
        dialog.show();
        return "";
    }

}
