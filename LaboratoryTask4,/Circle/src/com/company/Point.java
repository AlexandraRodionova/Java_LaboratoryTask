package com.company;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;

public class Point {
    Scanner scanner=new Scanner(System.in);
    double x;
    double y;
    Point(){
        System.out.print("x: ");
        try{
            x=scanner.nextDouble();
        }catch(InputMismatchException e){
            System.err.println(e);
        }
        System.out.print("y: ");
        try{
            y=scanner.nextDouble();
        }catch(InputMismatchException e){
            System.err.println(e);
        }
    }
    void show(){
        System.out.println("x: "+x);
        System.out.println("y: "+y);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
