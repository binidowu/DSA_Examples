package com.ayo.lab2.excercise3;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

    /** Returns true if sthere are no duplicate elements in the array. */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j=0; j < n-1; j++)
            for (int k=j+1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    // Utility method to generate an array of random integers
    private static int[] generateRandomArray(int n, int[] array) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }


    public static void main(String[] args) {
        int low = 10; // Start with a low number of elements
        int high = Integer.MAX_VALUE;
        int maxNForUnique1 = 0;
        int maxNForUnique2 = 0;

        // Testing unique1
        while (low <= high) {
            int n = low + (high - low) / 2;
            int[] data = new int[n];
            generateRandomArray(n, data);
            long startTime = System.currentTimeMillis();
            unique1(data);
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) < 60000) { // Less than one minute
                maxNForUnique1 = n;
                low = n + 1;
            } else {
                high = n - 1;
            }
        }

        // Reset the values for unique2 testing
        low = 10; // Reset low
        high = Integer.MAX_VALUE; // Reset high

        // Testing unique2
        while (low <= high) {
            int n = low + (high - low) / 2;
            int[] data = new int[n];
            generateRandomArray(n, data);
            long startTime = System.currentTimeMillis();
            unique2(data);
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) < 60000) { // Less than one minute
                maxNForUnique2 = n;
                low = n + 1;
            } else {
                high = n - 1;
            }
        }

        System.out.println("Max n for unique1: " + maxNForUnique1);
        System.out.println("Max n for unique2: " + maxNForUnique2);
    }

}

