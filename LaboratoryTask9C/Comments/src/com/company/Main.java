package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
some code
some code
some code
*/
public class Main {
    // some code
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            FileReader fr = new FileReader("text\\code.txt");
            scanner = new Scanner(fr);
            StringBuilder sb = new StringBuilder("");// some code
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append('\n');
            }
            /*
            some code
            some code
            some code
            */
            try {
                while (sb.indexOf("/*") != -1) {
                    sb.delete(sb.indexOf("/*"), sb.indexOf("*/")+2);
                }// some code
                while (sb.indexOf("//") != -1)
                    sb.delete(sb.indexOf("//"), sb.indexOf("//") + sb.substring(sb.indexOf("//")).indexOf("\n"));// some code
                try (FileWriter fw = new FileWriter("text\\no comments.txt")) {
                    fw.write(sb.toString());
                }catch (IOException e){
                    System.err.print(e);
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println(e);
            }
        } catch (IOException e) {// some code

        } finally {
            if (scanner != null)
                scanner.close();
        }
        // some code
    }// some code
}