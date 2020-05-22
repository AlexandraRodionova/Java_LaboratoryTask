package com.company;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plane implements Serializable {
    static Scanner scanner=new Scanner(System.in);
    String name;
    int capacity;                      //вместимость
    double carrying;                   //грузоподъёмность
    double range;                      //дальность полёта
    double fuelConsumptionParameters;  //параметры потребления горючего
    private static final long serialVersionUID = 1L;
    Plane() throws AirlineLogicException {
        try{
            System.out.print("Name: ");
            name=scanner.next();
            System.out.print("Capacity: ");
            capacity=scanner.nextInt();
            System.out.print("Carrying: ");
            carrying=scanner.nextDouble();
            System.out.print("Range: ");
            range=scanner.nextDouble();
            System.out.print("Fuel consumption parameters: ");
            fuelConsumptionParameters=scanner.nextDouble();
        }catch (InputMismatchException e){
            System.err.println(e);
        }
        if(capacity<0 || carrying<0 ||range<=0 || fuelConsumptionParameters<=0)
            throw new AirlineLogicException("Illegal arguments!");
    }
    Plane(String name,int capacity,double carrying, double range, double fuelConsumptionParameters){
        this.name=name;
        this.capacity=capacity;
        this.range=range;
        this.carrying=carrying;
        this.fuelConsumptionParameters=fuelConsumptionParameters;
    }
    void show(){
        System.out.println("Name: "+name
                + "\nCapacity: "+capacity
                +"\nCarrying: "+carrying
                +"\nRange: "+range
                +"\nFuel consumption parameters: "+fuelConsumptionParameters);
    }
    public String toString(){
        return(name+"\t"+capacity+"\t"+carrying+"\t"+range+"\t"+fuelConsumptionParameters);
    }
}
