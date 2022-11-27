package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;
import org.threeten.bp.OffsetDateTime;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class HopArrivalRepositoryTest {
    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private HopArrivalRepository hopArrivalRepository;
    private static HopArrivalEntity hopArrivalEntity;
    @Autowired
    private RecipientRepository recipientRepository;

    void setup(){
        ParcelEntity parcelEntity = new ParcelEntity();
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Michi");
        recipientEntity.setCity("Bern");
        recipientRepository.save(recipientEntity);
        parcelEntity.setRecipient(recipientEntity);
        recipientEntity.setName("Michi");
        recipientEntity.setCity("Bern");
        recipientRepository.save(recipientEntity);
        parcelEntity.setSender(recipientEntity);
        parcelEntity.setWeight(2F);
        parcelEntity.setState(ParcelEntity.StateEnum.INTRANSPORT);
        parcelRepository.save(parcelEntity);
        hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("WTTA014");
        hopArrivalEntity.setDescription("Not a suspicious box at all!");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());
        hopArrivalEntity.setParcel(parcelEntity);

    }

    @Test
    public void saveHopArrivalEntityTrue(){
        setup();

        HopArrivalEntity hopArrival = hopArrivalRepository.save(hopArrivalEntity);
        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
        assertEquals(hopArrival.getId(), hopArrivalEntity.getId());

    }
}