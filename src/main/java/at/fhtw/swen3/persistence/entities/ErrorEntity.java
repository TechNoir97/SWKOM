package at.fhtw.swen3.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Error")
public class ErrorEntity {
    @Id
    private String errorMessage;
}
