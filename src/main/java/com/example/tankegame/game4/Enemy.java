package com.example.tankegame.game4;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
public class Enemy extends Tank implements Serializable, Runnable {
    public final int color = 1;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }

    @Override
    public void run() {
        while (isLive()) {
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 20; i++) {
                        if (getY() - 30 > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 20; i++) {
                        if (getX() + 30 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 20; i++) {
                        if (getY() + 30 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 20; i++) {
                        if (getX() - 30 > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    throw new RuntimeException("敌方坦克方向不对" + getDirect());
            }
            //改变方向
            setDirect((int) (Math.random() * 4));
            this.shot(MyPanel.width, MyPanel.height);
        }
    }
}
