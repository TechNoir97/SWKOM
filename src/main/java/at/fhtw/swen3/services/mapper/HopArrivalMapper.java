package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.services.dto.HopArrivalDTO;
import at.fhtw.swen3.services.dto.RecipientDTO;
import org.mapstruct.factory.Mappers;

public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE = Mappers.getMapper(HopArrivalMapper.class);
    HopArrivalDTO entityToDto(HopArrival hopArrival);
    HopArrival dtoToEntity(HopArrivalDTO hopArrivalDTO);
}
