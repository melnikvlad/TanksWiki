package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Engine implements IModule {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("power")
    @Expose
    private Integer power;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("fire_chance")
    @Expose
    private Double fireChance;
    @SerializedName("tier")
    @Expose
    private Integer tier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getFireChance() {
        return fireChance;
    }

    public void setFireChance(Double fireChance) {
        this.fireChance = fireChance;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
}
