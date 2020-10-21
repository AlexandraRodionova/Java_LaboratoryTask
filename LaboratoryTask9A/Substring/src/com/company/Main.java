package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = null;
        String substring = "Substring ";
        try {
            FileReader fr = new FileReader("text\\text.txt");
            scanner = new Scanner(fr);
            try (FileWriter fw = new FileWriter("text\\new Text.txt")) {
                while (scanner.hasNextLine()) {
                    StringBuilder sb = new StringBuilder(scanner.nextLine());
                    while (sb.indexOf(substring) != -1)
                        sb.delete(sb.indexOf(substring), sb.indexOf(substring) + substring.length());
                    fw.write(sb.toString());
                    fw.append("\n");
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
