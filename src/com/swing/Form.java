package com.swing;

import com.graphics.*;

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
        this.draw(11, 9);
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