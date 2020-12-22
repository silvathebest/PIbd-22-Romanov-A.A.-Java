package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPicture extends JPanel {

    private ITransport transport;

    public void paintComponent(Graphics g) {
        if (transport != null) {
            transport.draw(g);
        }
    }

    public void setVehicle(ITransport ex) {
        this.transport = ex;
    }

    public ITransport getVehicle() {
        return transport;
    }

}
