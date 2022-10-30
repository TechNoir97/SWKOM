package at.fhtw.swen3.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Transferwarehouse")
public class TransferwarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;

    public String getLogisticsPartner() {
        return logisticsPartner;
    }
    public void setLogisticsPartner(String logisticsPartner) {
        this.logisticsPartner = logisticsPartner;
    }

    public String getLogisticsPartnerUrl() {
        return logisticsPartnerUrl;
    }
    public void setLogisticsPartnerUrl(String logisticsPartnerUrl) {
        this.logisticsPartnerUrl = logisticsPartnerUrl;
    }

    public String getRegionGeoJson() {
        return regionGeoJson;
    }
    public void setRegionGeoJson(String regionGeoJson) {
        this.regionGeoJson = regionGeoJson;
    }
}
