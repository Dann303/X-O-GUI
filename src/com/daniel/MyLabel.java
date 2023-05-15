package com.daniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyLabel extends JLabel implements MouseListener{

    public static ImageIcon dashIcon = new ImageIcon("dash.png");
    public static ImageIcon XIcon = new ImageIcon("letterX.png");
    public static ImageIcon OIcon = new ImageIcon("letterO.png");



    int id;
    static int nextId = 0;
    static MyLabel[] items = new MyLabel[9];

    MyLabel(){
        this.setPreferredSize(new Dimension(150,150));
        this.id = nextId++;
        items[this.id] = this;
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.addMouseListener(this);
    }

    public boolean equals(MyLabel label){
        if (this.id==label.id)
            return true;
        else
            return false;
    }

    public static int indexOf(MyLabel label){
        for (int i=0; i<9; i++){
            if (MyLabel.items[i].equals(label))
                return i;
        }
        return -1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Main.cellChosen = ((MyLabel)e.getSource()).id;
        Main.chose = true;
        System.out.println("chose");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
