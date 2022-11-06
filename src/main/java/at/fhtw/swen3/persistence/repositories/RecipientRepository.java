package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {
    RecipientEntity findByCity(String city);
    RecipientEntity findByName(String name);
    RecipientEntity findByCountry(String country);
    RecipientEntity findByStreet(String street);
    RecipientEntity findByPostalCode(String postalCode);

}
