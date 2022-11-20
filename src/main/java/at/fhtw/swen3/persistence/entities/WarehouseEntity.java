package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Warehouse")
@Table(name = "warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private Integer level = null;

    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<WarehouseNextHopsEntity>();

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<WarehouseNextHopsEntity> getNextHops() {
        return nextHops;
    }

    public void setNextHops(List<WarehouseNextHopsEntity> nextHops) {
        this.nextHops = nextHops;
    }
}
