package com.example.nayan.kidsgame.model;

/**
 * Created by NAYAN on 9/26/2016.
 */

public class MContents {
    private String img;
    private String aud;
    private String txt;
    private String vid;
    private String sen;
    private int mid;
    private int lid;
    private int presentId;
    private int presentType;
    private String click;
    private int bestPoint;

    public int getBestPoint() {
        return bestPoint;

    }

    public void setBestPoint(int bestPoint) {
        this.bestPoint = bestPoint;

    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }


    public int getPresentType() {
        return presentType;
    }

    public void setPresentType(int presentType) {
        this.presentType = presentType;
    }

    public int getPresentId() {
        return presentId;
    }

    public void setPresentId(int presentId) {
        this.presentId = presentId;
    }


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }
}
