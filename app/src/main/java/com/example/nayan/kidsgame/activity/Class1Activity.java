package com.example.nayan.kidsgame.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.adapter.Class1AdapterOfBangla;
import com.example.nayan.kidsgame.model.MAsset;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.model.MLevel;
import com.example.nayan.kidsgame.utils.Global;
import com.example.nayan.kidsgame.utils.MyDatabase;
import com.example.nayan.kidsgame.utils.NLogic;
import com.example.nayan.kidsgame.utils.SpacesItemDecoration;
import com.example.nayan.kidsgame.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by NAYAN on 8/20/2016.
 */
public class Class1Activity extends AppCompatActivity implements View.OnClickListener {
    private static int levelId;
    private static MLevel mLevel;
    private static MContents mContents;
    private ArrayList<MContents> imageArrayList;
    private ImageView imgSetting;
    private RecyclerView recyclerView;
    private Class1AdapterOfBangla class1AdapterOfBangla;
    private MyDatabase database;
    public String subLevel;
    public String parentName;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);
//        VungleAdManager.getInstance(this).play();

        init();
        prepareDisplay();
        getLocalData();
        subLevel = getIntent().getStringExtra("subLevel");
        Global.INDEX_POSISION = getIntent().getIntExtra("index",0);
        parentName = getIntent().getStringExtra("parentLevel");
        txtName.setText(parentName + "(" + subLevel + ")");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void getLocalData() {
        imageArrayList = database.getContentsData();
        Collections.shuffle(imageArrayList);
        class1AdapterOfBangla.setData(imageArrayList);
//        ArrayList<MContents> realAssets = new ArrayList<>();
//        MyDatabase db = new MyDatabase(this);
//        realAssets = db.getContentsData(mContents.getLid());
//        imageArrayList = generateAssets(realAssets);
//        Collections.shuffle(imageArrayList);
//       class1AdapterOfBangla.setData(imageArrayList);
    }

    private ArrayList<MContents> generateAssets(ArrayList<MContents> realAssets) {
        int count = 20;
        ArrayList<MContents> tempAsset = new ArrayList<>();
        for (MContents mContents : realAssets) {

            tempAsset.add(mContents);
            count++;
            MAsset asset1 = new MAsset();
            asset1.setPresentId(count);
//            asset1.setPresentType(asset.getPresentType());
//            asset1.setHints(asset.getHints());
//            asset1.setImageOpen(asset.getImageOpen());
//            asset1.setImages(asset.getImages());
//            asset1.setLevelId(asset.getLevelId());
//            asset1.setSounds(asset.getSounds());
            tempAsset.add(mContents);
        }
        return tempAsset;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    private void init() {
        txtName = (TextView) findViewById(R.id.txtName);
        database = new MyDatabase(this);
        imgSetting = (ImageView) findViewById(R.id.imgseting);
        imgSetting.setOnClickListener(this);
        NLogic.getInstance(this).setLevel(mContents);
        imageArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new SpacesItemDecoration(7));
        class1AdapterOfBangla = new Class1AdapterOfBangla(this);

    }

    private void prepareDisplay() {
        int item= Utils.getScreenSize(this,100);
        recyclerView.setLayoutManager(new GridLayoutManager(this, item));
        recyclerView.setAdapter(class1AdapterOfBangla);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgseting) {
            final Dialog dialog = new Dialog(this);
            dialog.setTitle("Game Information");
            dialog.requestWindowFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
            dialog.setContentView(R.layout.dialog_setting);
            Button btnWin = (Button) dialog.findViewById(R.id.btnBack);
            btnWin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    NLogic.getInstance(Class1Activity.this).showHistory();
                }
            });

            dialog.show();
        }
    }
}
