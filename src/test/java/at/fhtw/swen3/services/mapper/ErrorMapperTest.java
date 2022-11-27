package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMapperTest {
    static ErrorMapper mapper;
    @BeforeAll
    static void setup(){
         mapper = ErrorMapper.INSTANCE;
    }
    @Test
    void entityToDto() {

        ErrorEntity errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage("Test1");
        Error error = mapper.entityToDto(errorEntity);
        assertEquals(error.getErrorMessage(), errorEntity.getErrorMessage());


    }

    @Test
    void dtoToEntity() {

        Error error = new Error();
        error.setErrorMessage("Test2");
        ErrorEntity errorEntity = ErrorMapper.INSTANCE.dtoToEntity(error);
        assertEquals(error.getErrorMessage(), errorEntity.getErrorMessage());


    }
}