package com.example.vlad.tankwiki.data.beans;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class TanksResponse {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("data")
    private Map<String, Tank> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, Tank> getData() {
        return data;
    }

    public void setData(Map<String, Tank> data) {
        this.data = data;
    }
}
