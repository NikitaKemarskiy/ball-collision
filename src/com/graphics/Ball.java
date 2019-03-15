package com.graphics;

import java.awt.*;

public class Ball {
    // Private
    private Position position;
    private Direction direction;
    private int size;
    private int diameter;
    private int speed;

    // Public
    Ball(Position position, Direction direction, int size) {
        this.position = position;
        this.direction = direction;
        this.size = size;
        this.diameter = GraphicsComponent.defaultSize * this.size;
        this.speed = 0;
    }

    // Getters
    public Position getPosition() {
        return position;
    }

    public Direction getDirecton() {
        return direction;
    }

    public int getSize() {
        return size;
    }

    public int getDiameter() {
        return diameter;
    }

    // Setters
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public void setDirecton(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(int x, int y) {
        direction.setX(x);
        direction.setY(y);
    }

    public void setSize(int size) {
        this.size = size;
        this.diameter = GraphicsComponent.defaultSize * this.size;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setSpeed(int speed) { this.speed = speed; }
}
