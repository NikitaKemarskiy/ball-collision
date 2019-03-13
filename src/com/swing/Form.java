package com.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Form extends JFrame {
    // Private
    private final static int screenWidth; // Screen width in pixels
    private final static int screenHeight; // Screen height in pixels
    private final Container pane;
    private GraphicsComponent graphics;
    private Options options;

    // Function that draws options JPanel and initial graphics
    private void draw(int ball1Size, int ball2Size) {
        graphics = new GraphicsComponent(ball1Size, ball2Size); // Graphics component
        options = new Options();
        pane.add(options);
        pane.add(graphics);
    }

    // Function that updates ball size
    private void updateBallSize(int ball1Size, int ball2Size) {
        graphics.setBallSize(ball1Size, ball2Size);
        graphics.repaint();
    }

    // Static initialization block
    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
    }

    // Public
    public Form() { // Constructor
        super("Ball collision");
        pane = this.getContentPane();
        pane.setLayout(new OverlayLayout(pane));
        this.setSize(new Dimension((int) (screenWidth / 2.2), (int) (screenHeight / 2))); // Size
        this.setMinimumSize(new Dimension(screenWidth / 3, (int) (screenHeight / 2.2)));
        this.setLocation(screenWidth / 2 - this.getWidth() / 2, screenHeight / 2 - this.getHeight() / 2); // Location
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.draw(1, 1);
    }

    // Function that starts ball collision imitation process
    public void start() {
        //...
    }

    // Function that starts ball collision imitation process
    public void stop() {
        //...
    }
}

class GraphicsComponent extends JComponent {
    // Private
    private static int defaultSize = 30;
    private int ball1Size;
    private int ball2Size;

    // Public
    GraphicsComponent(int ball1Size, int ball2Size) {
        this.ball1Size = ball1Size;
        this.ball2Size = ball2Size;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth(); // Application width
        int height = getHeight(); // Application height
        int ball1Diameter = defaultSize * ball1Size;
        int ball2Diameter = defaultSize * ball2Size;
        if (ball1Diameter > getHeight() * 0.7 || ball2Diameter > getHeight() * 0.7) {
            double ratio = ball1Diameter > getHeight() * 0.7 ? ball1Diameter / (getHeight() * 0.7) : 1;
            ratio = ratio > ball2Diameter / (getHeight() * 0.7) ? ratio : ball2Diameter / (getHeight() * 0.7);
            ball1Diameter /= ratio;
            ball2Diameter /= ratio;
        }
        Ellipse2D ball1 = new Ellipse2D.Double(0, height - ball1Diameter, ball1Diameter, ball1Diameter);
        Ellipse2D ball2 = new Ellipse2D.Double(width - ball2Diameter, height - ball2Diameter, ball2Diameter, ball2Diameter);

        g2.setColor(Colors.main);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(Colors.extra);
        g2.fill(ball1);
        g2.fill(ball2);
    }

    public void setBallSize(int ball1Size, int ball2Size) {
        this.ball1Size = ball1Size;
        this.ball2Size = ball2Size;
    }
}