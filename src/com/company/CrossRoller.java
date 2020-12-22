package com.company;

import java.awt.*;

public class CrossRoller implements IAdding {
    private TrackCount trackCount;
    private final Color black = Color.BLACK;

    public CrossRoller(int number) {
        setDigit(number);
    }

    @Override
    public void setDigit(int number) {
        this.trackCount = TrackCount.getCount(number);
    }

    @Override
    public void draw(Graphics g, int startPosX, int startPosY, int craneWidth, int craneHeight) {
        g.setColor(Color.GREEN);
        g.fillRect(startPosX + 5, startPosY + craneHeight - 10, 15, 3);
        g.fillRect(startPosX + 11, startPosY + craneHeight - 16, 3, 15);
        g.fillRect(startPosX + 35, startPosY + craneHeight - 10, 15, 3);
        g.fillRect(startPosX + 41, startPosY + craneHeight - 16, 3, 15);
        g.fillRect(startPosX + 60, startPosY + craneHeight - 10, 15, 3);
        g.fillRect(startPosX + 66, startPosY + craneHeight - 16, 3, 15);
        g.fillRect(startPosX + 85, startPosY + craneHeight - 10, 15, 3);
        g.fillRect(startPosX + 91, startPosY + craneHeight - 16, 3, 15);
        if (trackCount == TrackCount.five || trackCount == TrackCount.six) {
            g.setColor(black);
            g.fillOval(startPosX + 105, startPosY + craneHeight - 20, 25, 20);
            g.drawRect(startPosX + 10, startPosY + craneHeight - 20, craneWidth - 10, 20);
            g.setColor(Color.GREEN);
            g.fillRect(startPosX + 110, startPosY + craneHeight - 10, 15, 3);
            g.fillRect(startPosX + 116, startPosY + craneHeight - 16, 3, 15);
        }
        if (trackCount == TrackCount.six) {
            g.setColor(black);
            g.fillOval(startPosX - 25, startPosY + craneHeight - 20, 25, 20);
            g.drawRect(startPosX - 15, startPosY + craneHeight - 20, craneWidth - 10, 20);
            g.setColor(Color.GREEN);
            g.fillRect(startPosX - 20, startPosY + craneHeight - 10, 15, 3);
            g.fillRect(startPosX - 14, startPosY + craneHeight - 16, 3, 15);
        }
    }
}
