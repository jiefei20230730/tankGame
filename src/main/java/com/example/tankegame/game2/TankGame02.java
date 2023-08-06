package com.example.tankegame.game2;

import javax.swing.*;

/**
 * @author wza
 * @version 1.0.0
 */
public class TankGame02 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public TankGame02() {
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

    public static void main(String[] args) {
        new TankGame02();
    }
}
