package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;

@Entity(name = "Truck")
@Table(name = "truck")
public class TruckEntity extends HopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
