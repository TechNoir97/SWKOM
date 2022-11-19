package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ParcelMapper {

/* TODO das Mapping von den Listen funktioniert noch nicht

    @Mapping(source = "visitedHops.code", target = "visitedHops.code")
    @Mapping(source = "visitedHops.description", target = "visitedHops.description")
    @Mapping(source = "visitedHops.dateTime", target = "visitedHops.dateTime")

    @Mapping(source = "futureHops.code", target = "futureHops.code")
    @Mapping(source = "futureHops.description", target = "futureHops.description")
    @Mapping(source = "futureHops.dateTime", target = "futureHops.dateTime")

    Parcel getModelFromDTO(TrackingInformation trackingInformation);
    List<HopArrivalDTO> getHopArrivalDTO(List<HopArrival> hopArrivals);
    @Mapping(source = "visitedHops.code", target = "visitedHops.code")
    @Mapping(source = "visitedHops.description", target = "visitedHops.description")
    @Mapping(source = "visitedHops.dateTime", target = "visitedHops.dateTime")

    @Mapping(source = "futureHops.code", target = "futureHops.code")
    @Mapping(source = "futureHops.description", target = "futureHops.description")
    @Mapping(source = "futureHops.dateTime", target = "futureHops.dateTime")

    TrackingInformation getModelFromEntity(Parcel parcel);
    List<HopArrival> getHopArrival(List<HopArrivalDTO> hopArrivals);



*/



    @Mapping(source = "recipient.name", target = "recipient.name")
    @Mapping(source = "recipient.street", target = "recipient.street")
    @Mapping(source = "recipient.postalCode", target = "recipient.postalCode")
    @Mapping(source = "recipient.city", target = "recipient.city")
    @Mapping(source = "recipient.country", target = "recipient.country")

    @Mapping(source = "sender.name", target = "sender.name")
    @Mapping(source = "sender.street", target = "sender.street")
    @Mapping(source = "sender.postalCode", target = "sender.postalCode")
    @Mapping(source = "sender.city", target = "sender.city")
    @Mapping(source = "sender.country", target = "sender.country")
    ParcelEntity getModelFromEntity(Parcel parcel);

    @Mapping(source = "recipient.name", target = "recipient.name")
    @Mapping(source = "recipient.street", target = "recipient.street")
    @Mapping(source = "recipient.postalCode", target = "recipient.postalCode")
    @Mapping(source = "recipient.city", target = "recipient.city")
    @Mapping(source = "recipient.country", target = "recipient.country")

    @Mapping(source = "sender.name", target = "sender.name")
    @Mapping(source = "sender.street", target = "sender.street")
    @Mapping(source = "sender.postalCode", target = "sender.postalCode")
    @Mapping(source = "sender.city", target = "sender.city")
    @Mapping(source = "sender.country", target = "sender.country")
    Parcel getModelFromDTO(ParcelEntity parcelEntity);

    @Mapping(source = "parcelDTO.weight", target = "weight")
    @Mapping(source = "newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source = "trackingInformation.state", target = "state")
    ParcelEntity from(Parcel parcel, TrackingInformation trackingInformation, NewParcelInfo newParcelInfo);




}
