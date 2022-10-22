package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.services.dto.RecipientDTO;
import org.mapstruct.factory.Mappers;

public interface RecipientMapper {

    RecipientMapper INSTANCE = Mappers.getMapper(RecipientMapper.class);
    RecipientDTO entityToDto(Recipient recipient);
    Recipient dtoToEntity(RecipientDTO recipientDTO);

}
