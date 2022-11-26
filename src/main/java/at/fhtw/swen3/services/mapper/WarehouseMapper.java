package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHopsDTO.level", target = "level")
    WarehouseEntity dtoToEntity(Warehouse warehouse);

    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHops.level", target = "level")
    Warehouse entityToDto(WarehouseEntity warehouseEntity);




}
