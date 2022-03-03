package com.teksystems.bootcamp.gridHopper;

import java.util.concurrent.TimeUnit;

public class BoardGenerator {

    public static LocationPointer[][] createBoard(int size, int seed) {
        LocationPointer[][] grid = new LocationPointer[size][size];
//        LocationPointer[][] pointer = new LocationPointer[seed][seed];
        System.out.println();
        for(int y = 0; y < grid.length; y++) {
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int x = 0; x < grid.length - 1; x++) {
                System.out.print("   .");
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        System.out.println();
//        LocationPointer[][] pointer = grid;
        return grid;
    }
}
