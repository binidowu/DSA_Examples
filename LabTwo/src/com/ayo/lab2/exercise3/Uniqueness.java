package com.ayo.lab2.exercise3;

import java.util.Arrays;
import java.util.Random;

public class Uniqueness {

    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false; // found duplicate pair
        return true; // if we reach this, elements are unique
    }

    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n); // make copy of data
        Arrays.sort(temp); // and sort the copy
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1]) // check neighboring entries
                return false; // found duplicate pair
        return true; // if we reach this, elements are unique
    }

    // Utility method to generate an array of random integers
    private static int[] generateRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        int maxNForUnique1 = 0;
        int maxNForUnique2 = 0;
        int maxIterations = 10000;
        long timeoutMillis = 60000; // One minute timeout

        // Testing unique1
        for (int n = 10; ; n++) {
            int[] data = generateRandomArray(n);
            long startTime = System.currentTimeMillis();
            unique1(data);
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) < timeoutMillis) {
                maxNForUnique1 = n;
            } else {
                break;
            }
        }

        // Testing unique2
        for (int n = 10;  ; n++) {
            int[] data = generateRandomArray(n);
            long startTime = System.currentTimeMillis();
            unique2(data);
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) < timeoutMillis) {
                maxNForUnique2 = n;
            } else {
                break;
            }
        }

        System.out.println("Max n for unique1: " + maxNForUnique1);
        System.out.println("Max n for unique2: " + maxNForUnique2);
    }
}
