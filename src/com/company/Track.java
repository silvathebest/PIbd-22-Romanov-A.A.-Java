package com.company;

import java.awt.*;

public class Track {

    private TrackCount count;

    public void setNumber(int number) {
        count = TrackCount.getCount(number);
    }

    public void DrawTrack(Graphics g, int startPosX, int startPosY, int vehicleWidth, int vehicleHeight) {
        g.setColor(Color.BLACK);
        g.drawLine(startPosX, startPosY + vehicleHeight - 20, startPosX + 115, startPosY + vehicleHeight-20 );
        g.drawLine(startPosX, startPosY + vehicleHeight, startPosX + 115, startPosY + vehicleHeight);
        g.fillOval(startPosX + 10, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 35, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 60, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 85, startPosY + vehicleHeight - 20, 25, 20);
        if (count == TrackCount.five || count == TrackCount.six) {
            g.fillOval(startPosX -15, startPosY + vehicleHeight - 20, 25, 20);
        }
        if (count == TrackCount.six) {
            g.fillOval(startPosX +110, startPosY + vehicleHeight - 20, 25, 20);
        }
    }
}
