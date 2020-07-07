package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bookcase extends Case {
    Scanner scanner = new Scanner(System.in);
    int numberOfBooks;

    Bookcase() {
        set("Bookcase");
        System.out.print("Number of books: ");
        try {
            numberOfBooks = scanner.nextInt();
            if (numberOfBooks <= 0) throw new IllegalArgumentException();
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    public void show() {
        System.out.println("Type: " + getType()
                + "\nName: " + getName()
                + "\nMaterial: " + getMaterial()
                + "\nNumber of books: " + numberOfBooks);
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks() {
        System.out.print("Number of books: ");
        try {
            numberOfBooks = scanner.nextInt();
            if (numberOfBooks <= 0) throw new IllegalArgumentException();
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
    }

    public void set() {
        super.set("Bookcase");
        setNumberOfBooks();
    }
}
