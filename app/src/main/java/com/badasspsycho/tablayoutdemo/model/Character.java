package com.badasspsycho.tablayoutdemo.model;

import android.support.annotation.IdRes;

public class Character {

    private String mName;
    @IdRes
    private int mImageId;

    public Character(String name, int imageId) {
        mName = name;
        mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }
}
