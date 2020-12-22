package com.company;

import java.awt.*;

public class RectRoller implements IAdding {
    private TrackCount trackCount;

    public RectRoller(int number) {
        setDigit(number);
    }

    @Override
    public void setDigit(int number) {
        this.trackCount = TrackCount.getCount(number);
    }

    @Override
    public void draw(Graphics g, int startPosX, int startPosY, int craneWidth, int craneHeight) {
        g.setColor(Color.GREEN);
        g.fillRect(startPosX + 5, startPosY + craneHeight - 15, 15, 10);
        g.fillRect(startPosX + 35, startPosY + craneHeight - 15, 15, 10);
        g.fillRect(startPosX + 60, startPosY + craneHeight - 15, 15, 10);
        g.fillRect(startPosX + 85, startPosY + craneHeight - 15, 15, 10);

        if (trackCount == TrackCount.five || trackCount == TrackCount.six) {
            g.setColor(Color.BLACK);
            g.fillOval(startPosX + 105, startPosY + craneHeight - 20, 25, 20);
            g.drawLine(startPosX + 10, startPosY + craneHeight - 20, startPosX + 120, startPosY + craneHeight - 20);
            g.drawLine(startPosX + 10, startPosY + craneHeight, startPosX + 120, startPosY + craneHeight);
            g.setColor(Color.GREEN);
            g.fillRect(startPosX + 110, startPosY + craneHeight - 15, 15, 10);
        }
        if (trackCount == TrackCount.six) {
            g.setColor(Color.BLACK);
            g.fillOval(startPosX - 25, startPosY + craneHeight - 20, 25, 20);
            g.drawLine(startPosX - 15, startPosY + craneHeight - 20, startPosX + 25, startPosY + craneHeight - 20);
            g.drawLine(startPosX - 15, startPosY + craneHeight, startPosX + 25, startPosY + craneHeight);
            g.setColor(Color.GREEN);
            g.fillRect(startPosX - 20, startPosY + craneHeight - 15, 15, 10);
        }
    }

}
