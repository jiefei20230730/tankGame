package com.example.tankegame.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author wza
 * @version 1.0.0
 */
public class DrawCircle extends JFrame {

    //定义一个面板
    private MyPanel mp = null;

    public DrawCircle() {
        //初始化面板
        MyPanel mp = new MyPanel();
        //把面板放入到窗口（画框）
        this.add(mp);
        this.setSize(900, 600);
        this.repaint();
        this.setVisible(true);
        //点击窗口的×退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new DrawCircle();
    }
}


class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.CYAN);
//        g.fillRect(20,20,10,60);
//        g.fillRect(50,20,10,60);
//        g.fillRect(30,30,20,40);
//        g.fillOval(30,40,10,10);
//        g.fillRect(39,20,2,20);

        //画一个圆
//        g.drawOval(10, 10, 100, 100);
//        //填充圆
//        g.setColor(Color.blue);
//        g.fillOval(100, 100, 100, 100);
        //画图片
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/image/image1.jpg"));
//        g.drawImage(image, 10, 10, 690, 690, this);
        //画字符串
        //给画笔设置颜色和字体
//        g.setColor(Color.pink);
//        g.setFont(new Font("隶书",Font.BOLD,50));
//        g.drawString("北京你好",100,100);//这里的是北京你好的左下角开始100，100

    }
}
