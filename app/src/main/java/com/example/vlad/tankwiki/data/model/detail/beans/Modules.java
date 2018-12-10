package com.example.vlad.tankwiki.data.model.detail.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modules {
    @SerializedName("gun_id")
    @Expose
    public Integer gunId;
    @SerializedName("suspension_id")
    @Expose
    public Integer suspensionId;
    @SerializedName("turret_id")
    @Expose
    public Integer turretId;
    @SerializedName("radio_id")
    @Expose
    public Integer radioId;
    @SerializedName("engine_id")
    @Expose
    public Integer engineId;

    public Integer getGunId() {
        return gunId;
    }

    public void setGunId(Integer gunId) {
        this.gunId = gunId;
    }

    public Integer getSuspensionId() {
        return suspensionId;
    }

    public void setSuspensionId(Integer suspensionId) {
        this.suspensionId = suspensionId;
    }

    public Integer getTurretId() {
        return turretId;
    }

    public void setTurretId(Integer turretId) {
        this.turretId = turretId;
    }

    public Integer getRadioId() {
        return radioId;
    }

    public void setRadioId(Integer radioId) {
        this.radioId = radioId;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public void setEngineId(Integer engineId) {
        this.engineId = engineId;
    }
}
