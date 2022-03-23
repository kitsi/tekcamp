package com.teksystems.bootcamp.gridHopper;

public class BoardHopper {

    public static LocationPointer hop(LocationPointer[][] board) {
        LocationPointer currentPos = board[0][0];
        for(int i = 0; i < 100; i++) {
            LocationPointer nextPos = board[currentPos.getTargetX()][currentPos.getTargetY()];
            if((currentPos.getTargetX() == nextPos.getTargetX()) && (currentPos.getTargetY() == nextPos.getTargetY())) {
                break;
            } else {
                currentPos = nextPos;
            }
        }
        return currentPos;
    }
}
