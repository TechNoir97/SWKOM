package at.fhtw.swen3.services.impl;

import org.junit.jupiter.api.Test;
import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.persistence.Parcel;
import java.util.Arrays;
import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.services.ParcelApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import at.fhtw.swen3.persistence.Parcel;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class ParcelApiControllerTest {

    @InjectMocks
    ParcelApiController parcelApiController;

    @Mock
    Parcel parcel;

    @Test
    void reportParcelHop() {

    }

    /*@Test
    void submitParcel() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(parcel.addParcel(any(Parcel.class))).thenReturn(true);

        Parcel parcel = new Parcel(4, "Tjong", "Alesch");
        ResponseEntity<Object> responseEntity = parcelApiController.addParcel(parcel);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }*/

/*
    @Test
    void trackParcel() {
        // given
        Parcel parcel1 = new Parcel(4, "Tjong", "Alesch");
        Parcel parcel2 = new Parcel(2, "Alex", "Gussin");
        Parcel parcels = new Parcels();
        parcels.setParcels(Arrays.asList(parcel1, parcel2));

        when(parcel.getAllParcels()).thenReturn(parcels);

        // when
        Parcels result = parcelApiController.getParcels();

        // then
        assertThat(result.getParcelList().size()).isEqualTo(4);

        assertThat(result.getParcelList().get(0).getSender())
                .isEqualTo(parcel1.getSender());

        assertThat(result.getParcelList().get(1).getRecipient())
                .isEqualTo(parcel2.getRecipient());
    }
*/
    @Test
    void transitionParcel() {
    }
}