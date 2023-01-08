package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class RecipientRepositoryTest {
   /* @Autowired
    private RecipientRepository recipientRepository;
    private static RecipientEntity recipientEntity;
    @BeforeAll
    static void setup(){
        recipientEntity = new RecipientEntity();
        recipientEntity.setCity("Stinatz");
        recipientEntity.setName("Samson");
        recipientEntity.setCountry("Austria");
        recipientEntity.setStreet("Sesamestreet 8");
        recipientEntity.setPostalCode("A-7145");
    }

    @Test
    public void saveRecipientEntity(){
        RecipientEntity recipient = recipientRepository.save(recipientEntity);
        assertEquals(recipient.getCity(), recipientEntity.getCity());
        assertEquals(recipient.getCountry(), recipientEntity.getCountry());
        assertEquals(recipient.getName(), recipientEntity.getName());
        assertEquals(recipient.getStreet(), recipientEntity.getStreet());
        assertEquals(recipient.getPostalCode(), recipientEntity.getPostalCode());

    }*/
}