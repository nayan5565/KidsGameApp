package com.example.nayan.kidsgame.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nayan.kidsgame.R;
import com.example.nayan.kidsgame.adapter.MathLevelAdapter;
import com.example.nayan.kidsgame.model.MItem;
import com.example.nayan.kidsgame.model.MLock;
import com.example.nayan.kidsgame.model.MQuestions;
import com.example.nayan.kidsgame.model.MSubLevel;
import com.example.nayan.kidsgame.utils.Global;
import com.example.nayan.kidsgame.utils.MyDatabase;
import com.example.nayan.kidsgame.utils.Utils;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

public class MathLevel_1Activity extends AppCompatActivity {
    private ArrayList<MQuestions> mQuestionses;
    private RecyclerView recyclerView;
    private MathLevelAdapter matchLevelAdapter;
    private TextView txtQuestion;
    MQuestions mQuestions = new MQuestions();
    private static MathLevel_1Activity instance;
    int index;
    MItem mItem = new MItem();
    private Gson gson;
    MyDatabase myDatabase;

    public static MathLevel_1Activity getInstance() {

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_level_1);
        instance = this;
        init();
//        generate();
        getOnlineData();
//        preParedisplay();
        Global.INDEX_POSISION = getIntent().getIntExtra("index", 0);
    }

    private void init() {
        myDatabase = new MyDatabase(this);
        mQuestionses = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        txtQuestion = (TextView) findViewById(R.id.tct);

        matchLevelAdapter = new MathLevelAdapter(this);
        gson = new Gson();


    }

    private void getOnlineData() {


        if (!Utils.isInternetOn(this)) {
            Toast.makeText(this, "lost internet connection", Toast.LENGTH_SHORT).show();
            return;
        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.API_MATH, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try {
                            JSONArray data = response.getJSONArray("data");
                            MQuestions[] ques = gson.fromJson(data.toString(), MQuestions[].class);
//                            myDatabase.addQuesData(mQuestions);
//                            myDatabase.addOptonData(mItem);
                            mQuestionses = new ArrayList<MQuestions>(Arrays.asList(ques));
                            preParedisplay();
                        } catch (Exception e) {

                        }

                    }
                }
        );
    }

    private void getLocalData() {

    }

    public void preParedisplay() {
//        mQuestionses=myDatabase.getQuesData();
        if (index >= mQuestionses.size()) {
            MSubLevel mSubLevel = SubLevelActivity.mSubLevels.get(Global.INDEX_POSISION + 1);
            MLock mLock = new MLock();
            mLock.setId(mSubLevel.getLid());
            mLock.setUnlockNextLevel(1);
            MyDatabase db = new MyDatabase(this);
            db.addLockData(mLock);
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            index = 0;
            return;
        } else {
            txtQuestion.setText(mQuestionses.get(index).getQues());
            matchLevelAdapter.setData(mQuestionses.get(index).getOption());
            index++;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(matchLevelAdapter);
    }

    private void generate() {
        ArrayList<MItem> mItems = new ArrayList<>();
        MQuestions questions = new MQuestions();
        questions.setQues("2+2");
        MItem mItem = new MItem();
        mItem.setItem(2);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(4);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(6);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(4);
        mItem.setTag(1);

        mItems.add(mItem);

        questions.setOption(mItems);

        mQuestionses.add(questions);

        mItems = new ArrayList<>();
        questions = new MQuestions();
        questions.setQues("5+5=?");

        mItem = new MItem();
        mItem.setItem(10);
        mItem.setTag(1);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(4);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(6);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(8);
        mItem.setTag(0);

        mItems.add(mItem);

        questions.setOption(mItems);

        mQuestionses.add(questions);

        mItems = new ArrayList<>();
        questions = new MQuestions();
        questions.setQues("2+5");
        mItem = new MItem();
        mItem.setItem(2);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(7);
        mItem.setTag(1);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(6);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(8);
        mItem.setTag(0);

        mItems.add(mItem);

        questions.setOption(mItems);


        mQuestionses.add(questions);

        mItems = new ArrayList<>();
        questions = new MQuestions();
        questions.setQues("7+2");
        mItem = new MItem();
        mItem.setItem(2);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(4);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(9);
        mItem.setTag(1);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(8);
        mItem.setTag(0);

        mItems.add(mItem);

        questions.setOption(mItems);


        mQuestionses.add(questions);

        mItems = new ArrayList<>();
        questions = new MQuestions();
        questions.setQues("8+2");
        mItem = new MItem();
        mItem.setItem(2);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(4);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(6);
        mItem.setTag(0);

        mItems.add(mItem);

        mItem = new MItem();
        mItem.setItem(10);
        mItem.setTag(1);

        mItems.add(mItem);

        questions.setOption(mItems);

        mQuestionses.add(questions);


    }
}
