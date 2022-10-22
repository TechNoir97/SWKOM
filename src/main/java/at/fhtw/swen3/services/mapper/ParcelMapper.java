package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.ParcelDTO;
import at.fhtw.swen3.services.dto.RecipientDTO;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.persistence.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.Column;

@Mapper
public interface ParcelMapper {


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

    Parcel getModelFromEntity(ParcelDTO parcelDTO);

    @Mapping(source = "parcelDTO.weight", target = "weight")
    @Mapping(source = "newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source = "trackingInformation.state", target = "state")

    Parcel from(ParcelDTO parcelDTO, TrackingInformation trackingInformation, NewParcelInfo newParcelInfo);




}
