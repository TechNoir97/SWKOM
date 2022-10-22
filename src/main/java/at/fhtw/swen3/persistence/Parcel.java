package at.fhtw.swen3.persistence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public class Parcel {
    //From parcel
    private Float weight;
    private Recipient recipient;
    private Recipient sender;

    //From NewParcelInfo
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

    //TODO muss noch auskommentiert werden und in den Mapper reingegebene werden
    //private List<HopArrival> visitedHops = new ArrayList<HopArrival>();
    //private List<HopArrival> futureHops = new ArrayList<HopArrival>();

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Recipient getSender() {
        return sender;
    }

    public void setSender(Recipient sender) {
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
}
