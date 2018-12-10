package com.example.vlad.tankwiki.data.model.tanks;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Tank {
    @SerializedName("tank_id")
    @Expose
    private int tankId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("is_gift")
    @Expose
    private boolean isGift;
    @SerializedName("is_premium")
    @Expose
    private boolean isPremium;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nation")
    @Expose
    private String nation;
    @SerializedName("price_credit")
    @Expose
    private int priceCredit;
    @SerializedName("price_gold")
    @Expose
    private int priceGold;
    @SerializedName("tier")
    @Expose
    private int tier;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("modules_tree")
    @Expose
    private Map<String, Module> modules;
    @SerializedName("radios")
    @Expose
    private List<Integer> radios;
    @SerializedName("suspensions")
    @Expose
    private List<Integer> suspensions;
    @SerializedName("provisions")
    @Expose
    private List<Integer> provisions;
    @SerializedName("engines")
    @Expose
    private List<Integer> engines;
    @SerializedName("guns")
    @Expose
    private List<Integer> guns;
    @SerializedName("turrets")
    @Expose
    private List<Integer> turrets;


    public int getTankId() {
        return tankId;
    }

    public void setTankId(int tankId) {
        this.tankId = tankId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(int priceCredit) {
        this.priceCredit = priceCredit;
    }

    public int getPriceGold() {
        return priceGold;
    }

    public void setPriceGold(int priceGold) {
        this.priceGold = priceGold;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Images getImage() {
        return images;
    }

    public void setImage(Images images) {
        this.images = images;
    }

    public List<Integer> getRadios() {
        return radios;
    }

    public void setRadios(List<Integer> radios) {
        this.radios = radios;
    }

    public List<Integer> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(List<Integer> suspensions) {
        this.suspensions = suspensions;
    }

    public List<Integer> getProvisions() {
        return provisions;
    }

    public void setProvisions(List<Integer> provisions) {
        this.provisions = provisions;
    }

    public List<Integer> getEngines() {
        return engines;
    }

    public void setEngines(List<Integer> engines) {
        this.engines = engines;
    }

    public List<Integer> getGuns() {
        return guns;
    }

    public void setGuns(List<Integer> guns) {
        this.guns = guns;
    }

    public List<Integer> getTurrets() {
        return turrets;
    }

    public void setTurrets(List<Integer> turrets) {
        this.turrets = turrets;
    }

    public Map<String, Module> getModules() {
        return modules;
    }

    public void setModules(Map<String, Module> modules) {
        this.modules = modules;
    }

    @NonNull
    @Override
    public String toString() {
        return "Tank{" +
                "tankId=" + tankId +
                ", description='" + description + '\'' +
                ", isGift=" + isGift +
                ", isPremium=" + isPremium +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", priceCredit=" + priceCredit +
                ", priceGold=" + priceGold +
                ", tier=" + tier +
                ", type='" + type + '\'' +
                ", image='" + images + '\'' +
                '}';
    }
}
