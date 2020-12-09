package com.company;

import java.awt.*;

public class Crane {
    private int startPosX;
    private int startPosY;
    private int pictureWidth;
    private int pictureHeight;
    private final int vehicleWidth = 120;
    private final int vehicleHeight = 200;
    public int maxSpeed;
    public float weight;
    public Color mainColor;
    public Color dopColor;
    public boolean backPipe;
    public boolean frontCrane;
    public boolean hook;
    private final Track track;

    public float getStartPosX() {
        return startPosX;
    }

    private void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    private void setWeight(float weight) {
        this.weight = weight;
    }

    public Color getMainColor() {
        return mainColor;
    }

    private void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getDopColor() {
        return dopColor;
    }

    private void setDopColor(Color dopColor) {
        this.dopColor = dopColor;
    }

    public boolean isBackPipe() {
        return backPipe;
    }

    private void setBackPipe(boolean backPipe) {
        this.backPipe = backPipe;
    }

    public boolean isFrontCrane() {
        return frontCrane;
    }

    private void setFrontCrane(boolean frontCrane) {
        this.frontCrane = frontCrane;
    }

    public boolean isHook() {
        return hook;
    }

    private void setHook(boolean hook) {
        this.hook = hook;
    }

    public Crane(int maxSpeed, float weight, Color mainColor, Color dopColor,
                 boolean backPipe, boolean FrontCrane, boolean hook, int trackCount) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.backPipe = backPipe;
        this.frontCrane = FrontCrane;
        this.hook = hook;
        track = new Track();
        track.setNumber(trackCount);
    }

    public void setPosition(int x, int y, int width, int height) {
        if (x >= 0 && x + vehicleWidth < width && y >= 0 && y + vehicleHeight < height) {
            startPosX = x;
            startPosY = y;
            pictureWidth = width;
            pictureHeight = height;
        }

    }

    public void moveTransport(Direction dir) {
        float step = maxSpeed * 100 / weight;
        switch (dir) {
            case Right:
                if (startPosX + step < pictureWidth - vehicleWidth ) {
                    startPosX += step;
                }
                break;
            case Left:
                if (startPosX - step > 0) {
                    startPosX -= step;
                }
                break;
            case Up:
                if (startPosY - step > 0) {
                    startPosY -= step;
                }
                break;
            case Down:
                if (startPosY + step < pictureHeight - vehicleHeight - 40) {
                    startPosY += step;
                }
                break;
        }
    }

    public void drawCrane(Graphics g) {
        g.setColor(mainColor);
        //рисуем кузов гуснечной машины
        g.fillRect(startPosX + 10, startPosY + vehicleHeight - 50, vehicleWidth - 20, 30);
        //гусеницы
        track.DrawTrack(g, startPosX, startPosY, vehicleWidth, vehicleHeight);

        //кран
        if (frontCrane)
        {
            g.drawLine(startPosX + 30, startPosY + vehicleHeight - 50, startPosX + 70, startPosY + 30);
            g.drawLine(startPosX + 70, startPosY + 30, startPosX + 80, startPosY + 70);
        }
        //крюк
        if (hook)
        {
            g.drawArc( startPosX + 65, startPosY + 70, 30, 30, 90, 180);
        }
        //задняя труба
        if (backPipe)
        {
            g.setColor(dopColor);
            g.fillRect(startPosX + 15, startPosY + vehicleHeight - 70, 10, 20);
        }

    }
}
