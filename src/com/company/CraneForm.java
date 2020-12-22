package com.company;

import javax.swing.*;
import java.awt.*;

public class CraneForm {

    private JButton createTrackedButton;
    private JButton createCraneButton;
    private JButton upButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton downButton;
    private JComboBox<String> choiceCountTrackButton;
    private JComboBox<String> choiceAddingButton;
    private ITransport transport;
    private final JFrame frame;
    private final DrawPicture draw;
    private final int windowWidth = 900;
    private final int windowHeight = 500;

    public void direction(JButton button) {
        String direct = button.getName();
        switch (direct) {
            case "Up" -> transport.moveTransport(Direction.Up);
            case "Down" -> transport.moveTransport(Direction.Down);
            case "Left" -> transport.moveTransport(Direction.Left);
            case "Right" -> transport.moveTransport(Direction.Right);
        }
        frame.repaint();
    }

    public void initialization() {
        Icon up = new ImageIcon("Images/up.png");
        Icon down = new ImageIcon("Images/down.png");
        Icon left = new ImageIcon("Images/left.png");
        Icon right = new ImageIcon("Images/right.png");
        upButton = new JButton(up);
        upButton.setName("Up");
        upButton.setBounds(700, 300, 64, 64);
        upButton.addActionListener(e -> direction(upButton));

        downButton = new JButton(down);
        downButton.setName("Down");
        downButton.setBounds(700, 350, 64, 64);
        downButton.addActionListener(e -> direction(downButton));

        rightButton = new JButton(right);
        rightButton.setName("Right");
        rightButton.setBounds(750, 350, 64, 64);
        rightButton.addActionListener(e -> direction(rightButton));

        leftButton = new JButton(left);
        leftButton.setName("Left");
        leftButton.setBounds(650, 350, 64, 64);
        leftButton.addActionListener(e -> direction(leftButton));

        createTrackedButton = new JButton("TrackedVehicle");
        createTrackedButton.setBounds(0, 0, 130, 30);
        createTrackedButton.addActionListener(e -> {
            transport = new TrackedVehicle(100 + ((int) (Math.random() * 300)), 1000 + ((int) (Math.random() * 2000)), Color.BLACK);
            transport.setPosition(10 + ((int) (Math.random() * 100)), 10 + ((int) (Math.random() * 100)), windowWidth, windowHeight);
            draw.setVehicle(transport);
            frame.repaint();
        });

        createCraneButton = new JButton("Crane");
        createCraneButton.setBounds(150, 0, 140, 30);
        createCraneButton.addActionListener(e -> {
            transport = new Crane(100 + ((int) (Math.random() * 300)), 1000 + ((int) (Math.random() * 2000)), Color.BLACK, Color.YELLOW,
                    true, true, true, choiceAddingButton.getSelectedIndex(), choiceCountTrackButton.getSelectedIndex());
            transport.setPosition(10 + ((int) (Math.random() * 100)), 10 + ((int) (Math.random() * 100)), windowWidth, windowHeight);
            draw.setVehicle(transport);
            frame.repaint();
        });


        choiceAddingButton = new JComboBox<>(new String[]{"Circle", "Cross", "Rectangle"});
        choiceAddingButton.setBounds(0, 40, 130, 30);

        choiceCountTrackButton = new JComboBox<>(new String[]{"4 roller", "5 roller", "6 roller"});
        choiceCountTrackButton.setBounds(150, 40, 130, 30);
    }

    public CraneForm() {
        draw = new DrawPicture();
        frame = new JFrame("Кран");
        frame.setSize(windowWidth, windowHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        initialization();
        frame.getContentPane().add(createTrackedButton);
        frame.getContentPane().add(createCraneButton);
        frame.getContentPane().add(upButton);
        frame.getContentPane().add(downButton);
        frame.getContentPane().add(leftButton);
        frame.getContentPane().add(rightButton);
        frame.getContentPane().add(choiceAddingButton);
        frame.getContentPane().add(choiceCountTrackButton);
        frame.getContentPane().add(draw);
        draw.setBounds(0, 0, windowWidth, windowHeight);
        frame.repaint();
    }
}

