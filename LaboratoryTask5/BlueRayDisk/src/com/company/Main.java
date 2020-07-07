package com.company;

public class Main {

    public static void main(String[] args) {
        BlueRayDisk blueRayDisk=new BlueRayDisk(){
            void show(){
                nestedCatalog.show();
                System.out.println("Name: "+name);
            }
        };
        blueRayDisk.show();
    }
}
