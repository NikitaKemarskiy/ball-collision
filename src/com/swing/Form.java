package com.swing;

import com.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;

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
        options.getSetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                options.getStartButton().setText("Start"); // Set new text to the start button
                graphics.setBallSize((int)(options.getBall1SizeSpinner().getValue()), (int)(options.getBall2SizeSpinner().getValue()));
                graphics.setBallSpeed((int)(options.getBall1SpeedSpinner().getValue()), (int)(options.getBall2SpeedSpinner().getValue()));
                (new Timer()).schedule(new TimerTask() { // Set timeout to make isStarted false
                    @Override
                    public void run() {
                        graphics.repaint();
                    }
                }, graphics.intervalTime);
            }
        });
        options.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (graphics.isStarted()) { // Animation is already started
                    graphics.stop();
                } else { // Animation is stopped
                    graphics.start();
                }
                // Set new text to the start button
                options.getStartButton().setText(options.getStartButton().getText() == "Start" ? "Stop" : "Start");
            }
        });
        pane.add(options);
        pane.add(graphics);
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
        graphics.start();
    }

    // Function that starts ball collision imitation process
    public void stop() {
        graphics.stop();
    }
}