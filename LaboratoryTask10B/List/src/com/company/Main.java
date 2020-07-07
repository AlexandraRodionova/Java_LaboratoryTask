package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numberOfList=1;
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        try{
            FileReader fr=new FileReader("Numbers\\Numbers.txt");
            Scanner scanner=new Scanner(fr);
            while (scanner.hasNext()){
                int n=Integer.parseInt(scanner.next());
                if(n<0){
                    numberOfList++;
                }
                else if(numberOfList==1){
                    list1.add(n);
                }
                else if(numberOfList==2){
                    list2.add(n);
                }
            }
            list1.sort(Comparator.naturalOrder());
            for(int l1:list1){
                System.out.print(l1+"\t");
            }
            System.out.println();
            for(int l2:list2){
                System.out.print(l2+"\t");
            }
            for(int l2:list2){
                for(int i=0;i<list1.size();i++){
                    if(l2<=list1.get(i)) {
                        list1.add(i, l2);
                        break;
                    }
                }
            }
            System.out.println();
            for(int l1:list1){
                System.out.print(l1+"\t");
            }
        }catch (FileNotFoundException e){
            System.err.println(e);
        }
    }
}
