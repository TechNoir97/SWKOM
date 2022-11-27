package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoCoordinateMapperTest {

    @Test
    void entityToDto() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(2.4);
        geoCoordinateEntity.setLon(1.5);
        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);
        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());

    }

    @Test
    void dtoToEntity() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLat(2.4);
        geoCoordinate.setLon(1.5);
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);
        assertEquals(geoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());

    }
}