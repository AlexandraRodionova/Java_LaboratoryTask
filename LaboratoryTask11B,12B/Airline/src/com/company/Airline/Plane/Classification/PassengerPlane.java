package com.company.Airline.Plane.Classification;

import com.company.Airline.Exception.AirlineLogicException;
import com.company.Airline.Plane.Plane;

//Пассажирский самолёт
public class PassengerPlane extends Plane {
    public PassengerPlane() throws AirlineLogicException {
        super("PP");
    }

    public PassengerPlane(String name, int capacity, double carrying, double range, double fuelConsumptionParameters) {
        super("PP", name, capacity, carrying, range, fuelConsumptionParameters);
    }
}
