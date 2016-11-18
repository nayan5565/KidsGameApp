package com.example.nayan.kidsgame.model;

import java.util.ArrayList;

/**
 * Created by NAYAN on 10/4/2016.
 */

public class MQuestions {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String ques;
    private ArrayList<MItem> option;

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public ArrayList<MItem> getOption() {
        return option;
    }

    public void setOption(ArrayList<MItem> option) {
        this.option = option;
    }
}
