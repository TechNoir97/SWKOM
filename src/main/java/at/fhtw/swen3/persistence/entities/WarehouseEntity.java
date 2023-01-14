package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Warehouse")
@DiscriminatorValue("warehouse")
@Table(name = "warehouse")
public class WarehouseEntity extends HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private Integer level = null;

    @NotNull
    @OneToMany(mappedBy = "parentHop", targetEntity = WarehouseNextHopsEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
