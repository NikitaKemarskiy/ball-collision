package com.graphics;

public class Ball {
    // Private
    private Position position;
    private Direction direction;
    private int size;
    private int diameter;
    private int speed;
    private double density = 1;
    private double mass;

    // Public
    Ball(Position position, Direction direction, int size) {
        this.position = position;
        this.direction = direction;
        this.size = size;
        this.diameter = GraphicsComponent.defaultSize * this.size;
        this.speed = 0;
        this.mass = this.density * (4 / 3) * Math.pow(this.diameter / 2, 3);
    }

    Ball(Ball ball) {
        this.position = new Position(ball.getPosition().getX(), ball.getPosition().getY());
        this.direction = new Direction(ball.getDirecton().getX(), ball.getDirecton().getY());
        this.size = ball.getSize();
        this.diameter = ball.getDiameter();
        this.speed = ball.getSpeed();
        this.mass = ball.getMass();
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

    public int getSpeed() { return speed; }

    public double getMass() {
        return mass;
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

    public void setDirection(double x, double y) {
        direction.setX(x);
        direction.setY(y);
    }

    public void setSize(int size) {
        this.size = size;
        setDiameter(GraphicsComponent.defaultSize * this.size);
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        this.mass = this.density * (4 / 3) * Math.pow(this.diameter / 2, 3);
    }

    public void setSpeed(int speed) { this.speed = speed; }

    // Methods
    public void reverseXDirection() {
        direction.setX((-1) * direction.getX());
    }

    public void reverseYDirection() {
        direction.setY((-1) * direction.getY());
    }

    // Static methods
    public static boolean movingOpposite(Ball ball1, Ball ball2) {
        Direction speedDiff = new Direction(ball2.getDirecton().getX() * ball2.getSpeed() - ball1.getDirecton().getX() * ball1.getSpeed(), ball2.getDirecton().getY() * ball2.getSpeed() - ball1.getDirecton().getY() * ball1.getSpeed());
        Direction positionDiff = new Direction(ball2.getPosition().getX() - ball1.getPosition().getX(), ball2.getPosition().getY() - ball1.getPosition().getY());

        double dotProduct = Direction.dotProduct(speedDiff, positionDiff);

        return dotProduct > 0 ? true : false;
    }
}
