package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final HopRepository hopRepository;
    private final Validator validator;


    @Override
    public void importWarehouses(WarehouseEntity warehouse) throws BLException {

        validator.validate(warehouse);
        try {
            warehouseRepository.save(warehouse);

            log.info("Import Warehouse: " + warehouse);
        }catch (Exception e){
            throw new BLException(2L, "Failed to store warehouse", e);
        }
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
