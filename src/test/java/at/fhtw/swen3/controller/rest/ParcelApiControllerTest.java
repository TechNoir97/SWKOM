package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

class ParcelApiControllerTest {


    static void setup(){
        String trackingID = "PYJRB4HZ6";
        String code = "ABCD1234";
        ParcelEntity testParcel = new ParcelEntity();
         Parcel body = new Parcel();
    }

    @Test
    void reportParcelDelivery() {

    }

    @Test
    void reportParcelHop() {
    }

    @Test
    void submitParcel() {
    }

    @Test
    void trackParcel() {
    }

    @Test
    void transitionParcel() {
    }
}