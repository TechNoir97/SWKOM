package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.mapstruct.factory.Mappers;

public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);
    GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity dtoToEntity(GeoCoordinate geoCoordinate);
}
