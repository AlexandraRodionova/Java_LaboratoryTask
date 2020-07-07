package com.company;

import com.company.Airline.Airline;
import com.company.Airline.Exception.AirlineLogicException;
import com.company.Airline.Serializator.SerializationFlow;
import com.company.Airline.Serializator.Serializator;

import java.io.InvalidObjectException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AirlineLogicException {
        Scanner scanner = new Scanner(System.in);
        Airline airline = new Airline(true);
        String file = "data\\demo.data";
        Serializator sz = new Serializator();
        SerializationFlow szFlow;
        int k = 1;
        while (true) {
            System.out.println("1)Show\n" +
                    "2)Capacity\n" +
                    "3)Carrying\n" +
                    "4)Sort\n" +
                    "5)Find fuel plane\n" +
                    "6)Add plane\n" +
                    "7)Serialization\n" +
                    "8)Deserialization\n" +
                    "9)Get number of planes\n" +
                    "0)Exit");
            try {
                k = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Not a number");
                k = 0;
            }
            switch (k) {
                case 1:
                    airline.show();
                    break;
                case 2:
                    System.out.println("Capacity: " + airline.getCapacity());
                    break;
                case 3:
                    System.out.println("Carrying: " + airline.getCarrying());
                    break;
                case 4:
                    airline.sort();
                    break;
                case 5:
                    airline.findFuelPlane().show();
                    break;
                case 6:
                    airline.addPlane();
                    break;
                case 7:
                    szFlow=new SerializationFlow(sz,airline,file);
                    szFlow.serOrDeser=true;
                    szFlow.start();
                    break;
                case 8:
                    szFlow=new SerializationFlow(sz,airline,file);
                    szFlow.serOrDeser=false;
                    szFlow.start();
                    break;
                case 9:
                    System.out.println("Number of planes: " + airline.getNumberOfPlanes());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Error!");
            }
        }
    }
}
