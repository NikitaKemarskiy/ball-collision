package com.graphics;

import com.swing.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraphicsComponent extends JComponent {
    // Private
    private Ball ball1;
    private Ball ball2;
    private boolean isStarted = false;

    // Public
    public static int defaultSize = 30;

    public GraphicsComponent(int ball1Size, int ball2Size) {
        ball1 = new Ball(new Position(0, 0), new Direction(1, 0), ball1Size);
        ball2 = new Ball(new Position(0, 0), new Direction(-1, 0), ball2Size);
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
        ball1.setSize(ball1Size);
        ball2.setSize(ball2Size);
        this.stop();
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void start() { // Method that starts an animation
        if (this.isStarted) { // Animation is already started
            return;
        }
    }

    public void stop() { // Method that stops an animation
        if (!this.isStarted) { // Animation is already stopped
            return;
        }
        this.isStarted = false;
    }
}
