package com.daniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAgainPanel extends JPanel implements ActionListener{

    JButton yesButton, noButton;

    PlayAgainPanel(){
        this.setPreferredSize(new Dimension(720,720));
        this.setBackground(new Color(0x123456));
        this.setBorder(BorderFactory.createLineBorder(new Color(0x012340),5,true));
        this.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setText("Would you like");
        label1.setFont(new Font("MV Boli", Font.BOLD, 60));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setForeground(Color.black);
        label1.setBounds(50,80,620,100);
//        label1.setBorder(BorderFactory.createLineBorder(Color.yellow));

        JLabel label2 = new JLabel();
        label2.setText("to play again?");
        label2.setFont(new Font("MV Boli", Font.BOLD, 60));
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setForeground(Color.black);
        label2.setBounds(50,180,620,100);
//        label2.setBorder(BorderFactory.createLineBorder(Color.yellow));


        yesButton = new JButton();
        noButton = new JButton();

        yesButton.setText("Yes");
        noButton.setText("No");

        yesButton.setBounds(150,400,150,150);
        noButton.setBounds(420,400,150,150);

        yesButton.setContentAreaFilled(false);
        noButton.setContentAreaFilled(false);

        yesButton.setFocusable(false);
        noButton.setFocusable(false);

        yesButton.setBorderPainted(false);
        noButton.setBorderPainted(false);

        yesButton.setFont(new Font("MV Boli", Font.BOLD, 65));
        noButton.setFont(new Font("MV Boli", Font.BOLD, 65));

        yesButton.setForeground(Color.green);
        noButton.setForeground(Color.red);

        yesButton.addActionListener(this);
        noButton.addActionListener(this);

        this.add(label1);
        this.add(label2);
        this.add(yesButton);
        this.add(noButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==yesButton){
            System.out.println("I wanna play again");
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
            Main.playAgain = 'Y';
        }
        if (e.getSource()==noButton){
            System.out.println("I don't wanna play again");
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
            Main.playAgain = 'N';
        }
    }
}
