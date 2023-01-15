package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class GeoCoordinateRepositoryTest {
/*

    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;
    private static GeoCoordinateEntity geoCoordinateEntity;
    @BeforeAll
    static void setup(){
        geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(11.595);
        geoCoordinateEntity.setLon(43.148056);
        geoCoordinateEntity.setId(1);
    }


    @Test
    public void saveGeoCoordinateRepositoryTrue(){
        GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(geoCoordinateEntity);
        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());

    }
    @Test
    public void saveGeoCoordinateRepositoryFalse(){
        GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(geoCoordinateEntity);
        assertNotEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLon());
        assertNotEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLat());
    }
*/



}