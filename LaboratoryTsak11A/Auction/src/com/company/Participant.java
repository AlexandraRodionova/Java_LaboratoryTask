package com.company;

import java.util.List;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Participant extends Thread {
    public boolean stop;
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;
    public static List<Lot> lots;
    String name;

    Participant(Semaphore semaphore, CyclicBarrier cyclicBarrier, String name) {
        this.semaphore = semaphore;
        this.name = name;
        stop = false;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        for (Lot lot : lots) {
            while (!stop) {
                lot.isEnded = false;
                lot = startAuction(lot);
            }
            stop = false;
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            if (lot.owner == this) {
                try {
                    semaphore.acquire();
                    if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println("\n" + name + " оплатил(а) лот " + lot.nameOfLot);
                    } else {
                        stop = true;
                        System.out.println("\n" + name + " не успел(а) оплатить лот " + lot.nameOfLot);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    semaphore.acquire();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Lot startAuction(Lot lot) {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\n" + name + "\n" + lot.nameOfLot + " " + lot.startCost + " " + lot.finalCost + "\n1)Add\n2)Do not Add\n3)Stop\n");
        k = scanner.nextInt();
        switch (k) {
            case 1:
                lot.finalCost += 100;
                lot.owner = this;
                break;
            case 2:
                break;
            case 3:
                stop = true;
                lot.isEnded = true;
                break;
        }
        semaphore.release();
        return lot;
    }
}
