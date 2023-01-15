package at.fhtw.swen3.persistence.entities;

import org.springframework.lang.Nullable;
import org.springframework.data.geo.Point;
import javax.persistence.*;

@Table(name = "geocoordinate")
@Entity(name = "GeoCoordinate")
public class GeoCoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private Double lat;
    private Double lon;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Point coordinates;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordinates() {
        this.coordinates = new Point(lat, lon);
    }

    public Point getCoordinates() {
        return coordinates;
    }
}
