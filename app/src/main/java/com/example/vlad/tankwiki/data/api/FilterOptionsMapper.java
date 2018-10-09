package com.example.vlad.tankwiki.data.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterOptionsMapper {
    private static final String NATION = "nation";
    private static final String TIER = "tier";
    private static final String TYPE = "type";

    private final Map<String, List<String>> options = new HashMap<>();

    public FilterOptionsMapper() {

    }

    public void setNation(String nation) {

        if (options.isEmpty()) {
            options.put(NATION, new ArrayList<>());
        }
    }
}
