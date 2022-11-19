package at.fhtw.swen3.persistence.entities;

import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "HopArrival")
@Table
public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;
    @NotNull
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn
    @NotNull
    private ParcelEntity parcel;

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
}
