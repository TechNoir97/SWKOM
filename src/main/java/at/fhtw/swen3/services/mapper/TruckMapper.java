package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Transferwarehouse;
import at.fhtw.swen3.persistence.Truck;
import at.fhtw.swen3.services.dto.TransferwarehouseDTO;
import at.fhtw.swen3.services.dto.TruckDTO;
import org.mapstruct.factory.Mappers;

public interface TruckMapper {
    TruckMapper INSTANCE = Mappers.getMapper(TruckMapper.class);
    TruckDTO entityToDto(Truck truck);
    Truck dtoToEntity(TruckDTO truckDTO);
}
