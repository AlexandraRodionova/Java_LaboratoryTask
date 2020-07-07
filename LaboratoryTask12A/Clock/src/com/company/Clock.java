package com.company;

public class Clock {
    int id;
    String stamp;
    String type;
    int cost;
    int quantity;
    int idCompany;

    Clock(int id, String stamp, String type, int cost, int quantity, int idCompany) {
        this.id = id;
        this.cost = cost;
        this.idCompany = idCompany;
        this.quantity = quantity;
        this.type = type;
        this.stamp = stamp;
    }

    void show() {
        System.out.println("id: "+id+",\tstamp: "+stamp+",\ttype: "+type+",\tcost: "+cost+",\tquantity: "+quantity+",\tid company: "+idCompany);
    }
}
