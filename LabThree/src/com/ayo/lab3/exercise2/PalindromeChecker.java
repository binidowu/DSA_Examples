package com.ayo.lab3.exercise2;

public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        // Remove whitespace and set to lowercase for uniformity
        s = s.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeHelper(String s, int left, int right) {
        // Base case: If there is only one character or no character
        if (left >= right) {
            return true;
        }
        // Check if the characters at left and right are equal
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        // Move towards the middle of the string
        return isPalindromeHelper(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        // Example test cases
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Is 'gohangasalamiimalasagnahog' a palindrome? " + isPalindrome("gohangasalamiimalasagnahog"));

        // Ask user for input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String userInput = scanner.nextLine();
        System.out.println("Is '" + userInput + "' a palindrome? " + isPalindrome(userInput));
        scanner.close();
    }
}

