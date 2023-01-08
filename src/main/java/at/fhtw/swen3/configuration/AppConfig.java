package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository, RecipientRepository recipientRepository, GeoCoordinateRepository geoCoordinateRepository, Validator validator){
        return new ParcelServiceImpl(parcelRepository, recipientRepository, geoCoordinateRepository, validator);
    }

    @Bean
    public WarehouseServiceImpl warehouseService(WarehouseRepository warehouseRepository, HopRepository hopRepository, Validator validator){
        return new WarehouseServiceImpl(warehouseRepository, hopRepository, validator);
    }
}
