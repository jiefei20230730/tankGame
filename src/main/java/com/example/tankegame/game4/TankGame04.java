package com.example.tankegame.game4;

import javax.swing.*;

/**
 * @author wza
 * @version 1.0.0
 */
public class TankGame04 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public TankGame04() {
        mp=new MyPanel(1000,750);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

    public static void main(String[] args) {
        new TankGame04();
    }
}
