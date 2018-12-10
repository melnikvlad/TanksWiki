package com.example.vlad.tankwiki.data.model.detail.state;

import com.example.vlad.tankwiki.data.model.detail.beans.Ammo;
import com.example.vlad.tankwiki.data.model.detail.beans.AmmoType;
import com.example.vlad.tankwiki.data.model.detail.beans.Armor;
import com.example.vlad.tankwiki.data.model.detail.beans.Engine;
import com.example.vlad.tankwiki.data.model.detail.beans.Gun;
import com.example.vlad.tankwiki.data.model.detail.beans.Modules;
import com.example.vlad.tankwiki.data.model.detail.beans.Radio;
import com.example.vlad.tankwiki.data.model.detail.beans.Suspension;
import com.example.vlad.tankwiki.data.model.detail.beans.Turret;

import java.util.List;

public class ProfileData {
    private MainInfo mainInfo;
    private Ammo ammo;
    private Armor armor;
    private Gun gun;
    private Turret turret;
    private Radio radio;
    private Engine engine;
    private Suspension suspension;
    private static Modules defaultConfig;

    public static void setDefaultConfig(Modules modules) {
        defaultConfig = modules;
    }


    public static Modules getDefaultConfig() {
        return defaultConfig;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public void setAmmo(Ammo ammo) {
        this.ammo = ammo;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Turret getTurret() {
        return turret;
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Suspension getSuspension() {
        return suspension;
    }

    public void setSuspension(Suspension suspension) {
        this.suspension = suspension;
    }
}
