package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Armor implements IModule{
    @SerializedName("turret")
    @Expose
    private ArmorTurret turret;
    @SerializedName("hull")
    @Expose
    private ArmorHull hull;

    public ArmorTurret getTurret() {
        return turret;
    }

    public void setTurret(ArmorTurret turret) {
        this.turret = turret;
    }

    public ArmorHull getHull() {
        return hull;
    }

    public void setHull(ArmorHull hull) {
        this.hull = hull;
    }
}
