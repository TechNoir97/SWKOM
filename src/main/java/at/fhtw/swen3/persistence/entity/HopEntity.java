package at.fhtw.swen3.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "Hop")
public class HopEntity {
    private String hopType;
    @Id
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    @ManyToOne
    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
