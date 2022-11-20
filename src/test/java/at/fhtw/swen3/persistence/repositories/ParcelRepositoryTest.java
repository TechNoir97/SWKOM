package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@SpringBootTest
class ParcelRepositoryTest {
    /*
    @Autowired
    private ParcelRepository parcelRepository;
    private static ParcelEntity parcelEntity;
    private RecipientRepository recipientRepository;

    @BeforeAll
    static void setup(){
        parcelEntity = new ParcelEntity();
        RecipientEntity recipientEntity = new RecipientEntity();
        recipientEntity.setName("Michi");
        recipientEntity.setCity("Bern");
        parcelEntity.setRecipient(recipientEntity);
        recipientEntity.setName("Michi");
        recipientEntity.setCity("Bern");
        parcelEntity.setSender(recipientEntity);

    }

     */
    @Test
    public void saveParcelEntityTrue(){
        /*
        ParcelEntity parcel = parcelRepository.save(parcelEntity);
        assertEquals(parcel.getWeight(), parcelEntity.getWeight());
        assertEquals(parcel.getSender(), parcelEntity.getSender());
        assertEquals(parcel.getRecipient(), parcelEntity.getRecipient());


         */
    }
}