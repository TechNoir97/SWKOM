package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entity.ParcelEntity;

public interface ParcelService {


    void submitNewParcel(ParcelEntity newParcel);
}
