package com.example.nayan.kidsgame.model;

/**
 * Created by NAYAN on 9/26/2016.
 */

public class MSubLevel {


    private int parentId;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    private String parentName;
    private int lid;
    private String name;
    private String coins_price;
    private String no_of_coins;
    private boolean lock=true;
    private int unlockNextLevel;
    private int indexPosision;

    public int getIndexPosision() {
        return indexPosision;
    }

    public void setIndexPosision(int indexPosision) {
        this.indexPosision = indexPosision;
    }

    public int getUnlockNextLevel() {
        return unlockNextLevel;
    }

    public void setUnlockNextLevel(int unlockNextLevel) {
        this.unlockNextLevel = unlockNextLevel;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getNo_of_coins() {
        return no_of_coins;
    }

    public void setNo_of_coins(String no_of_coins) {
        this.no_of_coins = no_of_coins;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoins_price() {
        return coins_price;
    }

    public void setCoins_price(String coins_price) {
        this.coins_price = coins_price;
    }


}
