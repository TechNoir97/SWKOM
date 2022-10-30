package at.fhtw.swen3.persistence.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Parcel")
public class ParcelEntity {
    //From parcel
    @Id
    private int id;
    @PositiveOrZero
    @Column
    @DecimalMin("BigDecimal")
    private Float weight;
    @Column
    @NotNull
    @ManyToOne
    private RecipientEntity recipientEntity;
    @Column
    @NotNull
    @ManyToOne
    private RecipientEntity sender;

    //From NewParcelInfo

    @Column
    @Pattern(regexp="^[A-Z0-9]{9}$")
    private String trackingId;

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

    private StateEnum state;

    @OneToMany
    @NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<HopArrivalEntity>();
    @OneToMany
    @NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<HopArrivalEntity>();

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public RecipientEntity getRecipient() {
        return recipientEntity;
    }

    public void setRecipient(RecipientEntity recipientEntity) {
        this.recipientEntity = recipientEntity;
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
