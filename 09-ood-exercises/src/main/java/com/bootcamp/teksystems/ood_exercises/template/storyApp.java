package com.bootcamp.teksystems.ood_exercises.template;

import java.util.Scanner;

public class storyApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        Scanner input = new Scanner(System.in);
        Story originalStory = new OriginalStory();
        System.out.println("\n--------------------------------------");
        System.out.println("\nHere is the ORIGINAL STORY ~");
        originalStory.tellStory();
        System.out.println("\n--------------------------------------");

        boolean isValidSeed = true;
        do {
            try {
                System.out.println("\n\nEnter your favorite number to generate a random story: ");
                int seed = input.nextInt();
                Story randomStory = new RandomStory(seed);
                System.out.println("\n--------------------------------------");
                System.out.println("\n~ RANDOM STORY ~");
                randomStory.tellStory();
                System.out.println("\n--------------------------------------");
            } catch (Exception e) {
                System.out.println("Invalid entry. Only enter an integer.");
                isValidSeed = false;
            }
        } while (!isValidSeed);
        System.out.println("\nGoodbye! Thank you for joining story time!!");
    }
}
