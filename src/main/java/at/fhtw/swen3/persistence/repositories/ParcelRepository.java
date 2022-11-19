package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {
    ParcelEntity findById(long id);
    ParcelEntity findByTrackingId(String trackingId);
    ParcelEntity findBySender(RecipientEntity sender);
    ParcelEntity findByRecipient(RecipientEntity recipient);
    ParcelEntity findByState(ParcelEntity.StateEnum state);
}
