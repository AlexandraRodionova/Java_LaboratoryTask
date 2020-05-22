package com.company;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;

public class Round {
    Scanner scanner=new Scanner(System.in);
    Point center;
    double radius;
    Round(){
        center=new Point();
        System.out.print("Radius: ");
        try{
            radius=scanner.nextDouble();
            if (radius < 0) {
                throw new IllegalArgumentException();
            }
        }catch (InputMismatchException e){
            System.err.println(e);
        }
    }

    void show(){
        System.out.println("Center: ");
        center.show();
        System.out.println("Radius: "+radius);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Round.class.getSimpleName() + "[", "]")
                .add("center=" + center)
                .add("radius=" + radius)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Round)) return false;
        Round round = (Round) o;
        return Double.compare(round.radius, radius) == 0 &&
                Objects.equals(center, round.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    void changeRadius(){
        System.out.print("New radius: ");
        double radius;
        try{
            radius=scanner.nextDouble();
            if (radius <= 0) {
                throw new IllegalArgumentException();
            }
            this.radius=radius;
        }catch (InputMismatchException e){
            System.err.println(e);
        }
    }
}
