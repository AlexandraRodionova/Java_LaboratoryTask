package com.company.Airline.Serializator;

import com.company.Airline.Airline;

import java.io.InvalidObjectException;

public class SerializationFlow extends  Thread {
    Serializator sz;
    Airline airline;
    String file;
    public boolean serOrDeser;

    public SerializationFlow(Serializator sz, Airline airline, String file) {
        this.sz = sz;
        this.airline = airline;
        this.file = file;
        serOrDeser = true;
    }

    public void run() {
        if (serOrDeser) {
            boolean b = sz.serialization(airline, file);
        } else {
            try {
                airline = sz.deserialization(file);
            } catch (InvalidObjectException e) {
                e.printStackTrace();
            }
            if (airline != null)
                airline.show();
        }
    }
}