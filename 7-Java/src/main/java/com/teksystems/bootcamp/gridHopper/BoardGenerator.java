package com.teksystems.bootcamp.gridHopper;

import java.util.Random;

public class BoardGenerator {

    public static LocationPointer[][] createBoard(int size, int seed) {
        LocationPointer[][] grid = new LocationPointer[size][size];
        LocationPointer[][] targetMap = new LocationPointer[size][size];
        Random random = new Random();
        random.setSeed(seed);

        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
//                LocationPointer currentLocation = new LocationPointer(row, col);
                LocationPointer targetLocation = new LocationPointer(random.nextInt(size), random.nextInt(size));
//                System.out.print("(" + targetLocation.getTargetX() + ", " + targetLocation.getTargetY() + ") ");
                targetMap[row][col] = new LocationPointer(targetLocation.getTargetX(), random.nextInt(size));
                System.out.print("(" + targetLocation.getTargetX() + ", " + targetLocation.getTargetY() + ") ");
            }
            System.out.println();
        }
        System.out.println();
//        return grid;
        return targetMap;
    }
}
