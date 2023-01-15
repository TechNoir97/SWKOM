package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.controller.rest.ParcelApiController;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

public class PathPredictionService {


    private final HopRepository hopRepository;
    private final WarehouseRepository warehouseRepository;
    private static final Logger log = LoggerFactory.getLogger(PathPredictionService.class);

    public PathPredictionService(HopRepository hopRepository, WarehouseRepository warehouseRepository) {
        this.hopRepository = hopRepository;
        this.warehouseRepository = warehouseRepository;

    }




    public List<HopArrivalEntity> getFutureHops(GeoCoordinateEntity sender, GeoCoordinateEntity recipient){
        List<HopArrivalEntity> futureHops= new ArrayList<>();

        List<WarehouseEntity> warehouses = warehouseRepository.findAll();
        WarehouseEntity root = warehouseRepository.findByLevel(0);
        WarehouseEntity nearestWarehouseSender = findNearestWarehouse(sender, warehouses);
        WarehouseEntity nearestWarehouseRecipient = findNearestWarehouse(recipient, warehouses);

        List<HopArrivalEntity> pathFromSender = getPathFromRoot(root, nearestWarehouseSender);
        List<HopArrivalEntity> pathFromRecipient = getPathFromRoot(root, nearestWarehouseRecipient);
        pathFromRecipient = reverseList(pathFromRecipient);
        pathFromRecipient.remove(0);
        futureHops = pathFromSender;
        for(HopArrivalEntity entity : pathFromRecipient){
            futureHops.add(entity);
        }
        return futureHops;
    }

    private List<HopArrivalEntity> reverseList(List<HopArrivalEntity> toReverse){
        if(toReverse.size() > 0) {
            HopArrivalEntity tmp = toReverse.get(0);
            toReverse.remove(0);
            reverseList(toReverse);
            toReverse.add(tmp);
        }
        return toReverse;
            }

    //Hier wird die Route vom obersten Warehouse zum untersten berechnet
    private List<HopArrivalEntity> getPathFromRoot(WarehouseEntity current, WarehouseEntity endPoint){
        List<HopArrivalEntity> hops = new ArrayList<>();
        if(current == endPoint){
            HopArrivalEntity nextHop = new HopArrivalEntity();
            HopArrivalEntity currentHop = new HopArrivalEntity();
            nextHop.setCode(current.getNextHops().get(0).getHop().getCode());
            nextHop.setDateTime(OffsetDateTime.now());
            nextHop.setDescription(current.getNextHops().get(0).getHop().getDescription());
            currentHop.setCode(current.getCode());
            currentHop.setDateTime(OffsetDateTime.now());
            currentHop.setDescription(current.getDescription());
            hops.add(nextHop);
            hops.add(currentHop);
            return hops;
        }

        for(WarehouseNextHopsEntity nextHops : current.getNextHops()){
            if(nextHops.getHop().getHopType().equals("warehouse")){
                hops = getPathFromRoot((WarehouseEntity) current.getNextHops().get(0).getHop(), endPoint);
                HopArrivalEntity newHop = new HopArrivalEntity();
                newHop.setCode(nextHops.getHop().getCode());
                newHop.setDescription(nextHops.getHop().getDescription());
                newHop.setDateTime(OffsetDateTime.now());
                hops.add(newHop);
                return hops;
            }
        }
        return hops;
    }

    //Sucht nach dem nächstgelegenen Warehouse
    private WarehouseEntity findNearestWarehouse(GeoCoordinateEntity geoCoordinate, List<WarehouseEntity> warehouseEntities){
        WarehouseEntity nearestWarehouse= warehouseEntities.get(0);
        Point parcelCoordinates = new Point(geoCoordinate.getLat(), geoCoordinate.getLon());
        Point warehouseCoordinates = new Point(nearestWarehouse.getLocationCoordinates().getLat(), nearestWarehouse.getLocationCoordinates().getLon());
        double shortestDistance = getDistance(parcelCoordinates, warehouseCoordinates);
        double newDistance;

        for(WarehouseEntity warehouseEntity: warehouseEntities){
            warehouseCoordinates = new Point(warehouseEntity.getLocationCoordinates().getLat(), warehouseEntity.getLocationCoordinates().getLon());
            newDistance = getDistance(parcelCoordinates, warehouseCoordinates);
            if(newDistance < shortestDistance){
                shortestDistance = newDistance;
                nearestWarehouse = warehouseEntity;
            }
        }
        log.info("Distanz: " + shortestDistance);
        return nearestWarehouse;

    }

    private double getDistance(Point a, Point b){
        //Man kann sich die Koordinaten als Dreieck vorstellen und c ist die Distanz zwischen den Punkten -> a² + b² = c²
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
    }
}
