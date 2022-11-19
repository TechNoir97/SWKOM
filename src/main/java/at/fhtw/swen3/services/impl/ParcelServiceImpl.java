package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class ParcelServiceImpl implements ParcelService {
    ParcelRepository parcelRepo;
    RecipientRepository recipientRepo;
    Validator validator;

    @Override
    public void submitNewParcel(ParcelEntity newParcel){
        log.info("New parcel submited: " + newParcel);
        validator.validate(newParcel);
        parcelRepo.save(newParcel);
        recipientRepo.save(newParcel.getRecipient());
        recipientRepo.save(newParcel.getSender());
    }
    @Override
    public List<Parcel> getParcels(){
       List<ParcelEntity> parcelEntities = parcelRepo.findAll();
       List<Parcel> parcels = new ArrayList<>();
        for (ParcelEntity parcelEntity: parcelEntities) {
           parcels.add(ParcelMapper.INSTANCE.entityToDto(parcelEntity));
        }
        return parcels;
    }
    @Override
    public void deleteParcelById(int id){
        log.info("Parcel with id=" + id + "was deleted");
        parcelRepo.deleteById(id);
    }
    @Override
    public void updateParcelInfo(int id, ParcelEntity parcelEntity){
        validator.validate(parcelEntity);
        parcelRepo.save(parcelEntity);
        recipientRepo.save(parcelEntity.getRecipient());
        recipientRepo.save(parcelEntity.getSender());
    }


}
