package com.example.nayan.kidsgame.model;

/**
 * Created by NAYAN on 11/16/2016.
 */
public class MLock {
    private int unlockNextLevel,id,bestPoint;

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

    public int getUnlockNextLevel() {
        return unlockNextLevel;
    }

    public void setUnlockNextLevel(int unlockNextLevel) {
        this.unlockNextLevel = unlockNextLevel;
    }
}
