package com.example.vlad.tankwiki.data.model.info;

import java.util.ArrayList;
import java.util.List;

public class InfoRequestFields {

    private List<String> fields;

    public InfoRequestFields() {
        this.fields = new ArrayList<>();
        String crew = "vehicle_crew_roles";
        fields.add(crew);
        String types = "vehicle_types";
        fields.add(types);
        String nations = "vehicle_nations";
        fields.add(nations);
    }

    public List<String> getFields() {
        return fields;
    }
}
