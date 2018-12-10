package com.example.vlad.tankwiki.data.model.tanks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Module {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("next_modules")
    @Expose
    private List<Integer> nextModules = null;
    @SerializedName("next_tanks")
    @Expose
    private Object nextTanks;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("price_xp")
    @Expose
    private Integer priceXp;
    @SerializedName("price_credit")
    @Expose
    private Integer priceCredit;
    @SerializedName("module_id")
    @Expose
    private Integer moduleId;
    @SerializedName("type")
    @Expose
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNextModules() {
        return nextModules;
    }

    public void setNextModules(List<Integer> nextModules) {
        this.nextModules = nextModules;
    }

    public Object getNextTanks() {
        return nextTanks;
    }

    public void setNextTanks(Object nextTanks) {
        this.nextTanks = nextTanks;
    }

    public Boolean IsDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getPriceXp() {
        return priceXp;
    }

    public void setPriceXp(Integer priceXp) {
        this.priceXp = priceXp;
    }

    public Integer getPriceCredit() {
        return priceCredit;
    }

    public void setPriceCredit(Integer priceCredit) {
        this.priceCredit = priceCredit;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
