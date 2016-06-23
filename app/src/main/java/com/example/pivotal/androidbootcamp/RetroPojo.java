package com.example.pivotal.androidbootcamp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class RetroPojo {


    public List<Quarters> getQuarters() {
        return quarters;
    }

    public void setQuarters(List<Quarters> quarters) {
        this.quarters = quarters;
    }

    @SerializedName("quarters")
    @Expose
    private List<Quarters> quarters = new ArrayList<Quarters>();


}




