package com.company;

public class Company {
    int id;
    String name;
    String country;
    Company(int id,String name,String country){
        this.id=id;
        this.country=country;
        this.name=name;
    }

    void show(){
        System.out.println("id: "+id+",\tname: "+name+",\tcountry: "+country);
    }
}
