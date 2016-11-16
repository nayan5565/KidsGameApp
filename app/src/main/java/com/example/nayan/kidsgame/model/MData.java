package com.example.nayan.kidsgame.model;

/**
 * Created by NAYAN on 8/3/2016.
 */
public class MData {
    int id;
    int type;
    int status;
    String image;
    int bestPoint;

    public int getBestPoint() {
        return bestPoint;
    }

    public void setBestPoint(int bestPoint) {
        this.bestPoint = bestPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
