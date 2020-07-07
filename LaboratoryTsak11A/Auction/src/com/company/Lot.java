package com.company;

public class Lot {
    String nameOfLot;
    Participant owner;
    int startCost;
    int finalCost;
    boolean isEnded;
    Lot(String nameOfLot,int startCost){
        this.startCost=startCost;
        this.finalCost=startCost;
        this.nameOfLot=nameOfLot;
        this.isEnded=false;
    }
}
