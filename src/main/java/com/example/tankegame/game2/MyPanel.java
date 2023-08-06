package com.example.tankegame.game2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    Vector<Enemy> enemyVector = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        //初始化我的坦克
        this.hero = new Hero(0, 0);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 40);
            enemy.setDirect(2);
            enemyVector.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画板
        g.fillRect(0, 0, 1000, 750);
        //画坦克
        System.out.println("执行了画坦克");
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getColor());
        for (Enemy enemy : enemyVector) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), enemy.getColor());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {//监听键盘按键
        System.out.println("按下" + (char) e.getKeyCode());
        //根据用户按下的不同键，来处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.moveRight();
        } else {
            System.out.println("监听到无法处理的键盘按键：" + e.getKeyChar());
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

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
        //根据方向画坦克，改变方向以坦克中心为中心重新绘画
        switch (direct) {
            case 0://上
                g.fill3DRect(x - 20, y - 30, 10, 60, false);
                g.fill3DRect(x + 10, y - 30, 10, 60, false);
                g.fill3DRect(x - 10, y - 20, 20, 40, false);
                g.fillOval(x - 10, y - 10, 20, 20);
                g.fill3DRect(x - 1, y - 30, 2, 20, false);
                break;
            case 1://右
                g.fill3DRect(x - 30, y - 20, 60, 10, false);
                g.fill3DRect(x - 30, y + 10, 60, 10, false);
                g.fill3DRect(x - 20, y - 10, 40, 20, false);
                g.fillOval(x - 10, y - 10, 20, 20);
                g.fill3DRect(x + 10, y - 1, 20, 2, false);
                break;
            case 2://下
                g.fill3DRect(x - 20, y - 30, 10, 60, false);
                g.fill3DRect(x + 10, y - 30, 10, 60, false);
                g.fill3DRect(x - 10, y - 20, 20, 40, false);
                g.fillOval(x - 10, y - 10, 20, 20);
                g.fill3DRect(x - 1, y + 10, 2, 20, false);
                break;
            case 3://左
                g.fill3DRect(x - 30, y - 20, 60, 10, false);
                g.fill3DRect(x - 30, y + 10, 60, 10, false);
                g.fill3DRect(x - 20, y - 10, 40, 20, false);
                g.fillOval(x - 10, y - 10, 20, 20);
                g.fill3DRect(x - 30, y - 1, 20, 2, false);
                break;
            default:
                System.out.println("未作处理");
        }
    }

}
