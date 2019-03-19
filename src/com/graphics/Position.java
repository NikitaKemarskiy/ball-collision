package com.graphics;

public class Position {
    // Private
    private int x;
    private int y;
    private double xBuff = 0.0;
    private double yBuff = 0.0;

    // Public
    public Position() {
        x = 0;
        y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
        this.xBuff = x - (int) x;
        this.yBuff = y - (int) y;
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

    // Methods for changing buffered fractional values
    public void addXBuff(double xBuff) {
        this.xBuff += xBuff;
        if (this.xBuff >= 1 || this.xBuff <= -1) { // xBuff is greater than 1
            this.x += (int) this.xBuff; // Add a whole part to the X coordinate
            this.xBuff -= (int) this.xBuff; // Leave only a fractional part in the xBuff variable
        }
    }

    public void addYBuff(double yBuff) {
        this.yBuff += yBuff;
        if (this.yBuff >= 1 || this.yBuff <= -1) { // yBuff is greater than 1
            this.y += (int) this.yBuff; // Add a whole part to the Y coordinate
            this.yBuff -= (int) this.yBuff; // Leave only a fractional part in the yBuff variable
        }
    }
}
