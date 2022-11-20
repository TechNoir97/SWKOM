package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;

@Entity(name = "Transferwarehouse")
@Table(name = "transferwarehouse")
public class TransferwarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
