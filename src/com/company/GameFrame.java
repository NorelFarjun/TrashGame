package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameFrame extends JFrame implements KeyListener {
    Bin player;
    JLabel background;
    boolean gameOver;
    int score;
    int GAME_SIZE_X = 600;
    int GAME_SIZE_Y = 600;
    int DEFAULT_WIDTH = 50;
    int DEFAULT_HEIGHT = 50;
    int DEFAULT_SPEED = 10;
    int DEFAULT_POSITION_X = ((GAME_SIZE_X-16)/2)-(DEFAULT_WIDTH/2);
    int DEFAULT_POSITION_y = GAME_SIZE_Y-(2*DEFAULT_HEIGHT);

    GameFrame(){
        this.score=0;
        this.gameOver=false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GAME_SIZE_X,GAME_SIZE_Y);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setTitle("Trash Game");
        player = new Bin(DEFAULT_POSITION_X,DEFAULT_POSITION_y,DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_SPEED);
        player.adjustBoundariesToGameBoard(600,600);
        this.background=new JLabel();
        this.background.setSize(600,600);
        this.background.setBackground(new java.awt.Color(200,210,230));
        this.background.add(player);
        this.background.setOpaque(true);
        this.add(background);
        this.setVisible(true);
    }

    public void checkCollision(){

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(!gameOver){
            player.keyPressed(Character.toLowerCase(e.getKeyChar()));
            checkCollision();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}