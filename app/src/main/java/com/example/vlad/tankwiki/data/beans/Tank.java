package com.example.vlad.tankwiki.data.beans;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public Tank(int tankId,
                String description,
                boolean isGift,
                boolean isPremium,
                String name,
                String nation,
                int priceCredit,
                int priceGold,
                int tier,
                String type,
                String image) {
        this.tankId = tankId;
        this.description = description;
        this.isGift = isGift;
        this.isPremium = isPremium;
        this.name = name;
        this.nation = nation;
        this.priceCredit = priceCredit;
        this.priceGold = priceGold;
        this.tier = tier;
        this.type = type;
        this.images = images;
    }

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
