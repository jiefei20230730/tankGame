package com.example.tankegame.game3;

import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
public class Hero extends Tank {
    public final int color = 0;
    //定义子弹
    Vector<Shot> shotVector = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }

    public Vector<Shot> getShotVector() {
        return shotVector;
    }

    public void setShotVector(Vector<Shot> shotVector) {
        this.shotVector = shotVector;
    }

    public void shotEnemyTank(int panelX, int panelY) {
        //添加到bulletVector，画板去画
        Shot shot = new Shot(this, panelX, panelY);
        shotVector.add(shot);
        //开启线程
        Thread thread = new Thread(shot);
        thread.start();
    }
}
