package com.example.vlad.tankwiki.data.model.detail.beans;

import java.util.List;

public class Ammo implements IModule {
    private List<AmmoType> types;

    public Ammo(List<AmmoType> types) {
        this.types = types;
    }

    public List<AmmoType> getTypes() {
        return types;
    }

    public void setTypes(List<AmmoType> types) {
        this.types = types;
    }
}
