package at.fhtw.swen3.persistence;

import at.fhtw.swen3.persistence.WarehouseNextHops;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    @JsonProperty("level")
    private Integer level = null;

    @JsonProperty("nextHops")
    @Valid
    @NotNull
    private List<WarehouseNextHops> nextHops = new ArrayList<WarehouseNextHops>();
}
