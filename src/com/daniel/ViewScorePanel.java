package com.daniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewScorePanel extends JPanel implements ActionListener{

    JButton exit;

    ViewScorePanel(int player1, int player2){

        this.setPreferredSize(new Dimension(720,720));
        this.setBackground(new Color(0x123456));
        this.setBorder(BorderFactory.createLineBorder(new Color(0x012340),5,true));
        this.setLayout(null);

        JLabel label1 = new JLabel("The Score: ");
        label1.setFont(new Font("MV Boli", Font.BOLD, 70));
        label1.setBounds(50,30,620,150);

        JLabel label2 = new JLabel(Main.player1); //player1 name
        label2.setFont(new Font("MV Boli", Font.BOLD, 50));
        label2.setBounds(50,180,310,100);

        JLabel label3 = new JLabel(Main.player2); //player2 name
        label3.setFont(new Font("MV Boli", Font.BOLD, 50));
        label3.setBounds(360,180,310,100);

        JLabel label4 = new JLabel(String.valueOf(player1)); //player1 score
        label4.setFont(new Font("MV Boli", Font.BOLD, 80));
        label4.setBounds(80,300,250,100);

        JLabel label5 = new JLabel(String.valueOf(player2)); //player 2 score
        label5.setFont(new Font("MV Boli", Font.BOLD, 80));
        label5.setBounds(390,300,250,100);

        JLabel label6 = new JLabel(":"); //the ":" columns
        label6.setFont(new Font("MV Boli", Font.BOLD, 100));
        label6.setBounds(330,300,60,100);

        JLabel label7 = new JLabel("Thanks for playing my game!"); //comment part 1
        label7.setFont(new Font("MV Boli", Font.BOLD, 35));
        label7.setBounds(50,430,620,50);

        JLabel label8 = new JLabel("If you know me please lmk how"); //comment part 2
        label8.setFont(new Font("MV Boli", Font.BOLD, 35));
        label8.setBounds(50,480,620,50);

        JLabel label9 = new JLabel("you think of my first game :)"); //comment part 3
        label9.setFont(new Font("MV Boli", Font.BOLD, 35));
        label9.setBounds(50,530,620,50);

        exit = new JButton("Press here to exit ..."); //comment part 3
        exit.setFont(new Font("MV Boli", Font.ITALIC | Font.BOLD, 30));
        exit.setBounds(50,600,620,50);
        exit.setForeground(Color.LIGHT_GRAY);
        exit.addActionListener(this);

        prepareLabel(label1);
        prepareLabel(label2);
        prepareLabel(label3);
        prepareLabel(label4);
        prepareLabel(label5);
        prepareLabel(label6);
        prepareLabel(label7);
        prepareLabel(label8);
        prepareLabel(label9);
        prepareButton(exit);


        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(exit);
    }


    void prepareLabel(JLabel label){
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.BLACK);
//        label.setBorder(BorderFactory.createLineBorder(Color.yellow));
    }

    private void prepareButton(JButton button) {
        button.setHorizontalAlignment(JLabel.CENTER);
        button.setVerticalAlignment(JLabel.CENTER);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
//        button.setBorder(BorderFactory.createLineBorder(Color.yellow));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit)
            System.exit(0);
    }
}
