package com.example.pivotal.androidbootcamp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Quarters {
    public List<Pbp> getPbp() {
        return pbp;
    }

    public void setPbp(List<Pbp> pbp) {
        this.pbp = pbp;
    }

    @SerializedName("pbp")
    @Expose
    private List<Pbp> pbp = new ArrayList<Pbp>();
}
