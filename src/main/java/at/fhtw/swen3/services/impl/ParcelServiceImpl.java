package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Service
@SpringBootApplication
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    ParcelRepository parcelRepo;
    RecipientRepository recipientRepo;
    public ParcelServiceImpl(ParcelRepository parcelRepo, RecipientRepository recipientRepo){
        this.parcelRepo = parcelRepo;
        this.recipientRepo = recipientRepo;
    }

    @Override
    public void submitNewParcel(ParcelEntity newParcel){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator vaalidator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = vaalidator.validate(newParcel);
        for(ConstraintViolation<ParcelEntity> violation : violations){

            log.error(violation.getMessage());

        }
    }
}
