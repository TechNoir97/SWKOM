package at.fhtw.swen3.persistence;

import at.fhtw.swen3.services.dto.HopDTO;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

public class WarehouseNextHops {
    private Integer traveltimeMins;
    @NotNull
    private HopDTO hop;

    public HopDTO getHop() {
        return hop;
    }

    public void setHop(HopDTO hop) {
        this.hop = hop;
    }

    public Integer getTraveltimeMins() {
        return traveltimeMins;
    }

    public void setTraveltimeMins(Integer traveltimeMins) {
        this.traveltimeMins = traveltimeMins;
    }
}
