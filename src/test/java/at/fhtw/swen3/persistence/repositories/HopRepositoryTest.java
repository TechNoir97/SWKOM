package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class HopRepositoryTest {
    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;
    @Autowired
    private HopRepository hopRepository;
    private static HopEntity hopEntity;
    @BeforeAll
    static void setup(){
        hopEntity = new HopEntity();
        hopEntity.setHopType("fast");
        hopEntity.setCode("WTTA0147");
        hopEntity.setDescription("This is a Description");
        hopEntity.setProcessingDelayMins(7);
        hopEntity.setLocationName("Some-Location");
    }
    @Test
    public void saveHopEntity(){
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(11.595);
        geoCoordinateEntity.setLon(43.148056);
        geoCoordinateRepository.save(geoCoordinateEntity);
        hopEntity.setLocationCoordinates(geoCoordinateEntity);
        HopEntity hop = hopRepository.save(hopEntity);

        assertEquals(hop.getHopType(), hopEntity.getHopType());
        assertEquals(hop.getCode(), hopEntity.getCode());
        assertEquals(hop.getDescription(), hopEntity.getDescription());
        assertEquals(hop.getLocationName(), hopEntity.getLocationName());
        assertEquals(hop.getLocationCoordinates(), hopEntity.getLocationCoordinates());
        assertEquals(hop.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());

    }
}