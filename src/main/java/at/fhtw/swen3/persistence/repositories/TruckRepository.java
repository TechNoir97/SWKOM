package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface TruckRepository extends JpaRepository<TruckEntity, Integer> {
    TruckEntity findByNumberPlate(String numberPlate);
    TruckEntity findByRegionGeoJson(String regionGeoJson);
}
