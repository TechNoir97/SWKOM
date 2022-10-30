package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapping;

public interface WarehouseMapper {

    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHopsDTO.level", target = "level")
    WarehouseNextHopsEntity getModelFromEntity(WarehouseNextHops warehouseNextHops);

    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHops.level", target = "level")
    WarehouseNextHops getModelFromEntity(WarehouseNextHopsEntity warehouseNextHopsEntity);


    //WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
    //WarehouseNextHopsDTO entityToDto(WarehouseNextHops warehouseNextHops);
    //WarehouseNextHops dtoToEntity(WarehouseNextHopsDTO warehouseNextHopsDTO);

}
