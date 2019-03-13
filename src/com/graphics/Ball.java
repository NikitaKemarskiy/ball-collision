package com.graphics;

import java.awt.*;

public class Ball {
    // Private
    private Direction directon;
    private Position position;
    private int size;
    private int diameter;

    // Public
    Ball(Position position, Direction direction, int size) {
        this.position = position;
        this.directon = direction;
        this.size = size;
        this.diameter = GraphicsComponent.defaultSize * this.size;
    }

    // Getters
    public Direction getDirecton() {
        return directon;
    }

    public int getSize() {
        return size;
    }

    public int getDiameter() {
        return diameter;
    }

    // Setters
    public void setDirecton(int x, int y) {
        this.directon.setX(x);
        this.directon.setY(x);
    }

    public void setSize(int size) {
        this.size = size;
        this.diameter = GraphicsComponent.defaultSize * this.size;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
