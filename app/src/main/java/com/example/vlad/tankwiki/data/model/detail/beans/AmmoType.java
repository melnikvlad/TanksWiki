package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmmoType {
    @SerializedName("penetration")
    @Expose
    private List<Integer> penetration = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("damage")
    @Expose
    private List<Integer> damage = null;

    public List<Integer> getPenetration() {
        return penetration;
    }

    public void setPenetration(List<Integer> penetration) {
        this.penetration = penetration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getDamage() {
        return damage;
    }

    public void setDamage(List<Integer> damage) {
        this.damage = damage;
    }
}
