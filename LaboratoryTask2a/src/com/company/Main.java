package com.company;
import java.util.Date;
import java.util.Scanner;

/**
 * Класс создан для нахождения чисел минимальной и максимальной длины
 *
 * @author alex
 */
public class Main {

    private static int[] arr;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Date date = new Date();

        System.out.print("Enter count number: ");
        int number = scanner.nextInt();

        int[] array = new int[number];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int max = maxLength(array);
        int min = minLength(array);

        System.out.print("Max length number:  ");

        for (int i = 0; i < array.length; i++) {

            if (countOfDigitsInNumber(array[i]) == max) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }

        System.out.print('\n' + "Min length number:  ");

        for (int i = 0; i < array.length; i++) {

            if (countOfDigitsInNumber(array[i]) == min) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
        }

        System.out.print('\n'+"Rodionova Alexandra" + date.toString());
    }

    /**
     * Метод для нахождения максимальной длины
     * @param arr
     * @return maxLengthNumber
     */

    private static int maxLength(int[] arr){

        int maxLengthNumber = 1;

        for(int i = 0; i < arr.length; i++) {
            if (maxLengthNumber < countOfDigitsInNumber(arr[i])) {
                maxLengthNumber = countOfDigitsInNumber(arr[i]);
            }
        }
        return maxLengthNumber;
    }

    /**
     * Метод для нахождения количества цифр в числе
     * @param number
     * @return count
     */

    private static int countOfDigitsInNumber(int number){

        int count = 0;

        while (number != 0)
        {
            count++;
            number /= 10;
        }

        return count;
    }

    /**
     * Метод для нахождения минимальной длины
     * @param arr
     * @return minLengthNumber
     */

    private static int minLength(int [] arr) {
        int minLengthNumber = 1;

        for (int i = 0; i < arr.length; i++) {
            if (minLengthNumber > countOfDigitsInNumber(arr[i])) {
                minLengthNumber = countOfDigitsInNumber(arr[i]);
            }
        }
        return minLengthNumber;
    }
}
