package com.example.tankegame.game5;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author wza
 * @version 1.0.0
 */
public class TankGame05 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public TankGame05() {
        mp = new MyPanel(2100, 1360);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(2580, 1360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("触发关闭事件，保存游戏");
                mp.saveRecordInfo();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new TankGame05();
    }
}
