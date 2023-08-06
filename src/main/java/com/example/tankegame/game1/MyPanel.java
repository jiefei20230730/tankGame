package com.example.tankegame.game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author wza
 * @version 1.0.0
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;

    public MyPanel() {
        this.hero = new Hero(80, 80);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画板
        g.fillRect(0, 0, 1000, 750);
        //画坦克
        drawTank(hero.getX(), hero.getY(), g, 3, 0);
    }

    /**
     * @param x      坦克左上角x坐标
     * @param y      坦克左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    //画坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据类型，设置不同颜色
        switch (type) {
            case 0://我的坦克
                g.setColor(Color.pink);
                break;
            case 1://敌人的坦克
                g.setColor(Color.cyan);
                break;
        }
        //根据方向画坦克
        switch (direct) {
            case 0://上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 19, y, 2, 20, false);
                break;
            case 1://右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.fill3DRect(x + 40, y + 19, 20, 2, false);
                break;
            case 2://下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.fill3DRect(x + 19, y + 20, 2, 20, false);
                break;
            case 3://左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.fill3DRect(x, y + 19, 20, 2, false);
                break;
            default:
                System.out.println("未作处理");
        }

    }
}
