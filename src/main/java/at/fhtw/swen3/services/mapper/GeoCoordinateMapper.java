package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.GeoCoordinate;
import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.services.dto.GeoCoordinateDTO;
import at.fhtw.swen3.services.dto.HopArrivalDTO;
import org.mapstruct.factory.Mappers;

public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);
    GeoCoordinateDTO entityToDto(GeoCoordinate geoCoordinate);
    GeoCoordinate dtoToEntity(GeoCoordinateDTO geoCoordinateDTO);
}
