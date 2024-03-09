package com.ayo.lab3.exercise1;

public class RecursiveMultiplication {

    /** Returns the product of two positive integers m and n using only addition. */
    public static int recursiveProduct(int m, int n) {
        // Base case: if n is 0, the product is 0
        if (n == 0) {
            return 0;
        } else if (n == 1) { // If n is 1, the product is m
            return m;
        } else if (n > 1) { // Recursive case: add m to the product of m and n-1
            return m + recursiveProduct(m, n - 1);
        } else { // If n is negative, convert it to positive
            return -recursiveProduct(m, -n);
        }
    }

    public static void main(String[] args) {
        int m = 5;
        int n = -3;
        System.out.println("The product of " + m + " and " + n + " is: " + recursiveProduct(m, n));
    }
}
