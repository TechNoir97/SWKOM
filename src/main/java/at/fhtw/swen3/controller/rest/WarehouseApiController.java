package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "at.fhtw.swen3.codegen.v3.generators.java.SpringCodegen", date = "2022-09-18T11:41:55.463Z[GMT]")
@RestController
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    private static final Logger log = LoggerFactory.getLogger(WarehouseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final WarehouseService warehouseService;

    @org.springframework.beans.factory.annotation.Autowired
    public WarehouseApiController(ObjectMapper objectMapper, HttpServletRequest request, WarehouseService warehouseService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.warehouseService = warehouseService;
    }

    public ResponseEntity<Warehouse> exportWarehouses() {
        log.info("WarehouseApiController: exportWarehouse()");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Warehouse>(objectMapper.readValue("\"\"", Warehouse.class), HttpStatus.OK);//TODO muss aber noch implementiert werden
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Warehouse>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<Warehouse>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<Hop> getWarehouse(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code) {
        log.info("WarehouseApiController: getWarehouse()");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Hop>(objectMapper.readValue("{\n  \"code\" : \"code\",\n  \"locationName\" : \"locationName\",\n  \"processingDelayMins\" : 0,\n  \"hopType\" : \"hopType\",\n  \"description\" : \"description\",\n  \"locationCoordinates\" : {\n    \"lon\" : 1.4658129805029452,\n    \"lat\" : 6.027456183070403\n  }\n}", Hop.class), HttpStatus.OK);
                //TODO muss aber noch implementiert werden
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Hop>(HttpStatus.BAD_GATEWAY);

            }
        }

        return new ResponseEntity<Hop>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<Void> importWarehouses(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Warehouse warehouse) {
        try{
            log.info("WarehouseApiController: importWarehouse()");
            WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
            warehouseService.importWarehouses(warehouseEntity);


            String accept = request.getHeader("Accept");
            return new ResponseEntity<Void>(HttpStatus.CREATED);//TODO muss aber noch implementiert werden
        }catch (Exception e){
            System.out.println("Could not import warehouses - WarehouseApiController");
            log.error("Could not import warehouses - WarehouseApiController",e);
            return null;
        }

    }

}
