package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Hop;
import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.services.dto.HopArrivalDTO;
import at.fhtw.swen3.services.dto.HopDTO;
import org.mapstruct.factory.Mappers;

public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);
    HopDTO entityToDto(Hop hop);
    Hop dtoToEntity(HopDTO hopDTO);
}
