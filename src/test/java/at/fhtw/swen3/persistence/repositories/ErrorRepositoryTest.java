package at.fhtw.swen3.persistence.repositories;

import static org.junit.jupiter.api.Assertions.*;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource("/application-test.properties")
class ErrorRepositoryTest {

    @Autowired
    private ErrorRepository errorRepository;
    private static ErrorEntity errorEntity;
    @BeforeAll
    static void setup(){
        errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage("Something went wrong here!");
    }


    @Test
    public void saveErrorEntityTrue(){
        ErrorEntity error = errorRepository.save(errorEntity);
        assertEquals(error.getErrorMessage(), errorEntity.getErrorMessage());


    }
    @Test
    public void saveErrorEntityFalse(){
        ErrorEntity error = errorRepository.save(errorEntity);
        assertNotEquals(error.getId(), -1L);

    }
  
}