package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Integer> {
    TransferwarehouseEntity findById(int id);
    TransferwarehouseEntity findByRegionGeoJson(String regionGeoJson);
    TransferwarehouseEntity findByLogisticsPartner(String logisticsPartner);
    TransferwarehouseEntity findByLogisticsPartnerUrl(String logisticsPartnerUrl);
}
