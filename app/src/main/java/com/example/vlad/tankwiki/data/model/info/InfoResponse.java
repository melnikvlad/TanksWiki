package com.example.vlad.tankwiki.data.model.info;

import com.google.gson.annotations.SerializedName;

public class InfoResponse {
    @SerializedName("data")
    private InfoData infoData;

    public InfoData getInfoData() {
        return infoData;
    }

    public void setInfoData(InfoData infoData) {
        this.infoData = infoData;
    }
}
