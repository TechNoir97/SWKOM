package at.fhtw.swen3.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Truck")
public class TruckEntity {
    private String regionGeoJson;
    @Id
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
