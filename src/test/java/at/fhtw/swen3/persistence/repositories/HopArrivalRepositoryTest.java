package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.threeten.bp.OffsetDateTime;

@SpringBootTest
class HopArrivalRepositoryTest {
    /*
    @Autowired
    private HopArrivalRepository hopArrivalRepository;
    private static HopArrivalEntity hopArrivalEntity;

    @BeforeAll
    static void setup(){
        hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("A-1050");
        hopArrivalEntity.setDescription("Not a suspicious box at all!");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
    }

     */
    @Test
    public void saveHopArrivalEntityTrue(){
        /*
        HopArrivalEntity hopArrival = hopArrivalRepository.save(hopArrivalEntity);
        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
        assertEquals(hopArrival.getId(), hopArrivalEntity.getId());

         */
    }
}