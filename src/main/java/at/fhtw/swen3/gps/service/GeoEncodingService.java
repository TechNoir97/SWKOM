package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.apache.tomcat.jni.Address;

public interface GeoEncodingService {
    public GeoCoordinateEntity encodeAddress(RecipientEntity source);
}
