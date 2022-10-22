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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WarehouseApiControllerTest {

    @InjectMocks
    WarehouseApiController warehouseApiController;

    @Mock
    Warehouse warehouse;

//TODO: ParcelApiControllerTest auf WarehouseApiControllerTest anwenden!
    @Test
    void exportWarehouses() {
    }

    @Test
    void getWarehouse() {

    }

    @Test
    void importWarehouses() {
    }
}