package com.example.tankegame.game5;

import com.example.tankegame.game5.util.TankUtils;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author wza
 * @version 1.0.0
 */
public class Enemy extends Tank implements Serializable, Runnable {
    public static final Long serialVersionUID = 1L;
    public final int color = 1;
    //增加成员，获取敌人坦克集合
    Vector<Enemy> enemyVector = new Vector<>();

    public Enemy(int x, int y) {
        super(x, y);
    }

    public int getColor() {
        return color;
    }

    public Vector<Enemy> getEnemyVector() {
        return enemyVector;
    }

    public void setEnemyVector(Vector<Enemy> enemyVector) {
        this.enemyVector = enemyVector;
    }

    //判断当前坦克是否和enemyVector的其他坦克碰撞
    public boolean isTouchEnemyVector() {
        switch (getDirect()) {
            case 0://上
                for (Enemy enemy : enemyVector) {
                    if (enemy != this) {
                        //当前坦克左上 右上是否与其他坦克enemy碰撞
                        boolean isInnerTank1 = TankUtils.isInnerTank(this.getX() - 20, this.getY() - 30, enemy);
                        boolean isInnerTank2 = TankUtils.isInnerTank(this.getX() + 20, this.getY() - 30, enemy);
                        if (isInnerTank1 || isInnerTank2) {
                            return true;
                        }
                    }
                }
                break;
            case 1://右
                for (Enemy enemy : enemyVector) {
                    if (enemy != this) {
                        //当前坦克右上 右下是否与其他坦克enemy碰撞
                        boolean isInnerTank2 = TankUtils.isInnerTank(this.getX() + 30, this.getY() - 20, enemy);
                        boolean isInnerTank1 = TankUtils.isInnerTank(this.getX() + 30, this.getY() + 20, enemy);
                        if (isInnerTank1 || isInnerTank2) {
                            return true;
                        }
                    }
                }
                break;
            case 2://下
                for (Enemy enemy : enemyVector) {
                    if (enemy != this) {
                        //当前坦克左上 右上是否与其他坦克enemy碰撞
                        boolean isInnerTank1 = TankUtils.isInnerTank(this.getX() - 20, this.getY() + 30, enemy);
                        boolean isInnerTank2 = TankUtils.isInnerTank(this.getX() + 20, this.getY() + 30, enemy);
                        if (isInnerTank1 || isInnerTank2) {
                            return true;
                        }
                    }
                }
                break;
            case 3://左
                for (Enemy enemy : enemyVector) {
                    if (enemy != this) {
                        //当前坦克左上 右上是否与其他坦克enemy碰撞
                        boolean isInnerTank2 = TankUtils.isInnerTank(this.getX() - 30, this.getY() - 20, enemy);
                        boolean isInnerTank1 = TankUtils.isInnerTank(this.getX() - 30, this.getY() + 20, enemy);
                        if (isInnerTank1 || isInnerTank2) {
                            return true;
                        }
                    }
                }
                break;
            default:
                System.out.println("当前坦克方向错误：" + getDirect());
        }

        return false;
    }


    @Override
    public void run() {
        while (isLive()) {
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 20; i++) {
                        if (isTouchEnemyVector()) {
                            break;
                        }
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
                        if (isTouchEnemyVector()) {
                            break;
                        }
                        if (getX() + 30 < MyPanel.width) {
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
                        if (isTouchEnemyVector()) {
                            break;
                        }
                        if (getY() + 30 < MyPanel.height) {
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
                        if (isTouchEnemyVector()) {
                            break;
                        }
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
            this.shot();
        }
    }
}
