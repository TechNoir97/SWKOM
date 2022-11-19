package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

/*
    @Mapping(source = "visitedHops.code", target = "visitedHops.code")
    @Mapping(source = "visitedHops.description", target = "visitedHops.description")
    @Mapping(source = "visitedHops.dateTime", target = "visitedHops.dateTime")

    @Mapping(source = "futureHops.code", target = "futureHops.code")
    @Mapping(source = "futureHops.description", target = "futureHops.description")
    @Mapping(source = "futureHops.dateTime", target = "futureHops.dateTime")

    Parcel getModelFromDTO(TrackingInformation trackingInformation);
    List<HopArrival> getHopArrivalDTO(List<HopArrivalEntity> hopArrivals);
    @Mapping(source = "visitedHops.code", target = "visitedHops.code")
    @Mapping(source = "visitedHops.description", target = "visitedHops.description")
    @Mapping(source = "visitedHops.dateTime", target = "visitedHops.dateTime")

    @Mapping(source = "futureHops.code", target = "futureHops.code")
    @Mapping(source = "futureHops.description", target = "futureHops.description")
    @Mapping(source = "futureHops.dateTime", target = "futureHops.dateTime")

    TrackingInformation getModelFromEntity(Parcel parcel);
    List<HopArrivalEntity> getHopArrival(List<HopArrival> hopArrivals);


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
    ParcelEntity dtoToEntity(Parcel parcel);

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
    Parcel entityToDto(ParcelEntity parcelEntity);

    @Mapping(source = "parcelDTO.weight", target = "weight")
    @Mapping(source = "newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source = "trackingInformation.state", target = "state")
    ParcelEntity from(Parcel parcel, TrackingInformation trackingInformation, NewParcelInfo newParcelInfo);




}
