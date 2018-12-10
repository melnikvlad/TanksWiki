package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gun implements IModule {
    @SerializedName("move_down_arc")
    @Expose
    private Double moveDownArc;
    @SerializedName("caliber")
    @Expose
    private Double caliber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("move_up_arc")
    @Expose
    private Double moveUpArc;
    @SerializedName("fire_rate")
    @Expose
    private Double fireRate;
    @SerializedName("dispersion")
    @Expose
    private Double dispersion;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("traverse_speed")
    @Expose
    private Double traverseSpeed;
    @SerializedName("reload_time")
    @Expose
    private Double reloadTime;
    @SerializedName("tier")
    @Expose
    private Double tier;
    @SerializedName("aim_time")
    @Expose
    private Double aimTime;

    public Double getMoveDownArc() {
        return moveDownArc;
    }

    public void setMoveDownArc(Double moveDownArc) {
        this.moveDownArc = moveDownArc;
    }

    public Double getCaliber() {
        return caliber;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMoveUpArc() {
        return moveUpArc;
    }

    public void setMoveUpArc(Double moveUpArc) {
        this.moveUpArc = moveUpArc;
    }

    public Double getFireRate() {
        return fireRate;
    }

    public void setFireRate(Double fireRate) {
        this.fireRate = fireRate;
    }

    public Double getDispersion() {
        return dispersion;
    }

    public void setDispersion(Double dispersion) {
        this.dispersion = dispersion;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getTraverseSpeed() {
        return traverseSpeed;
    }

    public void setTraverseSpeed(Double traverseSpeed) {
        this.traverseSpeed = traverseSpeed;
    }

    public Double getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Double reloadTime) {
        this.reloadTime = reloadTime;
    }

    public Double getTier() {
        return tier;
    }

    public void setTier(Double tier) {
        this.tier = tier;
    }

    public Double getAimTime() {
        return aimTime;
    }

    public void setAimTime(Double aimTime) {
        this.aimTime = aimTime;
    }
}


