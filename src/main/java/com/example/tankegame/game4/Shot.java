package com.example.tankegame.game4;

import java.io.Serializable;

/**
 * @author wza
 * @version 1.0.0
 */
public class Shot extends Thread implements Serializable {
    private int x;//子弹x
    private int y;//子弹y
    private int speed = 5;//子弹速度
    private int direct;
    private boolean isLive = true;

    @Override
    public void run() {
        loop:
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0:
                    y = y - speed;
                    break;
                case 1:
                    x = x + speed;
                    break;
                case 2:
                    y = y + speed;
                    break;
                case 3:
                    x = x - speed;
                    break;
                default:
                    throw new RuntimeException("子弹方向不正确:" + direct);
            }

            //判断是否边界
            System.out.println("x=" + x + ",y=" + y);
            if (!(x >= 0 && x <= MyPanel.width && y >= 0 && y <= MyPanel.height && isLive)) {
                System.out.println("子线程退出");
                isLive = false;
                break loop;
            }
        }
    }

    public Shot(Tank tank) {
        //根据坦克获取子弹x y
        getBulletByTank(tank);
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    private void getBulletByTank(Tank tank) {
        if (tank == null) {
            throw new RuntimeException("坦克不能为空");
        }
        direct = tank.getDirect();
        switch (tank.getDirect()) {
            case 0:
                x = tank.getX();
                y = tank.getY() - 30;
                break;
            case 1:
                x = tank.getX() + 30;
                y = tank.getY();
                break;
            case 2:
                x = tank.getX();
                y = tank.getY() + 30;
                break;
            case 3:
                x = tank.getX() - 30;
                y = tank.getY();
                break;
            default:
                throw new RuntimeException("无法判断坦克方向:" + tank.getDirect());
        }
    }

}
