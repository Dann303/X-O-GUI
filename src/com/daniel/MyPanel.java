package com.daniel;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    MyPanel(){
        this.setPreferredSize(new Dimension(720,720));
        this.setBackground(new Color(0x123456));
        this.setBorder(BorderFactory.createLineBorder(new Color(0x012340),5,true));
        this.setLayout(new GridLayout(3,3,5,5));

        createLabels();

    }

    public void createLabels(){
        for (int i = 0; i < 9; i++){
            this.add(new MyLabel());
        }
    }

    public void paint(Graphics g){

        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(5));
        g2D.setPaint(Color.black);
        g2D.drawLine(240,0,240,720);
        g2D.drawLine(480,0,480,720);
        g2D.drawLine(0,240,720,240);
        g2D.drawLine(0,480,720,480);


    }
}
