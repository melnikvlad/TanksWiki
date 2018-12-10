package com.example.vlad.tankwiki.data.api;


import com.example.vlad.tankwiki.data.model.filter.IFilterItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FieldsMapper {
    private static final String COMMA = ",";

    public static Map<String, String> generateMap(final Map<String, Set<IFilterItem>> mapOptions) {
        Map<String, String> resultMap = new HashMap<>();
        StringBuilder stringBuilder;

        if (mapOptions != null) {
            for (String key : mapOptions.keySet()) {
                stringBuilder = new StringBuilder();
                Set<IFilterItem> set = mapOptions.get(key);
                if (set != null && !set.isEmpty()) {
                    for (IFilterItem option : set) {
                        stringBuilder
                                .append(option.getValue())
                                .append(COMMA);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    resultMap.put(key, stringBuilder.toString());
                }
            }
        }

        return resultMap;
    }
}
