package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.config.Configuration;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.Properties;
@Slf4j
public class BingEncodingProxy implements GeoEncodingService {
    Configuration apiKey = Configuration.getInstance();
    @Override
    public GeoCoordinateEntity encodeAddress(Address address){
        GeoCoordinateEntity geoCoordinate = new GeoCoordinateEntity();

        try {
            URI resourceUrl = URI.create("http://dev.virtualearth.net/REST/v1/Locations/AT/"
                    + address + "?key=" + apiKey.get("ApiKey"));

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder(resourceUrl).build();
            //Start parsin the response from Bing
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());
            JSONObject resourceSets = (JSONObject) json.get("resourceSets");
            JSONObject resources = (JSONObject) resourceSets.get("resources");
            JSONObject point = (JSONObject) resources.get("resourceSets");
            JSONObject coordinates = (JSONObject) point.get("coordinates");
            String[] coordinatesArray = coordinates.toString().split(",");
            geoCoordinate.setLat(Double.valueOf(coordinatesArray[0]));
            geoCoordinate.setLon(Double.valueOf(coordinatesArray[1]));


        }catch (Exception e){
            log.error("An error occured in BingEncodingProxy", e);
        }
        return geoCoordinate;
    }


}
