package com.test.samimchala.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private float speed;
    @SerializedName("deg")
    @Expose
    private int deg;

    public float getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }
}
