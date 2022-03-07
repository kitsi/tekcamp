package com.teksystems.bootcamp.gridHopper;

import java.util.Random;

public class BoardGenerator {

    public static LocationPointer[][] createBoard(int size, int seed) {
        LocationPointer[][] grid = new LocationPointer[size][size];
        Random random = new Random();
        random.setSeed(seed);
        System.out.println("from BoardGenerator.createBoard");
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                grid[row][col] = new LocationPointer(random.nextInt(size), random.nextInt(size));
//                System.out.print("(" + targetLocation.getTargetX() + ", " + targetLocation.getTargetY() + ") ");
            }
//            System.out.println();
        }
        return grid;
    }
}
