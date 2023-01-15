package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {
    @Bean
    public ParcelServiceImpl parcelService(WarehouseRepository warehouseRepository, ParcelRepository parcelRepository, RecipientRepository recipientRepository, GeoCoordinateRepository geoCoordinateRepository, Validator validator, HopRepository hopRepository, HopArrivalRepository hopArrivalRepository){
        return new ParcelServiceImpl(warehouseRepository, parcelRepository, recipientRepository, geoCoordinateRepository, validator, hopRepository, hopArrivalRepository);
    }

    @Bean
    public WarehouseServiceImpl warehouseService(TransferwarehouseRepository transferwarehouseRepository, TruckRepository truckRepository, WarehouseRepository warehouseRepository, WarehouseNextHopsRepository warehouseNextHopsRepository, GeoCoordinateRepository geoCoordinateRepository, HopRepository hopRepository, Validator validator){
        return new WarehouseServiceImpl(transferwarehouseRepository, truckRepository, geoCoordinateRepository, warehouseRepository, warehouseNextHopsRepository, hopRepository, validator);
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
}
