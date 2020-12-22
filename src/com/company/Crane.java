package com.company;

import java.awt.*;

public class Crane extends TrackedVehicle {
    public Color dopColor;
    public boolean backPipe;
    public boolean frontCrane;
    public boolean hook;
    private IAdding IAdding;

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
                 boolean backPipe, boolean FrontCrane, boolean hook, int add, int number) {
        super(maxSpeed, weight, mainColor, 120, 200);
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.backPipe = backPipe;
        this.frontCrane = FrontCrane;
        this.hook = hook;
        switch (add) {
            case 0 -> IAdding = new CircleRoller(number);
            case 1 -> IAdding = new CrossRoller(number);
            case 2 -> IAdding = new RectRoller(number);
        }

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
                if (startPosX + step < pictureWidth - vehicleWidth) {
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

    public void draw(Graphics g) {
        //кран
        if (frontCrane) {
            g.drawLine(startPosX + 30, startPosY + vehicleHeight - 50, startPosX + 70, startPosY + 30);
            g.drawLine(startPosX + 70, startPosY + 30, startPosX + 80, startPosY + 70);
        }
        //крюк
        if (hook) {
            g.drawArc(startPosX + 65, startPosY + 70, 30, 30, 90, 180);
        }
        //задняя труба
        if (backPipe) {
            g.setColor(dopColor);
            g.fillRect(startPosX + 15, startPosY + vehicleHeight - 70, 10, 20);
        }
        super.draw(g);
        IAdding.draw(g, startPosX, startPosY, vehicleWidth, vehicleHeight);
    }
}
