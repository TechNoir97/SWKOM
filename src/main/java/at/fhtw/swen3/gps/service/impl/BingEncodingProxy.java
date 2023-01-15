package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.config.Configuration;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import lombok.extern.slf4j.Slf4j;

import org.apache.tomcat.jni.Address;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import java.awt.*;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Properties;
@Slf4j
public class BingEncodingProxy implements GeoEncodingService {
    Configuration apiKey = Configuration.getInstance();
    @Override
    public GeoCoordinateEntity encodeAddress(RecipientEntity source){
        GeoCoordinateEntity geoCoordinate = new GeoCoordinateEntity();
        http://dev.virtualearth.net/REST/v1/Locations?countryRegion={countryRegion}&adminDistrict={adminDistrict}&locality={locality}&postalCode={postalCode}&addressLine={addressLine}&userLocation={userLocation}&userIp={userIp}
        // &usermapView={usermapView}&includeNeighborhood={includeNeighborhood}&maxResults={maxResults}&key={BingMapsKey}


        //http://dev.virtualearth.net/REST/v1/Locations?CountryRegion=AT/locality=Wien&postalCode=A-1220&addressLine=Sinagasse&key=AtBn-qNFfjIKptwu5X3kThG3BpsMBuUAsR462cYwY-ZZOv3V-JJV91xCOofgUgca
        try {
            URI resourceUrl = URI.create("http://dev.virtualearth.net/REST/v1/Locations?CountryRegion=AT/locality="
                    + source.getCity() + "&postalCode=" + source.getPostalCode() + "&addressLine=" + source.getStreet() + "&key=" + apiKey.get("APIKey"));
            log.info("BingEncodingProxy URL: " + resourceUrl);
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder(resourceUrl).build();
            //Start parsin the response from Bing
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            log.info("Response: " + response);


            JSONObject json = new JSONObject(response.body());
            JSONArray resourceSets = (JSONArray) json.get("resourceSets");
            JSONObject object1 = (JSONObject) resourceSets.get(0);
            JSONArray resources = (JSONArray) object1.get("resources");
            JSONObject object2 = (JSONObject) resources.get(0);
            JSONObject point = (JSONObject) object2.get("point");
            JSONArray coordinates = (JSONArray) point.get("coordinates");
            //String[] coordinatesArray = coordinates.toString().split(",");
            geoCoordinate.setLat(Double.valueOf(coordinates.get(0).toString()));
            geoCoordinate.setLon(Double.valueOf(coordinates.get(1).toString()));


        }catch (Exception e){
            log.error("An error occured in BingEncodingProxy", e);
        }
        return geoCoordinate;
    }

    //TODO hier muss noch eine Funktion rein um die Region von Trucks und so zu bekommen
        public Polygon getRegionGeo(String regionGeoJson){
            ArrayList<Point> points = new ArrayList<>();

            try{
                JSONObject object1 = new JSONObject(regionGeoJson);
                JSONObject geometry = (JSONObject) object1.get("geometry");
                //JSONObject coordinates = (JSONObject) geometry.get("coordinates");
                String tmp = geometry.get("coordinates").toString();
                JSONArray coordinatPoints = new JSONArray(tmp.substring(2, tmp.length() - 2));
                for(int i = 0; i < coordinatPoints.length(); i++){
                    JSONArray point = new JSONArray(coordinatPoints.get(i).toString());
                    Double lat = Double.parseDouble(point.get(0).toString());
                    Double lon = Double.parseDouble(point.get(1).toString());
                    points.add(new Point(lat, lon));
                }
            }catch (Exception e){
                log.error("An error occured while creating regionGeo", e);
            }
            Polygon polygon = new Polygon(points);
            return polygon;
        }
}
