package at.fhtw.swen3.persistence.entities;

import org.springframework.data.geo.Polygon;

import javax.persistence.*;

@Entity(name = "Transferwarehouse")
@Table(name = "transferwarehouse")
public class TransferwarehouseEntity extends HopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(columnDefinition = "text")
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;

    private Polygon regionGeo;

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

    public Polygon getRegionGeo() {
        return regionGeo;
    }

    public void setRegionGeo(Polygon regionGeo) {
        this.regionGeo = regionGeo;
    }
}
