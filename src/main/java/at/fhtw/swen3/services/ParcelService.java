package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;

import java.util.List;

public interface ParcelService {


    public void submitNewParcel(ParcelEntity newParcel);
    public List<Parcel> getParcels();
    public void deleteParcelById(int id);
    public void updateParcelInfo(int id, ParcelEntity parcelEntity);

}
