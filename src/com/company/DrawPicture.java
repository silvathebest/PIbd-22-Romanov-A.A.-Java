package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPicture extends JPanel {

    private Crane crane;

    public void paintComponent(Graphics g) {
        if (crane != null) {
            crane.drawCrane(g);
        }
    }

    public void setVehicle(Crane ex) {
        this.crane = ex;
    }

    public Crane getVehicle() {
        return crane;
    }

}
