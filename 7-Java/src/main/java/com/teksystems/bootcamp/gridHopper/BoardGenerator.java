package com.teksystems.bootcamp.gridHopper;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BoardGenerator {

    public static LocationPointer[][] createBoard(int size, Random seed) {
        LocationPointer[][] grid = new LocationPointer[size][size];
        LocationPointer[][] heartPointer = new LocationPointer[size][size];
        LocationPointer[][] clubPointer = new LocationPointer[size][size];
        LocationPointer[][] diamondPointer = new LocationPointer[size][size];
        LocationPointer[][] spadePointer = new LocationPointer[size][size];
        int pointerXHeart = seed.nextInt(size);
        int pointerXClub = seed.nextInt(size);
        int pointerXDiamond = seed.nextInt(size);
        int pointerXSpade = seed.nextInt(size);
        int pointerXHopper = 0;
        int pointerYHeart = seed.nextInt(size);
        int pointerYClub = seed.nextInt(size);
        int pointerYDiamond = seed.nextInt(size);
        int pointerYSpade = seed.nextInt(size);
        int pointerYHopper = 0;
        System.out.println("LOCATION POINTERS");
//        System.out.println("(randomly generated coords)");
        System.out.println("-------------------------");
        System.out.println("Heart ♥ pointer: (" + pointerXHeart + ", " + pointerYHeart + ")");
        System.out.println("Club ♣ pointer: (" + pointerXClub + ", " + pointerYClub + ")");
        System.out.println("Diamond ♦ pointer: (" + pointerXDiamond + ", " + pointerYDiamond + ")");
        System.out.println("Spade ♠ pointer: (" + pointerXSpade + ", " + pointerYSpade + ")");
        System.out.println("-------------------------");
        System.out.println("Hopper ☉ Home: (" + pointerXHopper + ", " + pointerYHopper + ")");
        System.out.println();
        for(int y = 0; y < grid.length; y++) {
            if((y == pointerYHeart) && (pointerXHeart == 0)) {
                System.out.print("♥");
            } else if((y == pointerYClub) && (pointerXClub == 0)) {
                System.out.print("♣");
            } else if((y == pointerYDiamond) && (pointerXDiamond == 0)) {
                System.out.print("♦");
            } else if((y == pointerYSpade) && (pointerXSpade == 0)) {
                System.out.print("♠");
            } else if((y == pointerYHopper) && (pointerXHopper == 0)) {
                System.out.print("☉");
            } else {
                System.out.print(".");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int x = 0; x < grid.length - 1; x++) {
                if((y == pointerYHeart) && (x == (pointerXHeart - 1))) {
                    System.out.print("   ♥");
                } else if((y == pointerYClub) && (x == (pointerXClub - 1))) {
                    System.out.print("   ♣");
                } else if((y == pointerYDiamond) && (x == (pointerXDiamond - 1))) {
                    System.out.print("   ♦");
                } else if((y == pointerYSpade) && (x == (pointerXSpade - 1))) {
                    System.out.print("   ♠");
                } else if((y == pointerYHopper) && (x == (pointerXHopper - 1))) {
                    System.out.print("   ☉");
                } else {
                    System.out.print("   .");
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
        return grid;
    }
}
