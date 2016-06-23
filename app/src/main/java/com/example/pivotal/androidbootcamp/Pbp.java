package com.example.pivotal.androidbootcamp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pbp {

    public List<Actions> getActions() {
        return actions;
    }

    public void setActions(List<Actions> actions) {
        this.actions = actions;
    }

    @SerializedName("actions")
    @Expose
    private List<Actions> actions = new ArrayList<Actions>();
}
