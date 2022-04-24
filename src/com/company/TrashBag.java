package com.company;

import javax.swing.*;
import java.awt.*;

public class TrashBag extends JLabel {
    int speed;
    public TrashBag(int x, int y, int speed){
        this.speed = speed;
        this.setBounds(x,y,20,20);
        this.setBackground(Color.BLUE);
        this.setOpaque(true);
    }

    public boolean move(){
        this.setLocation(this.getX(), this.getY()+speed);
        if (this.getY() > 600){
            return false;
        }
        return true;
    }
}
