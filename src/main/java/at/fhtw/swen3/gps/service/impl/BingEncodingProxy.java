package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.config.Configuration;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;

import java.io.InputStream;
import java.util.Properties;
@Slf4j
public class BingEncodingProxy implements GeoEncodingService {
    Configuration apiKey = Configuration.getInstance();
    @Override
    public GeoCoordinateEntity encodeAddress(Address address){
        GeoCoordinateEntity geoCoordinate = new GeoCoordinateEntity();

        //TODO hier können wir das ungefähr wie im letzten Semester mit Mapstruct machen


        return geoCoordinate;
    }


}
