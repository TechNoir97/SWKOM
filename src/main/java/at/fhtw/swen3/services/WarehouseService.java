package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;

public interface WarehouseService {
    public void importWarehouses(WarehouseEntity warehouse) throws BLException;
    public Hop getWarehouse(String hop);
    public List<Hop> exportWarehouses();

}
