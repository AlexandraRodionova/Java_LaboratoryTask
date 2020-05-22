package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle circle = new Circle();
        int k = 1;
        while (k != 0) {
            System.out.println("1)Show\n" +
                    "2)New size\n" +
                    "3)Change radius\n" +
                    "4)Find point\n" +
                    "0)Exit");
            try {
                k = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Not a number");
                k = 0;
            }
            switch (k) {
                case 1:
                    circle.show();
                    break;
                case 2:
                    circle.newSize();
                    break;
                case 3:
                    circle.changeRadius();
                    break;
                case 4:
                    Point point=new Point();
                    System.out.println(circle.findPoint(point));
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Error!");
            }
        }
    }
}
