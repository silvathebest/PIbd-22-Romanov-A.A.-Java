package com.company;

import java.awt.*;

public interface ITransport {
    void setPosition (int x, int y, int width, int height);

    void moveTransport(Direction direction);

    void draw(Graphics g);

}
