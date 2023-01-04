package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-03T13:57:29+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setWeight( parcel.getWeight() );
        parcelEntity.setSender( recipientToRecipientEntity( parcel.getSender() ) );
        parcelEntity.setRecipient( recipientToRecipientEntity( parcel.getRecipient() ) );

        return parcelEntity;
    }

    @Override
    public Parcel entityToDto(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        Parcel parcel = new Parcel();

        parcel.setWeight( parcelEntity.getWeight() );
        parcel.setRecipient( recipientEntityToRecipient( parcelEntity.getRecipient() ) );
        parcel.setSender( recipientEntityToRecipient( parcelEntity.getSender() ) );

        return parcel;
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setCity( recipient.getCity() );
        recipientEntity.setCountry( recipient.getCountry() );
        recipientEntity.setName( recipient.getName() );
        recipientEntity.setPostalCode( recipient.getPostalCode() );
        recipientEntity.setStreet( recipient.getStreet() );

        return recipientEntity;
    }

    protected Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( recipientEntity.getName() );
        recipient.setStreet( recipientEntity.getStreet() );
        recipient.setPostalCode( recipientEntity.getPostalCode() );
        recipient.setCity( recipientEntity.getCity() );
        recipient.setCountry( recipientEntity.getCountry() );

        return recipient;
    }
}
