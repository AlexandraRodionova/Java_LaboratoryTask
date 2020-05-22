package com.company;

public class Product {

    int id;
    String name;
    int UPS;
    String manufacturer;
    double price;
    int count;
    double shelfLife;

    Product(){

        id = 0;
        name = "Undefined";
        manufacturer = "Undefined";
        UPS = 0;
        price = 0.00;
        count = 0;
        shelfLife = 0;
    }

    public String getName(){
        return name;
    }

    private void setName(String a){
        name = a;
    }

    public int getID(){
        return id;
    }

    private void setID(int a){ id = a; }

    public String getManufacturer(){
        return manufacturer;
    }

    private void setManufacturer(String a){
        manufacturer = a;
    }

    public int getUPS(){
        return UPS;
    }

    private void setUPS(int a){
        UPS = a;
    }

    public double getPrice() {
        return price;
    }

    private  void setPrice(double a) { price = a; }

    public int getCount() { return count; }

    private void setCount(int a) { count = a;}

    public double getShelfLife() { return  shelfLife; }

    private void setShelfLife(double a) { shelfLife = a; }

    Product(int idNew, String nameNew, int UPSNew, String manufacturerNew,double priceNew, int countNew, double shelfLifeNew){
        setID(idNew);
        setName(nameNew);
        setManufacturer(manufacturerNew);
        setUPS(UPSNew);
        setPrice(priceNew);
        setCount(countNew);
        setShelfLife(shelfLifeNew);
    }

    public void displayProduct(){
        System.out.println("ID product: " + id);
        System.out.println("Name product: " + name);
        System.out.println("Manufacturer product: " + manufacturer);
        System.out.println("UPS product: " + UPS);
        System.out.println("Price product: " + price);
        System.out.println("Count product: " + count);
        System.out.println("Shelf Life product: " + shelfLife);
    }

    public String toString(){
        return "ID product: " + getID() + "\tName product: " + getName() + "\tManufacturer product: " + getManufacturer() + "\tUPS product: " + getUPS() +
        "\tPrice product: " + getPrice() + "\tCount product: " + getCount() + "\tShelf Life product: " + getShelfLife();
    }


    public void displayByName(String nameNew ){
        if (name.equals(nameNew))
        {
            displayProduct();
        }
    }

    public void displayByNameAndByPrice(String nameNew, double priceNew ){
        if (this.name.equals(nameNew) && this.price <= priceNew)
        {
            this.displayProduct();
        }
    }

    public void displayByNameAndByShelfLife(String nameNew, double shelfLifeNew){
        if (this.name.equals(nameNew) && this.price >= shelfLifeNew)
        {
            this.displayProduct();
        }
    }

}
