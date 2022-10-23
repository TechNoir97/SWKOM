package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Truck;
import at.fhtw.swen3.persistence.WarehouseNextHops;
import at.fhtw.swen3.services.dto.TruckDTO;
import at.fhtw.swen3.services.dto.WarehouseNextHopsDTO;
import org.mapstruct.factory.Mappers;

public interface WarehouseNextHopsMapper {
    WarehouseNextHopsMapper INSTANCE = Mappers.getMapper(WarehouseNextHopsMapper.class);
    WarehouseNextHopsDTO entityToDto(WarehouseNextHops warehouseNextHops);
    WarehouseNextHops dtoToEntity(WarehouseNextHopsDTO warehouseNextHopsDTO);
}
