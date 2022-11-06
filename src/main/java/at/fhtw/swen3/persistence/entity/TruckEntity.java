package at.fhtw.swen3.persistence.entity;

import javax.persistence.*;

@Entity(name = "Truck")
@Table
public class TruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
