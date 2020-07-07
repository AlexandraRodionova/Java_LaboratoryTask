package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int numberOfLots = 0;
        Lot[] lots = null;
        try {
            FileReader fr = new FileReader("Lots list\\Lot.txt");
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                numberOfLots++;
                scanner.nextLine();
            }
            fr = new FileReader("Lots list\\Lot.txt");
            scanner = new Scanner(fr);
            lots = new Lot[numberOfLots];
            for (int i = 0; i < numberOfLots; i++) {
                lots[i] = new Lot(scanner.next(), Integer.parseInt(scanner.next()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }


        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        Participant.lots = Arrays.asList(lots);
        Semaphore semaphore = new Semaphore(1, true);
        Participant[] participants = null;
        int numberOfParticipants = 0;
        try {
            FileReader fr = new FileReader("Participants list\\Participant.txt");
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                numberOfParticipants++;
                scanner.nextLine();
            }
            fr = new FileReader("Participants list\\Participant.txt");
            scanner = new Scanner(fr);
            participants = new Participant[numberOfParticipants];
            for (int i = 0; i < numberOfParticipants; i++) {
                participants[i] = new Participant(semaphore, cyclicBarrier, scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        for (int i = 0; i < numberOfParticipants; i++) {
            participants[i].start();
        }
        for (int i = 0; i < numberOfParticipants; i++) {
            if (participants[i].isAlive()) {
                participants[i].join();
            }
        }
        for (int i = 0; i < numberOfLots; i++) {
            System.out.println("\nName of Lot: " + lots[i].nameOfLot + "\nStart cost:  " + lots[i].startCost + "\nFinal Cost: " + lots[i].finalCost + "\nOwner: " + lots[i].owner.name);
        }
    }
}
