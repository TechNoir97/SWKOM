package at.fhtw.swen3.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.threeten.bp.OffsetDateTime;

import javax.validation.constraints.Pattern;

public class HopArrival {
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;
    private OffsetDateTime dateTime;

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
}
