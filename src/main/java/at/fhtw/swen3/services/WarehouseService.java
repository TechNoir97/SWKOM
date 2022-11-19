package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;

public interface WarehouseService {
    public void importWarehouses(WarehouseEntity warehouse);
    public void exportWarehouses();
    public List<Warehouse> getWarehouse();

}
