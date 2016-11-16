package com.example.nayan.kidsgame.model;

import java.util.ArrayList;

/**
 * Created by NAYAN on 8/18/2016.
 */
public class MLevel {
    ArrayList<MSubLevel> sub = new ArrayList<>();
    //String eId;
    private int lid;
    private String name;
    private String update_date;
    private int type;
    private int levelWinCount;
    private String total_slevel;

    public String getTotal_slevel() {
        return total_slevel;
    }

    public void setTotal_slevel(String total_slevel) {
        this.total_slevel = total_slevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelWinCount() {
        return levelWinCount;
    }

    public void setLevelWinCount(int levelWinCount) {
        this.levelWinCount = levelWinCount;
    }

    public ArrayList<MSubLevel> getSub() {
        return sub;
    }

    public void setSub(ArrayList<MSubLevel> sub) {
        this.sub = sub;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }


}
