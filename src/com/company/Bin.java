package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bin extends JLabel {
    Color color;
    int speed;
    int BORDER_X = 0;
    int BORDER_Y = 0;

    public Bin(int x, int y, int width, int height, int speed){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.red);
        this.setOpaque(true);
        this.speed=speed;
    }
    public void keyPressed(char key){
        switch (key){
            case 'a': {
                if(this.getX() - speed < 0){
                    this.setLocation(0, this.getY());
                }
                else setLocation(this.getX()-speed,this.getY());
            }
            break;
            case 'd': {
                if(this.getX()+this.getWidth()+speed > 584){
                    setLocation(BORDER_X-this.getWidth(),this.getY());
                }
                else setLocation(this.getX()+this.speed,this.getY());
            }
            break;
            case 'w': {
                if(this.getY()-speed < 0){
                    setLocation(this.getX(),0);
                }
                else setLocation(this.getX(),this.getY()-this.speed);
            }
            break;
            case 's': {
                if(this.getY()+this.getHeight()+speed > BORDER_Y){
                    setLocation(this.getX(),BORDER_Y-this.getHeight());
                }
                else setLocation(this.getX(),this.getY()+this.speed);
            }
            break;
            default:
        }
    }
    // copy of Shape.intersects
    public boolean intersects(JLabel r) {
        int tw = this.getWidth();
        int th = this.getHeight();
        int rw = r.getWidth();
        int rh = r.getHeight();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.getX();
        int ty = this.getY();
        int rx = r.getX();
        int ry = r.getY();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    public void adjustBoundariesToGameBoard(int width, int height){
        BORDER_X = width-16;
        BORDER_Y = height-39;
    }
}
