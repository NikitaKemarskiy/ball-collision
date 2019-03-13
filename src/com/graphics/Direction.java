package com.graphics;

public class Direction {
    // Private
    private int x;
    private int y;

    // Public
    public Direction() {
        x = 0;
        y = 0;
    }

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
