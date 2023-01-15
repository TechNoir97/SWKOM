package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import ch.qos.logback.core.encoder.EchoEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "at.fhtw.swen3.codegen.v3.generators.java.SpringCodegen", date = "2022-09-18T11:41:55.463Z[GMT]")
@RestController
@Slf4j
public class ParcelApiController implements ParcelApi {

    private static final Logger log = LoggerFactory.getLogger(ParcelApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ParcelService parcelService;

    @org.springframework.beans.factory.annotation.Autowired
    public ParcelApiController(ObjectMapper objectMapper, HttpServletRequest request, ParcelService parcelService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.parcelService = parcelService;
    }

    public ResponseEntity<Void> reportParcelDelivery(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId) {
        try{
            log.info("ParcelApiController: reportParcelDelivery()");
            String accept = request.getHeader("Accept");
            reportParcelDelivery(trackingId);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println("Can't report delivery - ParcelApiController");
            log.error("Can't report delivery - ParcelApiController",e);
            return null;
        }

    }

    public ResponseEntity<Void> reportParcelHop(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Pattern(regexp="^[A-Z]{4}\\d{1,4}$") @Parameter(in = ParameterIn.PATH, description = "The Code of the hop (Warehouse or Truck).", required=true, schema=@Schema()) @PathVariable("code") String code) {
        try{
            log.info("ParcelApiController: reportParcelHop()");
            String accept = request.getHeader("Accept");
            reportParcelHop(trackingId,code);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println("Can't report parcel hop");
            log.error("Can't report parcel hop",e);
            return null;
        }

    }

    @RequestMapping(value = "/parcel",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<NewParcelInfo> submitParcel(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel parcel) {
        log.info("ParcelApiController: submitParcel() -> Parcel Recipient: " + parcel.getRecipient().getName());
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
                log.info("ParcelApiController: submitParcel() -> ParcelEntity Recipient: " + parcelEntity.getRecipient().getName());


                NewParcelInfo newParcelInfo = parcelService.submitNewParcel(parcelEntity);
                return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<NewParcelInfo>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<TrackingInformation> trackParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId) {
        log.info("ParcelApiController: trackParcel()");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                TrackingInformation newTrackinginformation = parcelService.trackParcel(trackingId);
                return new ResponseEntity<TrackingInformation>(newTrackinginformation, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TrackingInformation>(HttpStatus.BAD_REQUEST);

            }
        }

        return new ResponseEntity<TrackingInformation>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<NewParcelInfo> transitionParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body) {
        log.info("ParcelApiController: transitionParcel()");
        String accept = request.getHeader("Accept");
        NewParcelInfo transparselinfo = new NewParcelInfo();
        if (accept != null && accept.contains("application/json")) {
            try {
                transparselinfo = parcelService.transitionParcel(trackingId, body);
                return new ResponseEntity<NewParcelInfo>(transparselinfo, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_GATEWAY);

            }
        }

        return new ResponseEntity<NewParcelInfo>(HttpStatus.CONFLICT);
    }

}
