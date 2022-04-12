package com.company;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class GameFrame extends JFrame implements KeyListener {
    JLabel trashCan;
    GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setTitle("Trash Game");
        trashCan = new JLabel();
        trashCan.setBounds(20,650,100,100);
        trashCan.setBackground(Color.RED);
        trashCan.setOpaque(true);
        this.add(trashCan);
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case'a': trashCan.setLocation(trashCan.getX()-10,trashCan.getY());
                break;
            case'A': trashCan.setLocation(trashCan.getX()-10,trashCan.getY());
                break;
            case 'd': trashCan.setLocation(trashCan.getX()+10,trashCan.getY());
                break;
            case 'D': trashCan.setLocation(trashCan.getX()+10,trashCan.getY());
                break;
            default:
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
