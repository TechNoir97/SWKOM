package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Warehouse")
@Table
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Integer level = null;

    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<WarehouseNextHopsEntity>();
}
