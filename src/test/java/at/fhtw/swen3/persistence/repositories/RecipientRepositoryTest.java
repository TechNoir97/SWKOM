package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@SpringBootTest
class RecipientRepositoryTest {
    /*
    @Autowired
    private RecipientRepository recipientRepository;
    private static RecipientEntity recipientEntity;
    @BeforeAll
    static void setup(){
        recipientEntity = new RecipientEntity();
        recipientEntity.setCity("London");
        recipientEntity.setName("Samson");
        recipientEntity.setCountry("England");
        recipientEntity.setStreet("Sesamestreet 8");
        recipientEntity.setPostalCode("GB-4152");
    }

     */
    @Test
    public void saveRecipientEntity(){
        /*
        RecipientEntity recipient = recipientRepository.save(recipientEntity);
        assertEquals(recipient.getCity(), recipientEntity.getCity());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());

         */
    }
}