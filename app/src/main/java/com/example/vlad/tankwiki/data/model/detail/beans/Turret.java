package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Turret implements IModule {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("weight")
    @Expose
    public Integer weight;
    @SerializedName("view_range")
    @Expose
    public Integer viewRange;
    @SerializedName("hp")
    @Expose
    public Integer hp;
    @SerializedName("tag")
    @Expose
    public String tag;
    @SerializedName("traverse_speed")
    @Expose
    public Integer traverseSpeed;
    @SerializedName("traverse_right_arc")
    @Expose
    public Integer traverseRightArc;
    @SerializedName("tier")
    @Expose
    public Integer tier;
    @SerializedName("traverse_left_arc")
    @Expose
    public Integer traverseLeftArc;

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

    public Integer getViewRange() {
        return viewRange;
    }

    public void setViewRange(Integer viewRange) {
        this.viewRange = viewRange;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
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

    public Integer getTraverseRightArc() {
        return traverseRightArc;
    }

    public void setTraverseRightArc(Integer traverseRightArc) {
        this.traverseRightArc = traverseRightArc;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public Integer getTraverseLeftArc() {
        return traverseLeftArc;
    }

    public void setTraverseLeftArc(Integer traverseLeftArc) {
        this.traverseLeftArc = traverseLeftArc;
    }
}
