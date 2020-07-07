package com.company;

import java.util.Scanner;

public class BlueRayDisk {
    String name;
    InnerCatalog innerCatalog;
    NestedCatalog nestedCatalog;
    public static class NestedCatalog{
        Scanner scanner=new Scanner(System.in);
        String someInformation;
        String subCatalog;
        String entry;
        NestedCatalog(){
            System.out.print("Some information: ");
            someInformation=scanner.nextLine();
            System.out.print("Sub Catalog: ");
            subCatalog=scanner.nextLine();
            System.out.print("Entry: ");
            entry=scanner.nextLine();
            System.out.println();
        }
        void show(){
            System.out.println("Some information: "+someInformation+"\nSub Catalog: "+subCatalog+"\nEntry: "+entry);
        }
    }
    public class InnerCatalog{
        Scanner scanner=new Scanner(System.in);
        String someInformation;
        String subCatalog;
        String entry;
        InnerCatalog(){
            someInformation=nestedCatalog.someInformation;
            subCatalog=nestedCatalog.subCatalog;
            entry=nestedCatalog.entry;
        }
        void show(){
            System.out.println("Name: "+name+"\nSome information: "+someInformation+"\nSub Catalog: "+subCatalog+"\nEntry: "+entry);
        }
    }

    BlueRayDisk(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Name: ");
        name=scanner.nextLine();
       nestedCatalog=new NestedCatalog();
    }
    void show(){
        innerCatalog.show();
    }
}
