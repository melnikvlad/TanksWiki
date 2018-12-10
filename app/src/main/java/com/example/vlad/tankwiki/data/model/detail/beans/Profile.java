package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profile {
    @SerializedName("engine")
    @Expose
    public Engine engine;
    @SerializedName("max_ammo")
    @Expose
    public Integer maxAmmo;
    @SerializedName("suspension")
    @Expose
    public Suspension suspension;
    @SerializedName("weight")
    @Expose
    public Integer weight;
    @SerializedName("armor")
    @Expose
    public Armor armor;
    @SerializedName("hp")
    @Expose
    public Integer hp;
    @SerializedName("profile_id")
    @Expose
    public String profileId;
    @SerializedName("modules")
    @Expose
    public Modules modules;
    @SerializedName("gun")
    @Expose
    public Gun gun;
    @SerializedName("is_default")
    @Expose
    public Boolean isDefault;
    @SerializedName("turret")
    @Expose
    public Turret turret;
    @SerializedName("hull_weight")
    @Expose
    public Integer hullWeight;
    @SerializedName("radio")
    @Expose
    public Radio radio;
    @SerializedName("speed_forward")
    @Expose
    public Integer speedForward;
    @SerializedName("hull_hp")
    @Expose
    public Integer hullHp;
    @SerializedName("speed_backward")
    @Expose
    public Integer speedBackward;
    @SerializedName("tank_id")
    @Expose
    public Integer tankId;
    @SerializedName("ammo")
    @Expose
    public List<AmmoType> ammo = null;
    @SerializedName("max_weight")
    @Expose
    public Integer maxWeight;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(Integer maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Turret getTurret() {
        return turret;
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

    public Integer getHullWeight() {
        return hullWeight;
    }

    public void setHullWeight(Integer hullWeight) {
        this.hullWeight = hullWeight;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Integer getSpeedForward() {
        return speedForward;
    }

    public void setSpeedForward(Integer speedForward) {
        this.speedForward = speedForward;
    }

    public Integer getHullHp() {
        return hullHp;
    }

    public void setHullHp(Integer hullHp) {
        this.hullHp = hullHp;
    }

    public Integer getSpeedBackward() {
        return speedBackward;
    }

    public void setSpeedBackward(Integer speedBackward) {
        this.speedBackward = speedBackward;
    }

    public Integer getTankId() {
        return tankId;
    }

    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

    public List<AmmoType> getAmmo() {
        return ammo;
    }

    public void setAmmo(List<AmmoType> ammo) {
        this.ammo = ammo;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }
}
