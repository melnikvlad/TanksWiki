package com.example.vlad.tankwiki.data.model.filter;

import java.util.ArrayList;
import java.util.List;

public class Tier extends FilterItem implements IFilterItem {
    private static final int TIER_COUNT = 10;
    private String value;


    public Tier(int pos, String val) {
        super(pos);
        value = val;
    }

    public static List<Tier> getSet() {
        List<Tier> defaultSet = new ArrayList<>();
        for (int i = 0; i < TIER_COUNT; i++) {
            defaultSet.add(new Tier(i, String.valueOf(i + 1)));
        }

        return defaultSet;
    }

    @Override
    public String getValue() {
        return value;
    }
}
