package com.company;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;

public class Circle {
    Scanner scanner=new Scanner(System.in);
    Round round;
    double square;
    Circle(){
        round=new Round();
        square=3.14*round.radius*round.radius;
    }
    void show(){
        round.show();
        System.out.println("Square: "+square);
    }
    void changeRadius(){
        round.changeRadius();
        square=3.14*round.radius*round.radius;
    }
    boolean findPoint(Point point){
        return Math.sqrt((round.center.x - point.x) * (round.center.x - point.x) + (round.center.y - point.y) * (round.center.y - point.y)) <= round.radius;
    }
    void newSize(){
        double square;
        System.out.print("New square: ");
        try{
            square=scanner.nextDouble();
            if (square <= 0) {
                throw new IllegalArgumentException();
            }
            this.square=square;
            round.radius=Math.sqrt(square/3.14);
        }catch (InputMismatchException e){
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .add("round=" + round)
                .add("square=" + square)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.square, square) == 0 &&
                Objects.equals(round, circle.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, square);
    }
}
