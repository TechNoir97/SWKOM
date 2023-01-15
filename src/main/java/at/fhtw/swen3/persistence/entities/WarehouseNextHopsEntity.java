package at.fhtw.swen3.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "WarehouseNextHop")
@Table(name = "warehousenexthop")
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private Integer traveltimeMins;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    private HopEntity hop;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "warehouse_entities_id")
    private HopEntity parentHop;

    public HopEntity getHop() {
        return hop;
    }

    public void setHop(HopEntity hop) {
        this.hop = hop;
    }

    public Integer getTraveltimeMins() {
        return traveltimeMins;
    }

    public void setTraveltimeMins(Integer traveltimeMins) {
        this.traveltimeMins = traveltimeMins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HopEntity getParentHop() {
        return parentHop;
    }

    public void setParentHop(HopEntity parentHop) {
        this.parentHop = parentHop;
    }
}
