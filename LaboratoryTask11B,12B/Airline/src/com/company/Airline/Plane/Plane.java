package com.company.Airline.Plane;

import com.company.Airline.Exception.AirlineLogicException;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Plane implements Serializable {
    static Scanner scanner=new Scanner(System.in);
    public String type;
    public String name;
    public int capacity;                      //вместимость
    public double carrying;                   //грузоподъёмность
    public double range;                      //дальность полёта
    public double fuelConsumptionParameters;  //параметры потребления горючего
    private static final long serialVersionUID = 1L;
    public Plane() throws AirlineLogicException {
        try{
            System.out.print("Type: ");
            type=scanner.next();
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
    public Plane(String type,String name,int capacity,double carrying, double range, double fuelConsumptionParameters){
        this.type=type;
        this.name=name;
        this.capacity=capacity;
        this.range=range;
        this.carrying=carrying;
        this.fuelConsumptionParameters=fuelConsumptionParameters;
    }
    public Plane(String type) throws AirlineLogicException{
        this.type=type;
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
    public void show(){
        System.out.println("Type: "+type
                +"\nName: "+name
                + "\nCapacity: "+capacity
                +"\nCarrying: "+carrying
                +"\nRange: "+range
                +"\nFuel consumption parameters: "+fuelConsumptionParameters);
    }
    public String toString(){
        return(type+"\t"+name+"\t"+capacity+"\t"+carrying+"\t"+range+"\t"+fuelConsumptionParameters);
    }
}
