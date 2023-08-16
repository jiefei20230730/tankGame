package com.example.tankegame.game5;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
@Data
public class Bomb implements Serializable {
    public static final Long serialVersionUID = 1L;
    int x, y;//炸弹中心坐标
    int life = 9;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        }
    }
}
