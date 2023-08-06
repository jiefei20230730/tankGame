package com.example.tankegame.game3;

/**
 * @author wza
 * @version 1.0.0
 */
public class Tank {
    private int x;
    private int y;
    private int direct;

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
}
