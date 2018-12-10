package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Radio implements IModule{
    @SerializedName("tier")
    @Expose
    public Integer tier;
    @SerializedName("signal_range")
    @Expose
    public Integer signalRange;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("weight")
    @Expose
    public Integer weight;

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public Integer getSignalRange() {
        return signalRange;
    }

    public void setSignalRange(Integer signalRange) {
        this.signalRange = signalRange;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
