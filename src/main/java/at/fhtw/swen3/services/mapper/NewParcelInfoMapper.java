package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import org.mapstruct.factory.Mappers;

public interface NewParcelInfoMapper {
    NewParcelInfoMapper INSTANCE = Mappers.getMapper(NewParcelInfoMapper.class);

    ParcelEntity dtoToEntity (NewParcelInfo newParcelInfo);
    NewParcelInfo entityToDto (ParcelEntity parcelEntity);
}
