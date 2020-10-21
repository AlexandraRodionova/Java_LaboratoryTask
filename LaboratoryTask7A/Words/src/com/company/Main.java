package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=null;
        HashSet<String> words=new HashSet<>();
        try{
            FileReader fr=new FileReader("Text\\Text.txt");
            scanner=new Scanner(fr);
            while(scanner.hasNext()){
                StringBuilder sb = new StringBuilder(scanner.next());
                if(sb.indexOf(".")!=-1)
                    sb.deleteCharAt(sb.indexOf("."));
                if(sb.indexOf(",")!=-1)
                    sb.deleteCharAt(sb.indexOf(","));
                if(sb.indexOf(":")!=-1)
                    sb.deleteCharAt(sb.indexOf(":"));
                if(sb.indexOf(";")!=-1)
                    sb.deleteCharAt(sb.indexOf(";"));
                words.add(sb.toString());
            }
            int[] numberOfWord=new int[words.size()];
            for(int i=0;i<words.size();i++){
                numberOfWord[i]=0;
            }
            int i=0;
            for(String word:words){
                fr=new FileReader("Text\\Text.txt");
                scanner=new Scanner(fr);
                while(scanner.hasNext()){
                    if(scanner.next().contains(word)){
                        numberOfWord[i]++;
                    }
                }
                i++;
            }
            i=0;
            for(String word:words){
                System.out.println(word+" - "+numberOfWord[i]);
                i++;
            }
        }catch (FileNotFoundException e){
            System.err.println(e);
        }finally {
            if(scanner!=null)scanner.close();
        }
    }
}
