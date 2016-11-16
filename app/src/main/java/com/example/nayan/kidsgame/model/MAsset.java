package com.example.nayan.kidsgame.model;

/**
 * Created by NAYAN on 8/23/2016.
 */
public class MAsset {
    String images,sounds,hints;
    int imageOpen;
    int presentId;
    int presentType;

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    int levelId;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSounds() {
        return sounds;
    }

    public void setSounds(String sounds) {
        this.sounds = sounds;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public int getImageOpen() {
        return imageOpen;
    }

    public void setImageOpen(int imageOpen) {
        this.imageOpen = imageOpen;
    }

    public int getPresentId() {
        return presentId;
    }

    public void setPresentId(int presentId) {
        this.presentId = presentId;
    }

    public int getPresentType() {
        return presentType;
    }

    public void setPresentType(int presentType) {
        this.presentType = presentType;
    }
}
