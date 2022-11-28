package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ErrorEntity;

public class BLException extends Exception{

    private Exception innerException;
    private ErrorEntity errorEntity;
    //Die ID gibt an welchen Art von Exception es ist z.B. 1 = Validation Exception
    private long errorId;

    public BLException(long errorId, String s, Exception e){
        this.innerException = e;
        errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage(s);
        this.errorId = errorId;
    }


   /* @Override
    public String getMessage(){

    }*/
}
