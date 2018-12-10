package com.example.vlad.tankwiki.data.model.detail;

import com.example.vlad.tankwiki.data.model.detail.beans.Profile;
import com.example.vlad.tankwiki.data.model.tanks.Meta;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class DetailResponse {
    @SerializedName("meta")
    private Meta meta;
    @SerializedName("data")
    private Map<String, Profile> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Map<String, Profile> getData() {
        return data;
    }

    public void setData(Map<String, Profile> data) {
        this.data = data;
    }
}
