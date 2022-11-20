package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "Hop")
@Table
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
