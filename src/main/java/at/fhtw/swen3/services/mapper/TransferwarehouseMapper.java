package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.factory.Mappers;

public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);
    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouseDTO);
}
