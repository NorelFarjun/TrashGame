package com.company;
import javax.swing.*;

public class TrashBag extends JLabel {
    int speed;

    public TrashBag(int x, int y, int speed){
        this.speed = speed;
        this.setBounds(x,y,Repo.DEFAULT_BAGS_WIDTH,Repo.DEFAULT_BAGS_HEIGHT);
        this.setIcon(new ImageIcon("finalBag_trueSize.png"));
    }

    public void move(){
        this.setLocation(this.getX(), this.getY()+speed);
    }
}
