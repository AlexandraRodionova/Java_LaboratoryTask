package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter count number: ");
        int number = scanner.nextInt();
        int[] array = new int[number];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {

            if(multiplicityOf9Or3(array[i])){
                System.out.print(array[i] );
                System.out.print(' ');
            }
        }

    }

    private  static boolean multiplicityOf9Or3(int number){

        if( number % 9 == 0 || number%3 == 0){
            return true;
        }
        return false;
    }
}
