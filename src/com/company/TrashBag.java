package com.company;

import javax.swing.*;
import java.awt.*;

public class TrashBag extends JLabel {
    int speed;
    Repo repo;
    public TrashBag(int x, int y, int speed){
        this.speed = speed;
        repo = new Repo();
        this.setBounds(x,y,repo.DEFAULT_BAGS_WIDTH,repo.DEFAULT_BAGS_HEIGHT);
        this.setIcon(new ImageIcon("finalBag_trueSize.png"));
    }

    public boolean move(){
        this.setLocation(this.getX(), this.getY()+speed);
        if (this.getY() > 600){
            return false;
        }
        return true;
    }
}
