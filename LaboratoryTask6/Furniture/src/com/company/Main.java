package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();
        int n = 0;
        while (true) {
            System.out.println(
                    "1)Show\n" +
                            "2)Get name\n" +
                            "3)Get type\n" +
                            "4)Get material\n" +
                            "5)Set\n" +
                            "0)Exit");
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e);
                n = 0;
            }
            switch (n) {
                case 1:
                    bookcase.show();
                    break;
                case 2:
                    System.out.println(bookcase.getName());
                    break;
                case 3:
                    System.out.println(bookcase.getType());
                    break;
                case 4:
                    System.out.println(bookcase.getMaterial());
                    break;
                case 5:
                    bookcase.set();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Error!");
            }
        }
    }
}