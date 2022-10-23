package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.persistence.Warehouse;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import at.fhtw.swen3.persistence.Hop;
import at.fhtw.swen3.persistence.GeoCoordinate;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WarehouseApiControllerTest {

    @InjectMocks
    WarehouseApiController warehouseApiController;

    @Mock
    Warehouse warehouse;
    Hop hop;
    GeoCoordinate geoCoordinate;


    @Test
    void exportWarehouses() {

    }

    @Test
    void getWarehouse() {
        /*MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        //when(hop.setHop(any(Hop.class));).thenReturn(true);
        GeoCoordinate geoCoordinate = new GeoCoordinate().lat(45.438759).lon(12.327145);
        Hop hop = new Hop().hopType("forward").code("RYX4884326").description("Milano to Venecia").processingDelayMins(2).locationName("Venecia").locationCoordinates(geoCoordinate);


        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");*/
    }

    @Test
    void importWarehouses() {
    }
}