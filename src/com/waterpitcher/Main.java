package com.waterpitcher;



public class Main {

    public static void main(String[] args) {

        try {
            // Specify the file path
            String filePath = "//home/princenoahjohnson/Desktop/GW/Artificial Intelligence_CSCI_6511_DE1/Projects/Project 1/src/com/waterpitcher/input.txt";

            // Read input from the file using the Reader Class
            var inputContent = Reader.getInput(filePath);

            // Print the input content
            //System.out.println(inputContent);

            // Create a Solution instance with the input
            AStarAlgorithm solution = new AStarAlgorithm(inputContent);

            // Print the minimum steps using the A* algorithm
            System.out.println(solution.findMinStepsUsingAStar());
        } catch (Exception ex) {
            // Handle exceptions
            System.out.println("An exception occurred: " + ex.getMessage());
        }
    }
}