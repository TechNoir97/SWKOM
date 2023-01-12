package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
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


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final TransferwarehouseRepository transferwarehouseRepository;
    private final TruckRepository truckRepository;
    private final GeoCoordinateRepository geoCoordinateRepository;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;
    private final HopRepository hopRepository;
    private final Validator validator;


    @Override
    public void importWarehouses(WarehouseEntity warehouse) throws BLException {
        log.info("Import Warehouse: " + warehouse);

        //Delete the previous DB entries
        deleteDBEntries();
        //validator.validate(warehouse);
        try {

            for(WarehouseNextHopsEntity nextHops : warehouse.getNextHops()){
                HopEntity hop = checkHopType(nextHops.getHop());

            }
            warehouseRepository.save(warehouse);


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
    private HopEntity checkHopType(HopEntity toCheck) throws BLException {
        log.info("checkHopType: " + toCheck);
        HopEntity hop = null;
        //TODO Die Transferwarehouses werden noch nicht gespeichert

        try {
            if (toCheck.getHopType().equals("warehouse")) {
                WarehouseEntity warehouse = (WarehouseEntity) toCheck;
                validator.validate(warehouse);
                while (!warehouse.getNextHops().isEmpty()){
                    hop = checkHopType(warehouse.getNextHops().get(0).getHop());
                    warehouse.getNextHops().remove(0);
                }
                GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(toCheck.getLocationCoordinates());
                toCheck.getLocationCoordinates().setId(geoCoordinate.getId());
                hop = warehouseRepository.save(warehouse);
            } else if (toCheck.getHopType().equals("truck")) {
                TruckEntity truck = (TruckEntity) toCheck;
                validator.validate(truck);
                GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(toCheck.getLocationCoordinates());
                toCheck.getLocationCoordinates().setId(geoCoordinate.getId());
                hop = truckRepository.save(truck);
            } else if (toCheck.getHopType().equals("transferwarehouse")) {
                TransferwarehouseEntity transferwarehouse = (TransferwarehouseEntity) toCheck;
                validator.validate(transferwarehouse);
                GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(toCheck.getLocationCoordinates());
                toCheck.getLocationCoordinates().setId(geoCoordinate.getId());
                hop = transferwarehouseRepository.save(transferwarehouse);

            } else {
                System.out.println("Der angegebene Hop-Type existiert nicht");
            }
        }catch (Exception e){
            log.error("Could not save Hop",e);
        }

        return hop;
    }


    private void deleteDBEntries(){
        warehouseNextHopsRepository.deleteAll();
        warehouseRepository.deleteAll();
        hopRepository.deleteAll();
        truckRepository.deleteAll();
        transferwarehouseRepository.deleteAll();
        geoCoordinateRepository.deleteAll();
    }


}
