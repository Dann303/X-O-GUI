package com.daniel;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel{

    TextLabel(){
        this.setFont(new Font("MV Boli", Font.BOLD, 45));
        this.setForeground(new Color(0xF2CA28));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
//        box.setBackground(Color.red);
//        box.setOpaque(true);

    }
}
