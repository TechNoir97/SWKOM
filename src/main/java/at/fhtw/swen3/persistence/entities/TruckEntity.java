package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "Truck")
@Table(name = "truck")
public class TruckEntity extends HopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(columnDefinition = "text")
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
