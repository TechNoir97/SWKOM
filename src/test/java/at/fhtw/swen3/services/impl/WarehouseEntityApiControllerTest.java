package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.controller.rest.WarehouseApiController;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;

@ExtendWith(MockitoExtension.class)
class WarehouseEntityApiControllerTest {

    @InjectMocks
    WarehouseApiController warehouseApiController;

    @Mock
    WarehouseEntity warehouseEntity;
    HopEntity hopEntity;
    GeoCoordinateEntity geoCoordinateEntity;


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