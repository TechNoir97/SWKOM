package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.TrackingInformationMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {
    private final ParcelRepository parcelRepo;
    private final RecipientRepository recipientRepo;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private final Validator validator;

    @Override
    public NewParcelInfo submitNewParcel(ParcelEntity newParcel) throws BLException {
        log.info("ParcelServiceImpl: submitNewParcel() -> Name of the sender: " + newParcel.getSender().getName());
        //Validate the data of the new parcel
        validator.validate(newParcel);
        String id = RandomStringUtils.randomAlphanumeric(9);
        id = id.toUpperCase();
        System.out.println("ABABABABABABABABABABABABAB" + id + "ABABABABABABABABABABABABAB");
        newParcel.setTrackingId(id);
        //Get the coordinates
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinateEntity recipientCoordinates = bingEncodingProxy.encodeAddress(newParcel.getRecipient());

        GeoCoordinateEntity senderCoordinates = bingEncodingProxy.encodeAddress(newParcel.getSender());

        //Save the data into the database
        recipientRepo.save(newParcel.getRecipient());
        recipientRepo.save(newParcel.getSender());
        recipientCoordinates.setId(recipientRepo.findByName(newParcel.getRecipient().getName()).getId());
        senderCoordinates.setId(recipientRepo.findByName(newParcel.getSender().getName()).getId());
        geoCoordinateRepository.save(recipientCoordinates);
        geoCoordinateRepository.save(senderCoordinates);

        parcelRepo.save(newParcel);
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId(newParcel.getTrackingId());
        return newParcelInfo;
    }
    @Override
    public List<Parcel> getParcels(){
        try{
            List<ParcelEntity> parcelEntities = parcelRepo.findAll();
            List<Parcel> parcels = new ArrayList<>();
            for (ParcelEntity parcelEntity: parcelEntities) {
                parcels.add(ParcelMapper.INSTANCE.entityToDto(parcelEntity));
            }
            log.info("ParcelServiceImpl: getParcels(): " + parcels);
            return parcels;
        }catch (Exception e){
            System.out.println("Could not get Parcels - ParcelServiceImpl");
            log.error("Could not get Parcels - ParcelServiceImpl");
            return null;
        }

    }
    @Override
    public void deleteParcelById(int id){
        log.info("ParcelServiceImpl: deleteParcelById(): " + id + "was deleted");
        parcelRepo.deleteById(id);
    }
    @Override
    public void updateParcelInfo(int id, ParcelEntity parcelEntity) throws BLException {
        log.info("ParcelServiceImpl: updateParcelInfo(): " + id + "was updated");
        validator.validate(parcelEntity);
        parcelRepo.save(parcelEntity);
        recipientRepo.save(parcelEntity.getRecipient());
        recipientRepo.save(parcelEntity.getSender());
    }
    @Override
    public void reportParcelDelivery(String trackingId){

        ParcelEntity parcel = parcelRepo.findByTrackingId(trackingId);
        parcel.setState(ParcelEntity.StateEnum.DELIVERED);
        parcelRepo.save(parcel);
    }
    @Override
    public void reportParcelHop(String trackingId, String code){
        /* TODO hier müssen wir noch schauen wie wir das machen sollen
        try{
        ParcelEntity parcel = parcelRepo.findByTrackingId(trackingId);
        List<HopArrivalEntity> visitedHops = parcel.getVisitedHops();
        List<HopArrivalEntity> futurreHops = parcel.getFutureHops();
        }catch (Exception e){
        System.out.printl("Could not report Hop - ParcelServiceImpl");
        log.error("Could not report Hop - ParcelServiceImpl",e);
        }
        */
    }

    @Override
    public TrackingInformation trackParcel(String trackingId){
        try{
            ParcelEntity parcel = parcelRepo.findByTrackingId(trackingId);
            TrackingInformation information = new TrackingInformation();
            information = TrackingInformationMapper.INSTANCE.entityToDto(parcel);
            System.out.println(information);
            return information;
        }catch (Exception e){
            System.out.println("Could not track parcel - ParcelServiceImpl");
            log.error("Could not track parcel - ParcelServiceImpl",e);
            return null;
        }

    }
    @Override
    public NewParcelInfo transitionParcel(String trackingId, Parcel parcel) throws BLException {
        validator.validate(parcel);

        ParcelEntity transParcel = new ParcelEntity();
        transParcel = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        //Get the coordinates
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinateEntity recipientCoordinates = bingEncodingProxy.encodeAddress(transParcel.getRecipient());
        GeoCoordinateEntity senderCoordinates = bingEncodingProxy.encodeAddress(transParcel.getSender());
        transParcel.setTrackingId(trackingId);

        //Save the data into the database
        recipientRepo.save(transParcel.getRecipient());
        recipientRepo.save(transParcel.getSender());

        recipientCoordinates.setId(recipientRepo.findByName(parcel.getRecipient().getName()).getId());
        senderCoordinates.setId(recipientRepo.findByName(parcel.getSender().getName()).getId());
        geoCoordinateRepository.save(recipientCoordinates);
        geoCoordinateRepository.save(senderCoordinates);

        parcelRepo.save(transParcel);
        NewParcelInfo parcelInfo = new NewParcelInfo();
        parcelInfo.setTrackingId(transParcel.getTrackingId());

        return parcelInfo;
    }


}
