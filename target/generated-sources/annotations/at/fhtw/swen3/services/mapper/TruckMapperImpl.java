package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-03T13:57:29+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( truckEntity.getRegionGeoJson() );
        truck.setNumberPlate( truckEntity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck truckDTO) {
        if ( truckDTO == null ) {
            return null;
        }

        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setRegionGeoJson( truckDTO.getRegionGeoJson() );
        truckEntity.setNumberPlate( truckDTO.getNumberPlate() );

        return truckEntity;
    }
}
