package com.graphics;

public class Direction {
    // Private
    private double x;
    private double y;

    // Public
    public Direction() {
        x = 0;
        y = 0;
    }

    public Direction(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Static methods
    public static double dotProduct(Direction direction1, Direction direction2) {
        return direction1.getX() * direction2.getX() + direction1.getY() * direction2.getY();
    }
}
