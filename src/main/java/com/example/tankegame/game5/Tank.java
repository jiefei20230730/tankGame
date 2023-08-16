package com.example.tankegame.game5;

import lombok.Data;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
@Data
public class Tank implements Serializable {
    private int x;
    private int y;
    private int direct;
    private int speed = 1;//子弹速度
    private boolean isLive = true;
    private Vector<Shot> shotVector = new Vector<>();//定义子弹

    public void shot() {
        //添加到bulletVector，画板去画
        Shot shot = new Shot(this);
        shotVector.add(shot);
        //开启线程
        Thread thread = new Thread(shot);
        thread.start();
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y = y - speed;
        direct = 0;
    }

    public void moveRight() {
        x = x + speed;
        direct = 1;
    }

    public void moveDown() {
        y = y + speed;
        direct = 2;
    }

    public void moveLeft() {
        x = x - speed;
        direct = 3;
    }

}
