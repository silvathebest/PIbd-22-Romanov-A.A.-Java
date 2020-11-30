package com.company;

import javax.swing.*;
import java.awt.*;

public class CraneForm {

    private JButton createButton;
    private JButton upButton;
    private JButton leftButton;
    private JButton rightButton;
    private JButton downButton;
    private JComboBox<Integer> choiceButton;
    private Crane crane;
    private JFrame frame;
    private DrawPicture draw;

    public void direction(JButton button) {
        String direct = button.getName();
        switch (direct) {
            case "Up" -> crane.moveTransport(Direction.Up);
            case "Down" -> crane.moveTransport(Direction.Down);
            case "Left" -> crane.moveTransport(Direction.Left);
            case "Right" -> crane.moveTransport(Direction.Right);
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

        upButton.setEnabled(false);
        downButton.setEnabled(false);
        rightButton.setEnabled(false);
        leftButton.setEnabled(false);

        createButton = new JButton("Create");
        createButton.setBounds(0, 0, 90, 30);
        createButton.addActionListener(e -> {
            crane = new Crane(100 + ((int) (Math.random() * 300)), 1000 + ((int) (Math.random() * 2000)), Color.BLACK,
                    Color.YELLOW, true, true, true, choiceButton.getSelectedIndex() + 4);
            crane.setPosition(10 + ((int) (Math.random() * 100)), 10 + ((int) (Math.random() * 100)), 900, 500);
            upButton.setEnabled(true);
            downButton.setEnabled(true);
            rightButton.setEnabled(true);
            leftButton.setEnabled(true);
            draw.setVehicle(crane);
            frame.repaint();
        });

        choiceButton = new JComboBox<>(new Integer[]{4, 5, 6});
        choiceButton.setBounds(0, 40, 90, 30);
    }

    public CraneForm() {
        draw = new DrawPicture();
        frame = new JFrame("Кран");
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        initialization();
        frame.getContentPane().add(createButton);
        frame.getContentPane().add(upButton);
        frame.getContentPane().add(downButton);
        frame.getContentPane().add(leftButton);
        frame.getContentPane().add(rightButton);
        frame.getContentPane().add(choiceButton);
        frame.getContentPane().add(draw);
        draw.setBounds(0, 0, 900, 500);
        frame.repaint();
    }
}
