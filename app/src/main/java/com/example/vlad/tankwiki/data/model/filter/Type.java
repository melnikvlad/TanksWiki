package com.example.vlad.tankwiki.data.model.filter;

import java.util.ArrayList;
import java.util.List;

public class Type extends FilterItem implements IFilterItem {
    private static final int TYPE_COUNT = 5;
    public static final String TYPE_HT = "heavyTank";
    public static final String TYPE_MT = "mediumTank";
    public static final String TYPE_LT = "lightTank";
    public static final String TYPE_SPG = "SPG";
    public static final String TYPE_AT_SPG = "AT-SPG";

    private static String[] types = {TYPE_HT, TYPE_MT, TYPE_LT, TYPE_SPG, TYPE_AT_SPG};

    private String value;
    private int position;

    private Type(int pos, String val) {
        super(pos);
        value = val;
        position = pos;
    }

    public static List<Type> getSet() {
        List<Type> defaultSet = new ArrayList<>();
        for (int i = 0; i < TYPE_COUNT; i++) {
            defaultSet.add(new Type(i, types[i]));
        }

        return defaultSet;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String getValue() {
        return value;
    }
}
