package at.fhtw.swen3.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Truck {
    private String regionGeoJson;
    private String numberPlate;

    public String getRegionGeoJson() {
        return regionGeoJson;
    }

    public void setRegionGeoJson(String regionGeoJson) {
        this.regionGeoJson = regionGeoJson;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
