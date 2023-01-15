package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
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
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;


import javax.validation.constraints.Null;
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
        List<WarehouseNextHopsEntity> nextHopsSaved = new ArrayList<WarehouseNextHopsEntity>();
        try {
            /*
            for(WarehouseNextHopsEntity nextHops : warehouse.getNextHops()){
                HopEntity hop = checkHopType(nextHops.getHop());
                warehouseNextHopsRepository.save(nextHops);
                nextHops.setParentHop(warehouse);
                nextHopsSaved.add(nextHops);
            }*/
            nextHopsSaved = checkHopType(warehouse.getNextHops().get(0).getHop(), warehouse);
           // warehouse.getNextHops().get(0).setParentHop(warehouseRepository.save(warehouse));
            warehouse.getNextHops().get(0).setParentHop(warehouse);
            warehouseNextHopsRepository.save(warehouse.getNextHops().get(0));
            warehouseRepository.save(warehouse);


        }catch (Exception e){
            throw new BLException(2L, "Failed to store warehouse", e);
        }
    }
    @Override
    public Hop getWarehouse(String code){
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
    public List<Hop> exportWarehouses(){
        List<HopEntity> hopEntities = hopRepository.findAll();
        List<Hop> hops = new ArrayList<>();
        try {
            for (HopEntity entity : hopEntities) {
                hops.add(HopMapper.INSTANCE.entityToDto(entity));
            }
            log.info("Get List of Warehouses");
            return hops;
        }catch(Exception e){
            System.out.println("Could not get Warehouse");
            log.error("Could not get Warehouse",e);

            }
        return null;
        }
    private List<WarehouseNextHopsEntity> checkHopType(HopEntity toCheck, WarehouseEntity root) throws BLException {
        log.info("checkHopType: " + toCheck);


        List<WarehouseNextHopsEntity> nextHopsSaved = new ArrayList<WarehouseNextHopsEntity>();
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinateEntity geoCoordinate = geoCoordinateRepository.save(toCheck.getLocationCoordinates());
        toCheck.getLocationCoordinates().setId(geoCoordinate.getId());
        try {
            if (toCheck.getHopType().equals("warehouse")) {
                WarehouseEntity warehouse = (WarehouseEntity) toCheck;
                validator.validate(warehouse);
                if (!warehouse.getNextHops().isEmpty()){
                    for(int i = 0; i < warehouse.getNextHops().size(); i++) {
                        nextHopsSaved = checkHopType(warehouse.getNextHops().get(i).getHop(), root);
                    }
                }

                    WarehouseNextHopsEntity nextHop = warehouse.getNextHops().get(0);
                    if(warehouseRepository.findByLevel(warehouse.getLevel()) != null){
                        nextHop.setParentHop(warehouseRepository.findByLevel(warehouse.getLevel()));
                    }else{
                        nextHop.setParentHop(warehouseRepository.save(warehouse));
                    }
                    nextHop.getHop().getLocationCoordinates().setCoordinates();
                    warehouse.getLocationCoordinates().setCoordinates();
                    GeoCoordinateEntity nextHopCoordinates = geoCoordinateRepository.save(nextHop.getHop().getLocationCoordinates());
                    nextHop.getHop().getLocationCoordinates().setId(nextHopCoordinates.getId());
                    GeoCoordinateEntity parentHopCoordinates = geoCoordinateRepository.save(warehouse.getLocationCoordinates());
                    nextHop.getParentHop().getLocationCoordinates().setId(parentHopCoordinates.getId());
                    nextHop.setHop(hopRepository.findByCode(nextHop.getHop().getCode()));
                    nextHop.setParentHop(hopRepository.findByCode(nextHop.getParentHop().getCode()));
                    warehouseNextHopsRepository.save(nextHop);
                    nextHopsSaved.add(nextHop);

                    warehouse.getNextHops().remove(0);

                warehouseRepository.save(warehouse);
            } else if (toCheck.getHopType().equals("truck")) {
                TruckEntity truck = (TruckEntity) toCheck;

                truck.setRegionGeo(bingEncodingProxy.getRegionGeo(truck.getRegionGeoJson()));
                validator.validate(truck);
                TruckEntity checkIfExists = truckRepository.findByNumberPlate(truck.getNumberPlate());
                if(checkIfExists == null) {
                    truckRepository.save(truck);
                }else {
                    System.out.println(checkIfExists.getRegionGeo());
                }
            } else if (toCheck.getHopType().equals("transferwarehouse")) {
                TransferwarehouseEntity transferwarehouse = (TransferwarehouseEntity) toCheck;
                transferwarehouse.setRegionGeo(bingEncodingProxy.getRegionGeo(transferwarehouse.getRegionGeoJson()));
                validator.validate(transferwarehouse);
                TransferwarehouseEntity checkIfExists = transferwarehouseRepository.findByLogisticsPartner(transferwarehouse.getLogisticsPartner());
                if(checkIfExists == null) {
                    transferwarehouseRepository.save(transferwarehouse);
                }


            } else {
                System.out.println("Der angegebene Hop-Type existiert nicht");
            }
        }catch (Exception e){
            log.error("Could not save Hop",e);
        }

        return nextHopsSaved;
    }


    private void deleteDBEntries(){
        try {
            truckRepository.deleteAll();
            warehouseNextHopsRepository.deleteAll();
            hopRepository.deleteAll();
            geoCoordinateRepository.deleteAll();
            transferwarehouseRepository.deleteAll();
            warehouseRepository.deleteAll();
        }catch (Exception e){
            log.error("Could not delete the DB",e);
        }
    }


}
