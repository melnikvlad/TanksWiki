package com.example.vlad.tankwiki.data.model;

import java.util.List;

public class Data {
    private List<Tank> tanks;

    public Data(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }
}
