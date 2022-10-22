package at.fhtw.swen3.persistence;

import at.fhtw.swen3.services.dto.GeoCoordinateDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;

public class Hop {
    private String hopType;
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    private GeoCoordinateDTO locationCoordinates;
}
