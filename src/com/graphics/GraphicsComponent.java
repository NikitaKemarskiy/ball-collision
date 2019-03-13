package com.graphics;

import com.swing.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraphicsComponent extends JComponent {
    // Private
    private Ball ball1;
    private Ball ball2;

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
        if (ball1.getDiameter() > height * 0.7 || ball2.getDiameter() > height * 0.7) { // Ball is too big
            double ratio = ball1.getDiameter() > height * 0.7 ? ball1.getDiameter() / (height * 0.7) : 1; // Find ratio
            ratio = ratio > ball2.getDiameter() / (height * 0.7) ? ratio : ball2.getDiameter() / (height * 0.7);
            ball1.setDiameter((int)(ball1.getDiameter() / ratio)); // Set new size
            ball2.setDiameter((int)(ball2.getDiameter() / ratio));
        }
        Ellipse2D ball1_ = new Ellipse2D.Double(ball1.getDirecton().getX(), ball1.getDirecton().getY(), ball1.getDiameter(), ball1.getDiameter());
        Ellipse2D ball1Shape = new Ellipse2D.Double(0, height - ball1.getDiameter(), ball1.getDiameter(), ball1.getDiameter());
        Ellipse2D ball2Shape = new Ellipse2D.Double(width - ball2.getDiameter(), height - ball2.getDiameter(), ball2.getDiameter(), ball2.getDiameter());

        g2.setColor(Colors.main);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(Colors.extra);
        g2.fill(ball1Shape);
        g2.fill(ball2Shape);
    }

    public void setBallSize(int ball1Size, int ball2Size) {
        /*this.ball1Size = ball1Size;
        this.ball2Size = ball2Size;*/
    }
}
