package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Integer> {
    WarehouseNextHopsEntity findById(int id);
    WarehouseNextHopsEntity findByHop(HopEntity hop);
}
