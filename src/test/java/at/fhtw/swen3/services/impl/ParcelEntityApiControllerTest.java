package at.fhtw.swen3.services.impl;

import org.junit.jupiter.api.Test;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class ParcelEntityApiControllerTest {

    @InjectMocks
    ParcelApiController parcelApiController;

    @Mock
    ParcelEntity parcelEntity;

    @Test
    void reportParcelHop() {

    }

    @Test
    void submitParcel() {
       /* MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(parcel.addParcel(any(Parcel.class))).thenReturn(true);

        Parcel parcel = new Parcel(4, "Tjong", "Alesch");
        ResponseEntity<Object> responseEntity = parcelApiController.addParcel(parcel);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");*/
    }


    @Test
    void trackParcel() {/*
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
                .isEqualTo(parcel2.getRecipient());*/
    }

    @Test
    void transitionParcel() {
    }
}