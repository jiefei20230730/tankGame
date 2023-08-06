package com.example.tankegame.game4;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
public class Hero extends Tank implements Serializable {
    public final int color = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }

}
