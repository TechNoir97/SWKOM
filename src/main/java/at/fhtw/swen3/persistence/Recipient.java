package at.fhtw.swen3.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "recipient")
@NoArgsConstructor
@Getter
@Setter

public class Recipient {
    @Id
    private String name = null;

    private String street = null;

    private String postalCode = null;

    private String city = null;
    @Column
    private String country = null;
}
