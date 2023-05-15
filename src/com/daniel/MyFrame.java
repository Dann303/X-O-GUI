package com.daniel;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    MyLayeredPane layeredPane;
    MyPanel panel1;
    PlayAgainPanel panel2;
    ViewScorePanel panel3;
    static int frameWidth, frameHeight;

    MyFrame(){

        getFrameDimensions();
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        intro();
    }

    void getFrameDimensions(){
        this.setLayout(new FlowLayout());
        panel1 = new MyPanel();
        this.add(panel1);
        this.pack();
        frameWidth = this.getWidth();
        frameHeight = this.getHeight();
        this.remove(panel1);
    }

    void intro(){
        this.setLayout(null);

        layeredPane = new MyLayeredPane();
        layeredPane.setBounds(0,0,MyFrame.frameWidth,MyFrame.frameHeight);
        this.add(layeredPane);
        this.setVisible(true);
    }

    void play(){
        this.setLayout(new FlowLayout());
        this.add(panel1);
        if (panel2!=null) {
            this.remove(panel2);
            panel2.setVisible(false);
            panel1.setVisible(true);
        }else{
            layeredPane.setVisible(false);
            this.remove(layeredPane);
        }
//        Main.play(); //freezes everything... nvm it worked.. just dont invoke el method hena
    }

    public void playAgain(){
       panel2 = new PlayAgainPanel();

//       panel1.setVisible(false);
       this.add(panel2);
       this.remove(panel1);
    }

    public void viewScorePanel(){
        panel3 = new ViewScorePanel(Main.score1, Main.score2);

        this.add(panel3);
        this.remove(panel2);
    }

}
