package com.company;

import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Count elements array: ");
        int count= scan.nextInt();
        Product[] array = new Product[count];

        initArrayProduct(array);
        displayArrayProduct(array);

        System.out.print("Enter name product: ");
        String namesource = scan.next();
        displayArrayProductByName(array, namesource);

        System.out.print("Enter name product: ");
        namesource = scan.next();
        System.out.print("Enter price product: ");
        double pricesource = scan.nextDouble();
        displayArrayProductByNameAndByPrice(array,namesource,pricesource);

        System.out.print("Enter name product: ");
        namesource = scan.next();
        System.out.print("Enter Shelf Life product: ");
        double shelfLifesource = scan.nextDouble();
        displayArrayProductByNameAndByShelfLife(array,namesource,shelfLifesource);
    }

    public static void  initArrayProduct(Product[] array) {

         Scanner scan = new Scanner(System.in);

         for(int i = 0; i < array.length; i++){

             System.out.println("ID product: ");
             int id = scan.nextInt();
             System.out.println("Name product: ");
             String name = scan.next();
             System.out.println("Manufacturer product: ");
             String manufacturer = scan.next();
             System.out.println("UPS product: " );
             int UPS = scan.nextInt();
             System.out.println("Price product: ");
             double price = scan.nextDouble();
             System.out.println("Count product: ");
             int countNew = scan.nextInt();
             System.out.println("Shelf Life product: ");
             double shelfLife = scan.nextDouble();

             array[i] = new Product(id, name, UPS,manufacturer, price, countNew, shelfLife);
             System.out.println("\f");
         }
    }

    public static void  displayArrayProduct(Product[] array) {
        for(int i = 0; i < array.length; i++){
            array[i].displayProduct();
            System.out.println(' ');
        }
    }

    public static void  displayArrayProductByName(Product[] array, String name) {
        for(int i = 0; i < array.length; i++){
            array[i].displayByName(name);
            System.out.println(' ');
        }
    }

    public static void  displayArrayProductByNameAndByPrice(Product[] array, String name, double price) {
        for(int i = 0; i < array.length; i++){
            array[i].displayByNameAndByPrice(name,price);
            System.out.println(' ');
        }
    }
    public static void  displayArrayProductByNameAndByShelfLife(Product[] array, String nameNew, double shelfLifeNew) {
        for(int i = 0; i < array.length; i++){

            array[i].displayByNameAndByShelfLife(nameNew,shelfLifeNew);
            System.out.println(' ');
        }
    }

}


