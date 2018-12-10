package com.example.vlad.tankwiki.data.model.tanks;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("small_icon")
    @Expose
    private String small;
    @SerializedName("contour_icon")
    @Expose
    private String contour;
    @SerializedName("big_icon")
    @Expose
    private String big;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getContour() {
        return contour;
    }

    public void setContour(String contour) {
        this.contour = contour;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    @NonNull
    @Override
    public String toString() {
        return "Images{" +
                "small='" + small + '\'' +
                ", contour='" + contour + '\'' +
                ", big='" + big + '\'' +
                '}';
    }
}
