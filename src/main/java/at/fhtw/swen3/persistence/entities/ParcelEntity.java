package at.fhtw.swen3.persistence.entities;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Parcel")
@Table(name = "parcel")
@NoArgsConstructor
public class ParcelEntity {
    //From parcel
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @PositiveOrZero
    @DecimalMin(value = "0.0")
    private Float weight;

    @NotNull
    @ManyToOne
    @JoinColumn
    private RecipientEntity recipient;

    @NotNull
    @ManyToOne
    @JoinColumn
    private RecipientEntity sender;

    //From NewParcelInfo


    @Pattern(regexp="^[A-Z0-9]{9}$")
    private String trackingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //From TrackingInformation
    public enum StateEnum {
        PICKUP("Pickup"),

        INTRANSPORT("InTransport"),

        INTRUCKDELIVERY("InTruckDelivery"),

        TRANSFERRED("Transferred"),

        DELIVERED("Delivered");

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StateEnum fromValue(String text) {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }
    //TODO Die @NotNull müssen wieder auskommentiert werden
    //@NotNull
    private StateEnum state = StateEnum.PICKUP;

    @OneToMany(mappedBy = "parcel",fetch =  FetchType.EAGER,  cascade=CascadeType.PERSIST)
    //@NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<HopArrivalEntity>();
    @OneToMany(mappedBy = "parcel",fetch =  FetchType.LAZY,  cascade=CascadeType.PERSIST)
    //@NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<HopArrivalEntity>();

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public RecipientEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientEntity recipientEntity) {
        this.recipient = recipientEntity;
    }

    public RecipientEntity getSender() {
        return sender;
    }

    public void setSender(RecipientEntity sender) {
        this.sender = sender;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public List<HopArrivalEntity> getFutureHops() {
        return futureHops;
    }

    public void setFutureHops(List<HopArrivalEntity> futureHops) {
        this.futureHops = futureHops;
    }

    public List<HopArrivalEntity> getVisitedHops() {
        return visitedHops;
    }

    public void setVisitedHops(List<HopArrivalEntity> visitedHops) {
        this.visitedHops = visitedHops;
    }
}
