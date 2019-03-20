package com.graphics;

import com.swing.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;

public class GraphicsComponent extends JComponent {
    // Private
    private Ball ball1;
    private Ball ball2;
    private TimerTask intervalTask;
    private Timer interval = new Timer();
    private boolean isStarted = false;

    // Public
    public static int defaultSize = 30;
    public static int intervalTime = 3;

    public GraphicsComponent(int ball1Size, int ball2Size) {
        ball1 = new Ball(new Position(0, 0), new Direction(1, 0), ball1Size);
        ball2 = new Ball(new Position(0, 0), new Direction(-1, 0), ball2Size);
        ball1.setSpeed(2);
        ball2.setSpeed(2);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth(); // Application width
        int height = getHeight(); // Application height

        if (!isStarted) { // GraphicsComponent has just been created
            if (ball1.getDiameter() > height * 0.7 || ball2.getDiameter() > height * 0.7) { // Ball is too big
                double ratio = ball1.getDiameter() > height * 0.7 ? ball1.getDiameter() / (height * 0.7) : 1; // Find ratio
                ratio = ratio > ball2.getDiameter() / (height * 0.7) ? ratio : ball2.getDiameter() / (height * 0.7);
                ball1.setDiameter((int)(ball1.getDiameter() / ratio)); // Set new size
                ball2.setDiameter((int)(ball2.getDiameter() / ratio));
            }
            ball1.setPosition(new Position(0, height - ball1.getDiameter()));
            ball2.setPosition(new Position(width - ball2.getDiameter(), height - ball2.getDiameter()));
        }

        Ellipse2D ball1Shape = new Ellipse2D.Double(ball1.getPosition().getX(), ball1.getPosition().getY(), ball1.getDiameter(), ball1.getDiameter());
        Ellipse2D ball2Shape = new Ellipse2D.Double(ball2.getPosition().getX(), ball2.getPosition().getY(), ball2.getDiameter(), ball2.getDiameter());

        g2.setColor(Colors.main);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(Colors.extra);
        g2.fill(ball1Shape);
        g2.fill(ball2Shape);
    }

    public void setBallSize(int ball1Size, int ball2Size) {
        this.stop();
        ball1.setSize(ball1Size);
        ball2.setSize(ball2Size);
        ball1.setDirection(1, 0);
        ball2.setDirection(-1, 0);
    }

