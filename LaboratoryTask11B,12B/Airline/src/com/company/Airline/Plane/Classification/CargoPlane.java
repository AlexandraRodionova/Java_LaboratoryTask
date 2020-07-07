package com.company.Airline.Plane.Classification;

import com.company.Airline.Exception.AirlineLogicException;
import com.company.Airline.Plane.Plane;

// грузовой самолёт
public class CargoPlane extends Plane {
    public CargoPlane() throws AirlineLogicException {
        super("CP");
    }
    public CargoPlane(String name,int capacity,double carrying, double range, double fuelConsumptionParameters){
        super("CP",name,capacity,carrying,range,fuelConsumptionParameters);
    }

}
