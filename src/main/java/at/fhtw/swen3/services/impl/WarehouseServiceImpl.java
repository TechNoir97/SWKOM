package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final HopRepository hopRepository;
    private final Validator validator;


    @Override
    public void importWarehouses(WarehouseEntity warehouse){

        validator.validate(warehouse);
        warehouseRepository.save(warehouse);

        log.info("Import Warehouse: " + warehouse);
    }
    @Override
    public Hop exportWarehouses(String code){
        try {
            Hop hop = HopMapper.INSTANCE.entityToDto(hopRepository.findByCode(code));
            log.info("Export Warehouse: ");
            return hop;
        }catch (Exception e) {
            System.out.println("Could not get Warehouse");
            log.error("Could not get Warehouse",e);

        }
        return null;
    }
    @Override
    public List<Warehouse> getWarehouse(){
        List<WarehouseEntity> warehouseEntities = warehouseRepository.findAll();
        List<Warehouse> warehouses = new ArrayList<>();
        try {
            for (WarehouseEntity entity : warehouseEntities) {
                warehouses.add(WarehouseMapper.INSTANCE.entityToDto(entity));
                log.info("Get List of Warehouses");
                return warehouses;
            }
        }catch(Exception e){
            System.out.println("Could not get Warehouse");
            log.error("Could not get Warehouse",e);

            }
        return null;
        }




}
