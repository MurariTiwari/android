package com.tiwarithetiger11gmail.rajasthan;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MURARI TIWARI on 11/28/2017.
 */

public class Modal {

    @SerializedName("name")
    String packname;
    @SerializedName("dur")
    int duration;

    @SerializedName("cost")
    int cost;

    public String getPackname() {
        return packname;
    }

    public int getCost() {
        return cost;
    }

    public int getDuration() {
        return duration;
    }
}
