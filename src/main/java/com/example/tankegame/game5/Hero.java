package com.example.tankegame.game5;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
public class Hero extends Tank implements Serializable {
    public static final Long serialVersionUID = 1L;
    public final int color = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }

}
