package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "parcel.recipient", target = "recipient")
    ParcelEntity dtoToEntity(Parcel parcel);
    Parcel entityToDto(ParcelEntity parcelEntity);


}
