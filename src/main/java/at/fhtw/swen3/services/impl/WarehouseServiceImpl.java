package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    WarehouseRepository warehouseRepository;
    private final Validator validator;


    @Override
    public void importWarehouses(WarehouseEntity warehouse){
        validator.validate(warehouse);
        warehouseRepository.save(warehouse);

        log.info("Import Warehouse: " + warehouse);
    }
    @Override
    public void exportWarehouses(){
        log.info("Export Warehouse: ");
    }
    @Override
    public List<Warehouse> getWarehouse(){

        log.info("Get List of Warehouses");

        return null;
    }
}
