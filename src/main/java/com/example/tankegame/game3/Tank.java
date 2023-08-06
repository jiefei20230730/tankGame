package com.example.tankegame.game3;

import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
public class Tank {
    private int x;
    private int y;
    private int direct;
    private Vector<Shot> shotVector = new Vector<>();//定义子弹

    public void shot(int panelX, int panelY) {
        //添加到bulletVector，画板去画
        Shot shot = new Shot(this, panelX, panelY);
        shotVector.add(shot);
        //开启线程
        Thread thread = new Thread(shot);
        thread.start();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y--;
        direct=0;
    }

    public void moveDown() {
        y++;
        direct=2;
    }

    public void moveLeft() {
        x--;
        direct=3;
    }

    public void moveRight() {
        x++;
        direct=1;
    }

    public Vector<Shot> getShotVector() {
        return shotVector;
    }

    public void setShotVector(Vector<Shot> shotVector) {
        this.shotVector = shotVector;
    }
}
