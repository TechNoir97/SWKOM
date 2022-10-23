package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.Transferwarehouse;
import at.fhtw.swen3.services.dto.RecipientDTO;
import at.fhtw.swen3.services.dto.TransferwarehouseDTO;
import org.mapstruct.factory.Mappers;

public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);
    TransferwarehouseDTO entityToDto(Transferwarehouse transferwarehouse);
    Transferwarehouse dtoToEntity(TransferwarehouseDTO transferwarehouseDTO);
}
