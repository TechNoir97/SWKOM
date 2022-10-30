package at.fhtw.swen3.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Error")
public class ErrorEntity {
    @Id
    private String errorMessage;
}
