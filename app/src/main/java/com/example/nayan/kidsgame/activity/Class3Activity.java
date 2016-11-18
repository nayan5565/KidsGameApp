package com.example.nayan.kidsgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.adapter.Class3AdapterOfBangla;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.utils.MyDatabase;
import com.example.nayan.kidsgame.utils.SpacesItemDecoration;
import com.example.nayan.kidsgame.utils.Utils;

import java.util.ArrayList;

/**
 * Created by NAYAN on 10/1/2016.
 */

public class Class3Activity extends AppCompatActivity {
    private static MContents mContents;
    private ArrayList<MContents> imageArrayList;
    private ImageView imgSetting;
    private RecyclerView recyclerView;
    private Class3AdapterOfBangla class3Adapter;
    private MyDatabase database;
    public String parentName;
    private TextView txtName;
    public String subLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class3_activity);
        init();
        prepareDisplay();
        getLocalData();
        subLevel = getIntent().getStringExtra("subLevel");
        parentName = getIntent().getStringExtra("parentLevel");
        txtName.setText(parentName + "(" + subLevel + ")");
    }

    private void prepareDisplay() {
        int item= Utils.getScreenSize(this,100);
        recyclerView.setLayoutManager(new GridLayoutManager(this, item));
        recyclerView.setAdapter(class3Adapter);
    }

    private void getLocalData() {
        ArrayList<MContents> realTxtSen = new ArrayList<>();
        realTxtSen = database.getContentsData();
        imageArrayList = generatesTxtSen(realTxtSen);
        class3Adapter.setData(imageArrayList);
    }

    private ArrayList<MContents> generatesTxtSen(ArrayList<MContents> realTxtSen) {
        int count = 20;
        ArrayList<MContents> tempTxtSen = new ArrayList<>();
        for (MContents mContents : realTxtSen) {
            tempTxtSen.add(mContents);
            count++;
            MContents contents = new MContents();
            contents.setSen(mContents.getSen());
            contents.setMid(mContents.getMid());
            contents.setPresentType(count);
            tempTxtSen.add(contents);
        }
        return tempTxtSen;
    }

    private void init() {
        database = new MyDatabase(this);
        txtName=(TextView)findViewById(R.id.txtsname);
//        imgSetting = (ImageView) findViewById(R.id.imgseting);
//        imgSetting.setOnClickListener(this);
//        NLogic.getInstance(this).setLevel(mContents);
        imageArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        class3Adapter = new Class3AdapterOfBangla(this);

    }
}
