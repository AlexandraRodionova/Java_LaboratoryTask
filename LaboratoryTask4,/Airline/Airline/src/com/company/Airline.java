package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Airline implements Serializable {
    static Scanner scanner = null;
    Plane[] planes;
    private static int numberOfPlanes;
    private static final long serialVersionUID = 1L;

    Airline() {
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
                planes[i] = new Plane(scanner.next(), scanner.nextInt(), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    void show() {
        for (int i = 0; i < numberOfPlanes; i++) {
            System.out.println("Plane №" + (i + 1) + ":");
            planes[i].show();
            System.out.println();
        }
    }

    int getCapacity() {
        int s = 0;
        for (int i = 0; i < numberOfPlanes; i++)
            s += planes[i].capacity;
        return s;
    }

    int getCarrying() {
        int s = 0;
        for (int i = 0; i < numberOfPlanes; i++)
            s += planes[i].carrying;
        return s;
    }

    Plane findFuelPlane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Min: ");
        double min = scanner.nextDouble();
        System.out.print("Max: ");
        double max = scanner.nextDouble();
        Plane plane = new Plane("Not found", 0, 0, 0, 0);
        for (int i = 0; i < numberOfPlanes; i++) {
            if (planes[i].fuelConsumptionParameters >= min && planes[i].fuelConsumptionParameters <= max) {
                return planes[i];
            }
        }
        return plane;
    }

    void sort() {
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

    void addPlane() throws AirlineLogicException {
        Plane plane = new Plane();
        Plane[] planes = this.planes;
        numberOfPlanes++;
        this.planes = new Plane[numberOfPlanes];
        for (int i = 0; i < numberOfPlanes - 1; i++)
            this.planes[i] = planes[i];
        this.planes[numberOfPlanes - 1] = plane;
    }

    int getNumberOfPlanes() {
        return numberOfPlanes;
    }
    void setNumberOfPlanes(int numberOfPlanes){
        this.numberOfPlanes =numberOfPlanes;
    }
}
