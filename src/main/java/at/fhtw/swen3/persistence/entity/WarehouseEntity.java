package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Warehouse")
public class WarehouseEntity {
    @Id
    private Integer level = null;

    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<WarehouseNextHopsEntity>();
}
