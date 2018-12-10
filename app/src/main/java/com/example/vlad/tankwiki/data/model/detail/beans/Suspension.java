package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suspension implements IModule {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("weight")
    @Expose
    public Integer weight;
    @SerializedName("load_limit")
    @Expose
    public Integer loadLimit;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("traverse_speed")
    @Expose
    public Integer traverseSpeed;
    @SerializedName("tier")
    @Expose
    public Integer tier;

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

    public Integer getLoadLimit() {
        return loadLimit;
    }

    public void setLoadLimit(Integer loadLimit) {
        this.loadLimit = loadLimit;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getTraverseSpeed() {
        return traverseSpeed;
    }

    public void setTraverseSpeed(Integer traverseSpeed) {
        this.traverseSpeed = traverseSpeed;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
}