    public void setBallSpeed(int ball1Speed, int ball2Speed) {
        ball1.setSpeed(ball1Speed);
        ball2.setSpeed(ball2Speed);
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void start() { // Method that starts an animation
        if (isStarted) { // Animation is already started
            return;
        }
        System.out.println("=> Animation started"); // Debug log
        isStarted = true;
        intervalTask = new TimerTask() { // Initialize new interval task
            @Override
            public void run() {
                updatePosition();
                repaint();
            }
        };
        interval.schedule(intervalTask, 0, intervalTime); // Set interval
    }

    public void stop() { // Method that stops an animation
        if (!isStarted) { // Animation is already stopped
            return;
        }
        intervalTask.cancel();
        (new Timer()).schedule(new TimerTask() { // Set timeout to make isStarted false
            @Override
            public void run() {
                isStarted = false;
            }
        }, intervalTime);
    }

    public void updatePosition() { // Method that updated balls position
        int width = getWidth(); // Application width
        int height = getHeight(); // Application height

        // Update ball buffered positions
        ball1.getPosition().addXBuff((ball1.getDirecton().getX() * ball1.getSpeed()) - (int) (ball1.getDirecton().getX() * ball1.getSpeed()));
        ball1.getPosition().addYBuff((ball1.getDirecton().getY() * ball1.getSpeed()) - (int) (ball1.getDirecton().getY() * ball1.getSpeed()));
        ball2.getPosition().addXBuff((ball2.getDirecton().getX() * ball2.getSpeed()) - (int) (ball2.getDirecton().getX() * ball2.getSpeed()));
        ball2.getPosition().addYBuff((ball2.getDirecton().getY() * ball2.getSpeed()) - (int) (ball2.getDirecton().getY() * ball2.getSpeed()));

        // Update ball positions
        ball1.getPosition().setX(ball1.getPosition().getX() + (int) (ball1.getDirecton().getX() * ball1.getSpeed()));
        ball1.getPosition().setY(ball1.getPosition().getY() + (int) (ball1.getDirecton().getY() * ball1.getSpeed()));
        ball2.getPosition().setX(ball2.getPosition().getX() + (int) (ball2.getDirecton().getX() * ball2.getSpeed()));
        ball2.getPosition().setY(ball2.getPosition().getY() + (int) (ball2.getDirecton().getY() * ball2.getSpeed()));

        // Check X direction
        if (ball1.getPosition().getX() > (width - ball1.getDiameter())) { // Ball1 X is greater than screen width
            int diff = ball1.getPosition().getX() - (width - ball1.getDiameter()); // Find how much new ball1 X is greater than screen width
            ball1.getPosition().setX((width - ball1.getDiameter()) - diff); // Set new X position
            ball1.reverseXDirection(); // Reverse ball1 X direction
        }
        if (ball1.getPosition().getX() < 0) { // Ball1 X is less than 0
            int diff = 0 - ball1.getPosition().getX(); // Find how much new ball1 X is less than 0
            ball1.getPosition().setX(diff);
            ball1.reverseXDirection(); // Reverse ball1 X direction
        }
        if (ball2.getPosition().getX() > (width - ball2.getDiameter())) { // Ball2 X is greater than screen width
            int diff = ball2.getPosition().getX() - (width - ball2.getDiameter()); // Find how much new ball2 X is greater than screen width
            ball2.getPosition().setX((width - ball2.getDiameter()) - diff);
            ball2.reverseXDirection(); // Reverse ball2 X direction
        }
        if (ball2.getPosition().getX() < 0) { // Ball2 X is less than 0
            int diff = 0 - ball2.getPosition().getX(); // Find how much new ball2 X is less than 0
            ball2.getPosition().setX(diff);
            ball2.reverseXDirection(); // Reverse ball2 X direction
        }
        // Check Y direction
        if (ball1.getPosition().getY() > (height - ball1.getDiameter())) { // Ball1 Y is greater than screen height
            int diff = ball1.getPosition().getY() - (height - ball1.getDiameter()); // Find how much new ball1 Y is greater than screen height
            ball1.getPosition().setY((height - ball1.getDiameter()) - diff);
            ball1.reverseYDirection(); // Reverse ball1 Y direction
        }
        if (ball1.getPosition().getY() < 0) { // Ball1 Y is less than 0
            int diff = 0 - ball1.getPosition().getY(); // Find how much new ball1 Y is less than 0
            ball1.getPosition().setY(diff);
            ball1.reverseYDirection(); // Reverse ball1 Y direction
        }
        if (ball2.getPosition().getY() > (height - ball2.getDiameter())) { // Ball2 Y is greater than screen height
            int diff = ball2.getPosition().getY() - (height - ball2.getDiameter()); // Find how much new ball2 Y is greater than screen height
            ball2.getPosition().setY((height - ball2.getDiameter()) - diff);
            ball2.reverseYDirection(); // Reverse ball2 Y direction
        }
        if (ball2.getPosition().getY() < 0) { // Ball2 Y is less than 0
            int diff = 0 - ball2.getPosition().getY(); // Find how much new ball2 Y is less than 0
            ball2.getPosition().setY(diff);
            ball2.reverseYDirection(); // Reverse ball2 Y direction
        }

        // Find balls centers
        Position ball1Center = new Position(ball1.getPosition().getX() + ball1.getDiameter() / 2, ball1.getPosition().getY() + ball1.getDiameter() / 2);
        Position ball2Center = new Position(ball2.getPosition().getX() + ball2.getDiameter() / 2, ball2.getPosition().getY() + ball2.getDiameter() / 2);

        // Collision
        // Calculate distance between balls centers
        double distance = Math.sqrt(Math.pow((ball2Center.getX() - ball1Center.getX()), 2) + Math.pow((ball2Center.getY() - ball1Center.getY()), 2));
        if (distance <= (ball1.getDiameter() / 2 + ball2.getDiameter() / 2 + 2) && !Ball.movingOpposite(ball1, ball2)) { // Collision happened
            double ball1X = ball1.getDirecton().getX() - 2 * ball2.getMass() / (ball1.getMass() + ball2.getMass()) *
                            Direction.dotProduct(new Direction(ball1.getDirecton().getX() - ball2.getDirecton().getX(), ball1.getDirecton().getY() - ball2.getDirecton().getY()), new Direction(ball1Center.getX() - ball2Center.getX(), ball1Center.getY() - ball2Center.getY())) /
                            Math.pow(Math.sqrt(Math.pow(ball1Center.getX() - ball2Center.getX(), 2) + Math.pow(ball1Center.getY() - ball2Center.getY(), 2)) , 2) * (ball1Center.getX() - ball2Center.getX());
            double ball1Y = ball1.getDirecton().getY() - 2 * ball2.getMass() / (ball1.getMass() + ball2.getMass()) *
                            Direction.dotProduct(new Direction(ball1.getDirecton().getX() - ball2.getDirecton().getX(), ball1.getDirecton().getY() - ball2.getDirecton().getY()), new Direction(ball1Center.getX() - ball2Center.getX(), ball1Center.getY() - ball2Center.getY())) /
                            Math.pow(Math.sqrt(Math.pow(ball1Center.getX() - ball2Center.getX(), 2) + Math.pow(ball1Center.getY() - ball2Center.getY(), 2)) , 2) * (ball1Center.getY() - ball2Center.getY());
            double ball2X = ball2.getDirecton().getX() - 2 * ball1.getMass() / (ball1.getMass() + ball2.getMass()) *
                            Direction.dotProduct(new Direction(ball2.getDirecton().getX() - ball1.getDirecton().getX(), ball2.getDirecton().getY() - ball1.getDirecton().getY()), new Direction(ball2Center.getX() - ball1Center.getX(), ball2Center.getY() - ball1Center.getY())) /
                            Math.pow(Math.sqrt(Math.pow(ball2Center.getX() - ball1Center.getX(), 2) + Math.pow(ball2Center.getY() - ball1Center.getY(), 2)) , 2) * (ball2Center.getX() - ball1Center.getX());
            double ball2Y = ball2.getDirecton().getY() - 2 * ball1.getMass() / (ball1.getMass() + ball2.getMass()) *
                            Direction.dotProduct(new Direction(ball2.getDirecton().getX() - ball1.getDirecton().getX(), ball2.getDirecton().getY() - ball1.getDirecton().getY()), new Direction(ball2Center.getX() - ball1Center.getX(), ball2Center.getY() - ball1Center.getY())) /
                            Math.pow(Math.sqrt(Math.pow(ball2Center.getX() - ball1Center.getX(), 2) + Math.pow(ball2Center.getY() - ball1Center.getY(), 2)) , 2) * (ball2Center.getY() - ball1Center.getY());

            ball1.setDirection(ball1X, ball1Y);
            ball2.setDirection(ball2X, ball2Y);
        }
    }
}