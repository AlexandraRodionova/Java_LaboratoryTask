package com.company.Airline.Exception;

public class AirlineLogicException extends Exception{
    public AirlineLogicException(){
        super();
    }
    public AirlineLogicException(String message,Throwable exception){
        super(message,exception);
    }
    public AirlineLogicException(String message){
        super(message);
    }
    public AirlineLogicException(Throwable exception){
        super(exception);
    }
}
