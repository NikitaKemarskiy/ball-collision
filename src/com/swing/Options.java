package com.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Options extends JPanel {
    // Private
    private JSpinner ball1SizeSpinner;
    private JSpinner ball2SizeSpinner;
    private JSpinner ball1SpeedSpinner;
    private JSpinner ball2SpeedSpinner;
    private JButton setButton;
    private JButton startButton;

    // Initialization block
    {
        // Ball size JSpinners
        SpinnerModel spinner1SizeModel = new SpinnerNumberModel();
        SpinnerModel spinner2SizeModel = new SpinnerNumberModel();
        SpinnerModel spinner1SpeedModel = new SpinnerNumberModel();
        SpinnerModel spinner2SpeedModel = new SpinnerNumberModel();
        ball1SizeSpinner = new JSpinner(spinner1SizeModel);
        ball2SizeSpinner = new JSpinner(spinner2SizeModel);
        ball1SpeedSpinner = new JSpinner(spinner1SpeedModel);
        ball2SpeedSpinner = new JSpinner(spinner2SpeedModel);
        ((SpinnerNumberModel) spinner1SizeModel).setMinimum(1);
        ((SpinnerNumberModel) spinner2SizeModel).setMinimum(1);
        ((SpinnerNumberModel) spinner1SpeedModel).setMinimum(1);
        ((SpinnerNumberModel) spinner2SpeedModel).setMinimum(1);
        ((SpinnerNumberModel) spinner1SpeedModel).setMaximum(10);
        ((SpinnerNumberModel) spinner2SpeedModel).setMaximum(10);
        spinner1SizeModel.setValue(1);
        spinner2SizeModel.setValue(1);
        spinner1SpeedModel.setValue(1);
        spinner2SpeedModel.setValue(1);
        ((JSpinner.DefaultEditor) ball1SizeSpinner.getEditor()).getTextField().setColumns(2);
        ((JSpinner.DefaultEditor) ball2SizeSpinner.getEditor()).getTextField().setColumns(2);
        ((JSpinner.DefaultEditor) ball1SpeedSpinner.getEditor()).getTextField().setColumns(2);
        ((JSpinner.DefaultEditor) ball2SpeedSpinner.getEditor()).getTextField().setColumns(2);

        // Start button
        startButton = new JButton("Start");
        startButton.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        startButton.setForeground(Colors.gray);
        startButton.setBackground(Colors.main);
        startButton.setBorder(new LineBorder(Colors.gray, 1));
        startButton.setPreferredSize(new Dimension(80, 20));
        startButton.setMinimumSize(new Dimension(80, 20));
        startButton.setMaximumSize(new Dimension(80, 20));

        // Set button
        setButton = new JButton("Set");
        setButton.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        setButton.setForeground(Colors.gray);
        setButton.setBackground(Colors.main);
        setButton.setBorder(new LineBorder(Colors.gray, 1));
        setButton.setPreferredSize(new Dimension(80, 20));
        setButton.setMinimumSize(new Dimension(80, 20));
        setButton.setMaximumSize(new Dimension(80, 20));
    }

    // Public
    Options() {
        super(new FlowLayout(FlowLayout.LEFT));

        // JLabels
        JLabel titleLabel = new JLabel("Ball collision");
        JLabel ball1SizeLabel = new JLabel("Ball1 size");
        JLabel ball2SizeLabel = new JLabel("Ball2 size");
        JLabel ball1SpeedLabel = new JLabel("Ball1 speed");
        JLabel ball2SpeedLabel = new JLabel("Ball2 speed");

        // JLabels options
        titleLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        ball1SizeLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        ball2SizeLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        ball1SpeedLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        ball2SpeedLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        titleLabel.setForeground(Colors.extra);
        ball1SizeLabel.setForeground(Colors.gray);
        ball2SizeLabel.setForeground(Colors.gray);
        ball1SpeedLabel.setForeground(Colors.gray);
        ball2SpeedLabel.setForeground(Colors.gray);

        // JPanels
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel ballPanel = new JPanel();
        JPanel ball1SizePanel = new JPanel(new GridLayout(1, 2));
        JPanel ball2SizePanel = new JPanel(new GridLayout(1, 2));
        JPanel ball1SpeedPanel = new JPanel(new GridLayout(1, 2));
        JPanel ball2SpeedPanel = new JPanel(new GridLayout(1, 2));
        JPanel spinner1SizePanel = new JPanel(new FlowLayout());
        JPanel spinner2SizePanel = new JPanel(new FlowLayout());
        JPanel spinner1SpeedPanel = new JPanel(new FlowLayout());
        JPanel spinner2SpeedPanel = new JPanel(new FlowLayout());

        // JPanels options
        ballPanel.setLayout(new BoxLayout(ballPanel, BoxLayout.Y_AXIS));
        ballPanel.setBorder(new EmptyBorder(6, 0, 0, 55));
        ball2SpeedPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        titlePanel.setBackground(new Color(0, 0, 0, 0));
        ballPanel.setBackground(new Color(0, 0, 0, 0));
        ball1SizePanel.setBackground(new Color(0, 0, 0, 0));
        ball2SizePanel.setBackground(new Color(0, 0, 0, 0));
        ball1SpeedPanel.setBackground(new Color(0, 0, 0, 0));
        ball2SpeedPanel.setBackground(new Color(0, 0, 0, 0));
        spinner1SizePanel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner2SizePanel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner1SpeedPanel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner2SpeedPanel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner1SizePanel.setBackground(new Color(0, 0, 0, 0));
        spinner2SizePanel.setBackground(new Color(0, 0, 0, 0));
        spinner1SpeedPanel.setBackground(new Color(0, 0, 0, 0));
        spinner2SpeedPanel.setBackground(new Color(0, 0, 0, 0));

        // Fill panels with content
        titlePanel.add(titleLabel);
        ballPanel.add(ball1SizePanel);
        ballPanel.add(ball2SizePanel);
        ballPanel.add(ball1SpeedPanel);
        ballPanel.add(ball2SpeedPanel);
        spinner1SizePanel.add(ball1SizeSpinner);
        spinner2SizePanel.add(ball2SizeSpinner);
        spinner1SpeedPanel.add(ball1SpeedSpinner);
        spinner2SpeedPanel.add(ball2SpeedSpinner);
        ball1SizePanel.add(ball1SizeLabel);
        ball1SizePanel.add(spinner1SizePanel);
        ball2SizePanel.add(ball2SizeLabel);
        ball2SizePanel.add(spinner2SizePanel);
        ball1SpeedPanel.add(ball1SpeedLabel);
        ball1SpeedPanel.add(spinner1SpeedPanel);
        ball2SpeedPanel.add(ball2SpeedLabel);
        ball2SpeedPanel.add(spinner2SpeedPanel);

        // This window options
        this.setLocation(15, 15);
        this.setBorder(new EmptyBorder(10, 10, 10, 0));
        this.setSize(210, 230);
        this.setBackground(new Color(0, 0, 0, 180));
        this.setAlignmentX(0.5f);
        this.setAlignmentY(0.5f);
        this.setOpaque(true);

        // Fill this window with content
        this.add(titleLabel);
        this.add(ballPanel);
        this.add(setButton);
        this.add(startButton);
    }

    public JSpinner getBall1SizeSpinner() {
        return ball1SizeSpinner;
    }

    public JSpinner getBall2SizeSpinner() {
        return ball2SizeSpinner;
    }

    public JSpinner getBall1SpeedSpinner() {
        return ball1SpeedSpinner;
    }

    public JSpinner getBall2SpeedSpinner() {
        return ball2SpeedSpinner;
    }

    public JButton getSetButton() {
        return setButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
