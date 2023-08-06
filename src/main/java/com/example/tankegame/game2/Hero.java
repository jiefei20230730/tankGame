package com.example.tankegame.game2;

import java.awt.*;

/**
 * @author wza
 * @version 1.0.0
 */
public class Hero extends Tank {
    public final int color = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }
}
