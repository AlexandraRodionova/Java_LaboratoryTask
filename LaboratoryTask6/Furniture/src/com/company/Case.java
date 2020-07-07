package com.company;

import java.util.Scanner;

public abstract class Case implements Furniture {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String type;
    private String material;

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public void set() {
        System.out.print("Type: ");
        type = scanner.next();
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Material: ");
        material = scanner.next();
    }

    public void set(String type) {
        this.type = type;
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Material: ");
        material = scanner.next();
    }

    abstract public void show();
}
