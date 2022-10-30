package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Hop;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "WarehouseNextHop")
public class WarehouseNextHopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Integer traveltimeMins;
    @NotNull
    @ManyToOne
    private HopEntity hop;

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
}
