package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Double> I = new ArrayList<>();
        ArrayList<Double> U = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            I.add(Math.random() * 100);
            U.add(Math.random() * 100);
        }
        double R1 = 0;// среднее значение
        double R2 = 0;// погрешность
        double I1 = 0;
        double U1 = 0;
        for (int i = 0; i < n; i++) {
            U1 += U.get(i) * I.get(i);
            I1 += Math.pow(I.get(i), 2);
        }
        R1 = U1 / I1;
        for (int i = 0; i < n; i++) {
            R2 += Math.pow(R1 * I.get(i) - U.get(i), 2);
        }
        R2 = Math.sqrt(R2 / (I1 * (n - 2)));
        System.out.print("I: ");
        for (double i : I) {
            System.out.print(i + "\t");
        }
        System.out.print("\nU: ");
        for (double u : U) {
            System.out.print(u + "\t");
        }
        System.out.print("\nR = "+R1 + " +/- " + R2);
    }
}
