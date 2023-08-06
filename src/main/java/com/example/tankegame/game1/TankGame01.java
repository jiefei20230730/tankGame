package com.example.tankegame.game1;

import javax.swing.*;
import java.awt.*;

/**
 * @author wza
 * @version 1.0.0
 */
public class TankGame01 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public TankGame01() {
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TankGame01();
    }
}
