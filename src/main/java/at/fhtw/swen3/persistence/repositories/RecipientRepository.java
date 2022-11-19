package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {
    RecipientEntity findByCity(String city);
    RecipientEntity findByName(String name);
    RecipientEntity findByCountry(String country);
    RecipientEntity findByStreet(String street);
    RecipientEntity findByPostalCode(String postalCode);

}
