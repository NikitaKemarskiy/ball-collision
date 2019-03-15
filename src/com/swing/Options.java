package com.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Options extends JPanel {
    // Private
    private JSpinner ball1Spinner;
    private JSpinner ball2Spinner;
    private JButton setButton;
    private JButton startButton;

    // Initialization block
    {
        // Ball size JSpinners
        SpinnerModel spinner1Model = new SpinnerNumberModel();
        SpinnerModel spinner2Model = new SpinnerNumberModel();
        ball1Spinner = new JSpinner(spinner1Model);
        ball2Spinner = new JSpinner(spinner2Model);
        ((SpinnerNumberModel) spinner1Model).setMinimum(1);
        ((SpinnerNumberModel) spinner2Model).setMinimum(1);
        spinner1Model.setValue(1);
        spinner2Model.setValue(1);
        ((JSpinner.DefaultEditor) ball1Spinner.getEditor()).getTextField().setColumns(2);
        ((JSpinner.DefaultEditor) ball2Spinner.getEditor()).getTextField().setColumns(2);

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
        JLabel ball1Label = new JLabel("Ball1 size");
        JLabel ball2Label = new JLabel("Ball2 size");

        // JLabels options
        titleLabel.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
        ball1Label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        ball2Label.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        titleLabel.setForeground(Colors.extra);
        ball1Label.setForeground(Colors.gray);
        ball2Label.setForeground(Colors.gray);

        // JPanels
        JPanel titlePanel = new JPanel(new FlowLayout());
        JPanel ballPanel = new JPanel();
        JPanel ball1Panel = new JPanel(new GridLayout(1, 2));
        JPanel ball2Panel = new JPanel(new GridLayout(1, 2));
        JPanel spinner1Panel = new JPanel(new FlowLayout());
        JPanel spinner2Panel = new JPanel(new FlowLayout());

        // JPanels options
        ballPanel.setLayout(new BoxLayout(ballPanel, BoxLayout.Y_AXIS));
        ballPanel.setBorder(new EmptyBorder(6, 0, 0, 55));
        ball2Panel.setBorder(new EmptyBorder(2, 0, 10, 0));
        titlePanel.setBackground(new Color(0, 0, 0, 0));
        ballPanel.setBackground(new Color(0, 0, 0, 0));
        ball1Panel.setBackground(new Color(0, 0, 0, 0));
        ball2Panel.setBackground(new Color(0, 0, 0, 0));
        spinner1Panel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner2Panel.setBorder(new EmptyBorder(0, 3, 0, 10));
        spinner1Panel.setBackground(new Color(0, 0, 0, 0));
        spinner2Panel.setBackground(new Color(0, 0, 0, 0));

        // Fill panels with content
        titlePanel.add(titleLabel);
        ballPanel.add(ball1Panel);
        ballPanel.add(ball2Panel);
        spinner1Panel.add(ball1Spinner);
        spinner2Panel.add(ball2Spinner);
        ball1Panel.add(ball1Label);
        ball1Panel.add(spinner1Panel);
        ball2Panel.add(ball2Label);
        ball2Panel.add(spinner2Panel);

        // This window options
        this.setLocation(15, 15);
        this.setBorder(new EmptyBorder(10, 10, 10, 0));
        this.setSize(210, 175);
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

    public JSpinner getBall1Spinner() {
        return ball1Spinner;
    }

    public JSpinner getBall2Spinner() {
        return ball2Spinner;
    }

    public JButton getSetButton() {
        return setButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
