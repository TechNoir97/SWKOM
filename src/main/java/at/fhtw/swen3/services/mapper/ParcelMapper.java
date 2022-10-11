package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import lombok.Getter;
@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);
    at.fhtw.swen3.services.dto.Parcel entityToDto(at.fhtw.swen3.persistence.Parcel parcel);
    at.fhtw.swen3.persistence.Parcel dtoToEntity(at.fhtw.swen3.services.dto.Parcel parcel);
}
