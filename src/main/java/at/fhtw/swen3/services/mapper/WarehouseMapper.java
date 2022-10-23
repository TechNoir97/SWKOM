package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.persistence.WarehouseNextHops;
import at.fhtw.swen3.services.dto.HopArrivalDTO;
import at.fhtw.swen3.services.dto.HopDTO;
import at.fhtw.swen3.services.dto.ParcelDTO;
import at.fhtw.swen3.services.dto.WarehouseNextHopsDTO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface WarehouseMapper {

    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHopsDTO.level", target = "level")
    WarehouseNextHops getModelFromEntity(WarehouseNextHopsDTO warehouseNextHopsDTO);

    @Mapping(source = "nextHops.traveltimeMins", target = "nextHops.traveltimeMins")
    @Mapping(source = "nextHops.hop", target = "nextHops.hop")
    @Mapping(source = "WarehouseNextHops.level", target = "level")
    WarehouseNextHopsDTO getModelFromEntity(WarehouseNextHops warehouseNextHops);


    //WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
    //WarehouseNextHopsDTO entityToDto(WarehouseNextHops warehouseNextHops);
    //WarehouseNextHops dtoToEntity(WarehouseNextHopsDTO warehouseNextHopsDTO);

}
