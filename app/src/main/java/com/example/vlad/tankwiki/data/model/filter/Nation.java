package com.example.vlad.tankwiki.data.model.filter;

import java.util.ArrayList;
import java.util.List;

public class Nation extends FilterItem implements IFilterItem {
    private static final int NATION_COUNT = 11;

    public static final String USSR = "ussr";
    public static final String USA = "usa";
    public static final String GER = "germany";
    public static final String CZECH = "czech";
    public static final String IT = "italy";
    public static final String JP = "japan";
    public static final String CHI = "china";
    public static final String SWE = "sweden";
    public static final String UK = "uk";
    public static final String FR = "france";
    public static final String POL = "poland";

    private static String[] nations = {USSR, USA, GER, CZECH, IT, JP, CHI, SWE, UK, FR, POL};
    private String value;


    private Nation(int pos, String val) {
        super(pos);
        value = val;
    }

    public static List<Nation> getSet() {
        List<Nation> defaultSet = new ArrayList<>();
        for (int i = 0; i < NATION_COUNT; i++) {
            defaultSet.add(new Nation(i, nations[i]));
        }

        return defaultSet;
    }

    @Override
    public String getValue() {
        return value;
    }
}
