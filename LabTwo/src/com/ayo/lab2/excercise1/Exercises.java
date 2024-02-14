package com.ayo.lab2.excercise1;

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


/**
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercises {

    /** Returns the sum of the integers in given array. */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            total += arr[j];
        return total;
    }
    // Analysis:
    // The function example1 has a single loop that iterates 'n' times, where 'n' is the length of the input array 'arr'.
    // Inside the loop, a constant time operation (addition) is performed.
    // Therefore, the total time complexity of this function is O(n), where 'n' is the size of the input array.
    // This indicates that the running time of the function scales linearly with the size of the input.

    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    // note the increment of 2
            total += arr[j];
        return total;
    }
    // Analysis:
    // The for loop here iterates over every other element of the array,
    // effectively running about n / 2 times where n is the array's length.
    // Although the loop runs fewer times than a typical loop over all elements,
    // the big-Oh characterization remains O(n) because we consider upper bounds
    // and ignore constant factors. The time complexity is linear with respect to
    // the size of the input array, but with a lower constant factor compared to
    // a loop that iterates over each element.

    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];
        return total;
    }
    // Analysis:
    // The outer loop executes n times. For each iteration of the outer loop,
    // the inner loop executes j+1 times, where j ranges from 0 to n-1.
    // This results in a total of 1 + 2 + ... + n executions of the inner loop,
    // which is equivalent to n(n+1)/2.
    // Therefore, the time complexity is O(n^2), indicating a quadratic relationship
    // between the size of the input array and the execution time.


    /** Returns the sum of the prefix sums of given array. */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }
    // Analysis:
    // The method performs a single loop over the array, executing two operations per iteration.
    // The first operation, `prefix += arr[j]`, is a simple accumulation of the array's elements up to the current index.
    // The second operation, `total += prefix`, adds the current prefix sum to the total sum.
    // Since both operations inside the loop are constant time and the loop runs `n` times,
    // the overall time complexity is O(n), indicating a linear relationship between the size of the input array and the execution time.


    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) {     // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1
                for (int k=0; k <= j; k++)  // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }
    // Analysis:
    // The method consists of a triple-nested loop where the outer and middle loops run 'n' times each,
    // and the innermost loop runs up to 'n' times for each iteration of the middle loop.
    // This results in a total of n * n * n = n^3 iterations, leading to a cubic time complexity of O(n^3).
    // The execution time increases cubically with the size of the input array, making this method significantly
    // less efficient for large input sizes compared to the previous examples.

}

