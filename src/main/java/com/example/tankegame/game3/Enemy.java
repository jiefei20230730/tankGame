package com.example.tankegame.game3;

/**
 * @author wza
 * @version 1.0.0
 */
public class Enemy extends Tank {
    public final int color = 1;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }
}
