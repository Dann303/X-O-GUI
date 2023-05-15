package com.daniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLayeredPane extends JLayeredPane implements ActionListener{

    JLabel page1, page2;
    ImageIcon image;
    JButton startButton, playButton;
    JLabel bg = new JLabel();
    JTextField player1, player2;
    TextLabel errorMessage;

    MyLayeredPane(){

        page1 = new JLabel();
        page1.setBounds(0,0,MyFrame.frameWidth,MyFrame.frameHeight);

        image = new ImageIcon("galaxy.png");

        bg.setBounds(0,0,MyFrame.frameWidth,MyFrame.frameHeight);
        bg.setIcon(image);
        bg.setBorder(BorderFactory.createLineBorder(Color.black,1));

        this.add(bg,Integer.valueOf(1));
        Page1();

    }

    void Page1(){

        startButton = new JButton();
        startButton.setContentAreaFilled(false);
        startButton.setFocusable(false);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.addActionListener(this);

        TextLabel box1 = new TextLabel();
        box1.setBounds(70,100,580,150);
        box1.setText("Welcome to my game! :)");

        TextLabel box2 = new TextLabel();
        box2.setBounds(70,400,580,150);
        box2.setText("Press any key to start...");

        TextLabel box3 = new TextLabel();
        box3.setForeground(new Color(0xF2BA28));
        box3.setFont(new Font("MV Boli", Font.BOLD, 55));
        box3.setBounds(270,520,180,50);
        box3.setText("Start");
        box3.setLayout(new BorderLayout());
        box3.add(startButton,BorderLayout.CENTER);

        page1.add(box1);
        page1.add(box2);
        page1.add(box3);

        this.add(page1,Integer.valueOf(2));

    }

    void Page2(){
        this.remove(page1);

        page2 = new JLabel();
        page2.setBounds(0,0,MyFrame.frameWidth,MyFrame.frameHeight);

        playButton = new JButton();
        playButton.setContentAreaFilled(false);
        playButton.setFocusable(false);
        playButton.setBorder(BorderFactory.createEmptyBorder());
        playButton.addActionListener(this);

        player1 = new JTextField();
        player1.setSize(500, 70);
//        player1.setText("Enter name here: ");
        player1.setOpaque(false);
        player1.setBorder(BorderFactory.createEmptyBorder());
        player1.setFont(new Font("MV Boli", Font.BOLD, 35));
        player1.setForeground(new Color(0x80C2C2));
        player1.setBounds(90,180,580,50);
        player1.setCaretColor(Color.WHITE);
        new GhostText(player1, "Enter name here: ");

        TextLabel box1 = new TextLabel();
        box1.setBounds(70,130,580,50);
        box1.setText("Player 1's name: ");
        box1.setHorizontalAlignment(JLabel.LEFT);



        player2 = new JTextField();
        player2.setSize(500, 70);
//        player2.setText("Enter name here: ");
        player2.setOpaque(false);
        player2.setBorder(BorderFactory.createEmptyBorder());
        player2.setFont(new Font("MV Boli", Font.BOLD, 35));
        player2.setForeground(new Color(0x80C2C2));
        player2.setBounds(90,330,580,50);
        player2.setCaretColor(Color.WHITE);
        new GhostText(player2, "Enter name here: ");


        TextLabel box2 = new TextLabel();
        box2.setBounds(70,280,580,50);
        box2.setText("Player 2's name: ");
        box2.setHorizontalAlignment(JLabel.LEFT);


        TextLabel box3 = new TextLabel();
        box3.setBounds(300,460,120,100);
        box3.setForeground(new Color(0x89A5BC));
        box3.setFont(new Font("MV Boli", Font.BOLD, 55));
        box3.setText("Play");
        box3.setLayout(new BorderLayout());
        box3.add(playButton, BorderLayout.CENTER);

        errorMessage = new TextLabel();
        errorMessage.setBounds(20, 50, 680, 50);
        errorMessage.setForeground(new Color(0xF56A73));
        errorMessage.setText("* Please enter names for each player!");
        errorMessage.setFont(new Font("MV Boli", Font.BOLD, 31));

        page2.add(box1);
        page2.add(player1);
        page2.add(box2);
        page2.add(player2);
        page2.add(box3);
        page2.add(errorMessage);

        errorMessage.setVisible(false);

        this.add(page2,Integer.valueOf(2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startButton) {
            Page2();
            this.repaint();
        }else if (e.getSource()==playButton) {
            System.out.println("Hi");
            if ((player1.getText().equals("Enter name here: ") || player2.getText().equals("Enter name here: "))){
                errorMessage.setVisible(true);
                System.out.println("hey");
            }else{
                errorMessage.setVisible(false);
                Main.player1 = player1.getText();
                Main.player2 = player2.getText();
                Main.gameStart();
            }
        }
    }
}
