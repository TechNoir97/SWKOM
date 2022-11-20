package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "Hop")
@Table(name = "hop")
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String hopType;
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    @OneToOne
    @NotNull
    private GeoCoordinateEntity locationCoordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHopType() {
        return hopType;
    }

    public void setHopType(String hopType) {
        this.hopType = hopType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProcessingDelayMins() {
        return processingDelayMins;
    }

    public void setProcessingDelayMins(Integer processingDelayMins) {
        this.processingDelayMins = processingDelayMins;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public GeoCoordinateEntity getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(GeoCoordinateEntity locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }
}
