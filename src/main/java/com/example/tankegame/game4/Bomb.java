package com.example.tankegame.game4;

import lombok.Data;

/**
 * @author wza
 * @version 1.0.0
 */
@Data
public class Bomb {
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
