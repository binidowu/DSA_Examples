package com.ayo.lab3.exercise3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

    public static void find(File root, String filename, List<File> foundFiles) {
        if (root == null || filename == null || foundFiles == null) return;

        // Check if root is a directory
        if (root.isDirectory()) {
            // Get all files and directories in the current directory
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Recursively search in subdirectories
                    find(file, filename, foundFiles);
                }
            }
        } else {
            // If it's a file, check the filename
            if (root.getName().equals(filename)) {
                foundFiles.add(root);
            }
        }
    }

    public static void main(String[] args) {
        List<File> foundFiles = new ArrayList<>();

        File startPath = new File("/Users/binidowu/Data-Structures-And-Algorithms/Lab-Three/Excerise-3");
        String searchFilename = "Solution.txt";

        find(startPath, searchFilename, foundFiles);

        if (foundFiles.isEmpty()) {
            System.out.println("No files found with the name: " + searchFilename);
        } else {
            for (File file : foundFiles) {
                System.out.println("Found file: " + file.getAbsolutePath());
            }
        }
    }
}
