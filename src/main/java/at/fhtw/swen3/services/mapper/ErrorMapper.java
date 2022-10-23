package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Error;
import at.fhtw.swen3.persistence.GeoCoordinate;
import at.fhtw.swen3.services.dto.ErrorDTO;
import at.fhtw.swen3.services.dto.GeoCoordinateDTO;
import org.mapstruct.factory.Mappers;

public interface ErrorMapper {
    ErrorMapper INSTANCE = Mappers.getMapper(ErrorMapper.class);
    ErrorDTO entityToDto(Error error);
    Error dtoToEntity(ErrorDTO errorDTO);
}
