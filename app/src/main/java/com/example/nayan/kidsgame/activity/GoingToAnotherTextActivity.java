package com.example.nayan.kidsgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.adapter.LevelAdapter;
import com.example.nayan.kidsgame.model.MContents;
import com.example.nayan.kidsgame.utils.Global;
import com.example.nayan.kidsgame.utils.MyDatabase;
import com.example.nayan.kidsgame.utils.SpacesItemDecoration;
import com.example.nayan.kidsgame.utils.Utils;

import java.util.ArrayList;

/**
 * Created by NAYAN on 11/13/2016.
 */
public class GoingToAnotherTextActivity extends AppCompatActivity {
    private ArrayList<MContents> imageArrayList;
    private RecyclerView recyclerView;
    private LevelAdapter levelAdapter;
    private MyDatabase database;
    public String subLevel;
    public String parentName;
    private TextView txtName,txtText;
    private static GoingToAnotherTextActivity instance;
    int index;

    public static GoingToAnotherTextActivity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);
//        VungleAdManager.getInstance(this).play();

        init();
        prepareDisplay();
        getLocalData();
        subLevel = getIntent().getStringExtra("subLevel");
        parentName = getIntent().getStringExtra("parentLevel");
        txtName.setText(parentName + "(" + subLevel + ")");
        Global.INDEX_POSISION = getIntent().getIntExtra("index",0);


    }
    private void getLocalData() {
        imageArrayList = database.getContentsData();
        levelAdapter.setData(imageArrayList);
    }
    private void init() {
        txtName = (TextView) findViewById(R.id.txtName);
        database = new MyDatabase(this);

        imageArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        levelAdapter = new LevelAdapter(this);

    }

    private void prepareDisplay() {
        int item= Utils.getScreenSize(this,100);
        recyclerView.setLayoutManager(new GridLayoutManager(this, item));
        recyclerView.setAdapter(levelAdapter);
    }
    public void changeText(TextView view){
        if (index >= imageArrayList.size()) {
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            index = 0;
            return;
        } else {
            view.setText(imageArrayList.get(index).getTxt());

            index++;
        }
    }

}
