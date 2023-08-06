package com.example.tankegame.game4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    private int width;
    private int height;
    //定义我的坦克
    Hero hero = null;
    Vector<Enemy> enemyVector = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel(int width, int height) {
        this.width = width;
        this.height = height;

        //初始化我的坦克
        this.hero = new Hero(0, 0);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {//todo 写死生成的敌方坦克
            Enemy enemy = new Enemy(100 * (i + 1), 40);
            enemy.setDirect(2);
            if (i == 2) {
                enemy.setDirect(3);
            }
            enemyVector.add(enemy);
            enemy.shot(width, height);//每个敌方坦克射击一下
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画板
        g.fillRect(0, 0, width, height);
        System.out.println("执行了画坦克");
        //画我的坦克和子弹
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getColor());
        for (Shot shot : hero.getShotVector()) {
            System.out.println("当前子弹数量：" + hero.getShotVector().size());
            //判断当前子弹是否击中敌方，击中的话当前子弹和敌方坦克一起消失
            if (shot.isLive()) {
                drawBullet(shot, g, hero.getColor());
                hitTank(shot);
            }
        }

        //画敌方坦克和子弹
        Iterator<Enemy> enemyIterator = enemyVector.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), enemy.getColor());

            Iterator<Shot> iterator = enemy.getShotVector().iterator();
            while (iterator.hasNext()) {
                Shot shot = iterator.next();
                if (shot.isLive()) {
                    drawBullet(shot, g, enemy.getColor());
                } else {
                    iterator.remove();
                }
            }
        }
    }

    /*子弹中心（比如子弹范围0,0-2,2  则中心为0,1）*/
    private void drawBullet(Shot shot, Graphics g, int type) {
        System.out.println("当前子弹：" + shot.toString());
        //根据类型，设置不同颜色
        switch (type) {
            case 0://我的坦克
                g.setColor(Color.pink);
                break;
            case 1://敌人的坦克
                g.setColor(Color.cyan);
                break;
            default:
                throw new RuntimeException("无法判断坦克类型");
        }
        g.fill3DRect(shot.getX() - 1, shot.getY(), 2, 2, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {//监听键盘按键
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

        //J发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shot(width, height);
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
            default:
                System.out.println("无法根据坦克类型判断颜色");
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

    private void hitTank(Shot shot) {

        Iterator<Enemy> iterator = enemyVector.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            if (innerTank(shot, enemy)) {
                iterator.remove();
                shot.setLive(false);
            }
        }
    }

    private boolean innerTank(Shot shot, Enemy enemy) {
        //子弹中心（shot.getX()，shot.getY()+1）在坦克边界就算击中
        switch (enemy.getDirect()) {
            case 0:
            case 2:
                if (shot.getX() >= enemy.getX() - 20 && shot.getX() <= enemy.getX() + 20 && shot.getY() + 1 >= enemy.getY() - 30 && shot.getY() + 1 <= enemy.getY() + 30) {
                    return true;
                }
                break;
            case 1:
            case 3:
                if (shot.getX() >= enemy.getX() - 30 && shot.getX() <= enemy.getX() + 30 && shot.getY() + 1 >= enemy.getY() - 20 && shot.getY() + 1 <= enemy.getY() + 20) {
                    return true;
                }
                break;
            default:

        }
        return false;
    }
}
