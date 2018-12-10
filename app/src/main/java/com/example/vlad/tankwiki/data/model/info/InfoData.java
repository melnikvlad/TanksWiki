package com.example.vlad.tankwiki.data.model.info;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class InfoData {
    @SerializedName("vehicle_crew_roles")
    Map<String, String> crewRoles;
    @SerializedName("vehicle_types")
    Map<String, String> vehicleTypes;
    @SerializedName("vehicle_nations")
    Map<String, String> vehicleNations;

    public Map<String, String> getCrewRoles() {
        return crewRoles;
    }

    public void setCrewRoles(Map<String, String> crewRoles) {
        this.crewRoles = crewRoles;
    }

    public Map<String, String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(Map<String, String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Map<String, String> getVehicleNations() {
        return vehicleNations;
    }

    public void setVehicleNations(Map<String, String> vehicleNations) {
        this.vehicleNations = vehicleNations;
    }
}
