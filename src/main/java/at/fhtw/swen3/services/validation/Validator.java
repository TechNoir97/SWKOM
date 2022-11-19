package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class Validator <T>{
    private static Validator INSTANCE;
    public static Validator getInstance(){
        if(Validator.INSTANCE == null){
            Validator.INSTANCE = new Validator();
        }
        return INSTANCE;
    }
    public void validate(T toValidate){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(toValidate);
        for(ConstraintViolation<T> violation : violations){
            log.error(violation.getMessage());
        }
    }
}
