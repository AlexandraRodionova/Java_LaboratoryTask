package com.company.Airline;

import com.company.Airline.Exception.AirlineLogicException;
import com.company.Airline.Plane.Classification.CargoPlane;
import com.company.Airline.Plane.Classification.PassengerPlane;
import com.company.Airline.Plane.Plane;
import com.company.DataBase;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Airline implements Serializable {
    static Scanner scanner = null;
    Plane[] planes;
    private static int numberOfPlanes;
    private static final long serialVersionUID = 1L;

    public Airline(boolean bool) {
        DataBase dataBase = new DataBase();
        try {
            String sql = "SELECT type,name,capacity,carrying,distance ,fuelConsumptionParameters FROM planes.planes";
            ResultSet resultSet = dataBase.statement.executeQuery(sql);
            ArrayList<Plane> planes = new ArrayList<>();
            while(resultSet.next()){
                numberOfPlanes++;
                planes.add(new Plane(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6)));
            }
            this.planes=new Plane[numberOfPlanes];
            for(int i=0;i<numberOfPlanes;i++)
                this.planes[i]=planes.get(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Airline() {
        try {
            FileReader fr = new FileReader("text\\Planes.txt");
            scanner = new Scanner(fr);
            int numberOfPlanes = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numberOfPlanes++;
            }
            this.numberOfPlanes = numberOfPlanes;
            planes = new Plane[this.numberOfPlanes];
            fr = new FileReader("text\\Planes.txt");
            scanner = new Scanner(fr);
            for (int i = 0; i < this.numberOfPlanes; i++) {
                String type = scanner.next();
                if (type == "CP")
                    planes[i] = new CargoPlane(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
                else if (type == "PP")
                    planes[i] = new PassengerPlane(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
                else
                    planes[i] = new Plane(type, scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public void show() {
        for (int i = 0; i < numberOfPlanes; i++) {
            System.out.println("Plane №" + (i + 1) + ":");
            planes[i].show();
            System.out.println();
        }
    }

    public int getCapacity() {
        int s = 0;
        for (int i = 0; i < numberOfPlanes; i++)
            s += planes[i].capacity;
        return s;
    }

    public int getCarrying() {
        int s = 0;
        for (int i = 0; i < numberOfPlanes; i++)
            s += planes[i].carrying;
        return s;
    }

    public Plane findFuelPlane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Min: ");
        double min = scanner.nextDouble();
        System.out.print("Max: ");
        double max = scanner.nextDouble();
        Plane plane = new Plane("Not found", " ", 0, 0, 0, 0);
        for (int i = 0; i < numberOfPlanes; i++) {
            if (planes[i].fuelConsumptionParameters >= min && planes[i].fuelConsumptionParameters <= max) {
                return planes[i];
            }
        }
        return plane;
    }

    public void sort() {
        double[] sort = new double[numberOfPlanes];
        double[] oldSort = new double[numberOfPlanes];
        for (int i = 0; i < numberOfPlanes; i++) {
            sort[i] = planes[i].fuelConsumptionParameters;
            oldSort[i] = sort[i];
        }
        for (int i = 0; i < numberOfPlanes; i++) {
            for (int j = 0; j < numberOfPlanes - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    double k = sort[j + 1];
                    sort[j + 1] = sort[j];
                    sort[j] = k;
                }
            }
        }
        try (FileWriter fw = new FileWriter("text\\Sorted.txt")) {
            for (int i = 0; i < numberOfPlanes; i++) {
                for (int j = 0; j < numberOfPlanes; j++) {
                    if (oldSort[j] == sort[i]) {
                        oldSort[j] = 0;
                        fw.write(planes[j].toString());
                        fw.append('\n');
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void addPlane() throws AirlineLogicException {
        Plane plane = new Plane();
        Plane[] planes = this.planes;
        numberOfPlanes++;
        this.planes = new Plane[numberOfPlanes];
        for (int i = 0; i < numberOfPlanes - 1; i++)
            this.planes[i] = planes[i];
        this.planes[numberOfPlanes - 1] = plane;
    }

    public int getNumberOfPlanes() {
        return numberOfPlanes;
    }

    public void setNumberOfPlanes(int numberOfPlanes) {
        this.numberOfPlanes = numberOfPlanes;
    }
}
