package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Integer> {
    HopArrivalEntity findByCode(String code);
    HopArrivalEntity findByDateTime(OffsetDateTime dateTime);
}
