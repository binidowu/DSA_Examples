package com.ayo.labtest2.exercise3;

import java.util.LinkedList;
import java.util.Queue;
public class QuickSort {
    public static void main(String[] args){
        Queue<Account> accountQueue = new LinkedList<>();
        accountQueue.add(new Account(1000, "Tunde", 2500.00));
        accountQueue.add(new Account(1002, "Femi", 3400.00));
        accountQueue.add(new Account(1004, "Folake", 4100.00));
        accountQueue.add(new Account(1006, "Evans", 1400.00));
        accountQueue.add(new Account(1008, "Ayomide", 10000.00));

        System.out.println("Before Sorting");
        for (Account account : accountQueue){
            System.out.println(acc);
        }

        // Sorting using Quicksort
        Quicksort.quicksort(accountQueue, new AccountBalanceComparator());

        System.out.println("\nAfter Sorting");
        for (Account account : accountQueue){
            System.out.println(acc);
        }
    }
}
