package com.teksystems.bootcamp.gridHopper;

public class LocationPointer {
    private int targetX;
    private int targetY;

    public LocationPointer(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }
}
