package com.example.tankegame.event_;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author wza
 * @version 1.0.0
 */
public class BallMove extends JFrame {
    MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }
}

//画板，可以画出小球
//KeyListener是监听器，监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    private int x = 10;
    private int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    //有字符输出时，该方法会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下" + (char) e.getKeyCode());
        //根据用户按下的不同键，来处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        } else {

        }

        this.repaint();
    }

    //当某个键松开，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
