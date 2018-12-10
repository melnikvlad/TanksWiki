package com.example.vlad.tankwiki.data.model.detail.state;

public class MainInfo {
    private String name;
    private String description;
    private int tier;
    private String type;
    private int price_xp;
    private int price_credit;
    private String image;

    public MainInfo(String name, String description, int tier, String type, int price_xp, int price_credit, String image) {
        this.name = name;
        this.description = description;
        this.tier = tier;
        this.type = type;
        this.price_xp = price_xp;
        this.price_credit = price_credit;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPriceXp() {
        return price_xp;
    }

    public void setPriceXp(int price_xp) {
        this.price_xp = price_xp;
    }

    public int getPriceCredit() {
        return price_credit;
    }

    public void setPriceCredit(int price_credit) {
        this.price_credit = price_credit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
