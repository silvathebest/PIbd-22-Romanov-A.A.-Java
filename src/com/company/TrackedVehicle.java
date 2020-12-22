package com.company;

import java.awt.*;

public class TrackedVehicle extends Vehicle {
    protected int trackedVehicleWidth = 120;
    protected int trackedVehicleHeight = 200;
    protected double changeWidth = 3.1;
    protected double changeHeight = 2.1;

    public TrackedVehicle(int maxSpeed, float weight, Color mainColor) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
    }

    protected TrackedVehicle(int maxSpeed, float weight, Color mainColor, int carWidth, int carHeight) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.trackedVehicleWidth = carWidth;
        this.trackedVehicleHeight = carHeight;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(mainColor);
        //рисуем кузов гуснечной машины
        g.fillRect(startPosX + 10, startPosY + vehicleHeight - 50, vehicleWidth - 20, 30);
        //гусеницы
        g.fillOval(startPosX, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 30, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 55, startPosY + vehicleHeight - 20, 25, 20);
        g.fillOval(startPosX + 80, startPosY + vehicleHeight - 20, 25, 20);
        g.drawRect(startPosX + 10, startPosY + vehicleHeight - 20, vehicleWidth -35, 20);
    }

    @Override
    public void moveTransport(Direction direction) {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            case Right:
                if (startPosX + step < pictureWidth - trackedVehicleWidth * changeWidth) {
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
                if (startPosY + step < pictureHeight - trackedVehicleHeight * changeHeight) {
                    startPosY += step;
                }
                break;
        }
    }
}
