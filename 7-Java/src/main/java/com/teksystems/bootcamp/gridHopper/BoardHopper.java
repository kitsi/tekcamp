package com.teksystems.bootcamp.gridHopper;

import javax.xml.stream.Location;

public class BoardHopper {

    public static LocationPointer hop(LocationPointer[][] board) {

        LocationPointer currentPos = board[0][0];
        System.out.println("current pos: " + currentPos.getTargetX() + ", " + currentPos.getTargetY());


        for(int i = 0; i < 100; i++) {

            LocationPointer nextPos = board[currentPos.getTargetX()][currentPos.getTargetY()];
        System.out.println("next pos upon creation: " + nextPos.getTargetX() + ", " + nextPos.getTargetY());
                    if((currentPos.getTargetX() == nextPos.getTargetX()) && (currentPos.getTargetY() == nextPos.getTargetY())) {
                        System.out.println(i + ": ~~");
                    } else {
                        currentPos = nextPos;
                        System.out.println("current pos after hop: (" + currentPos.getTargetX() + ", " + currentPos.getTargetY() + ")");
                    }
                System.out.println();
        }
        return currentPos;
    }
}
