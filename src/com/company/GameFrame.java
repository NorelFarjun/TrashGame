package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameFrame extends JFrame implements KeyListener {
    private final Background background;
    private final JLabel scoreBar;
    private int score;

    public GameFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Repo.GAME_SIZE_X,Repo.GAME_SIZE_Y + Repo.DEFAULT_SCORE_BAR_HEIGTH);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setTitle("Trash Game");

        scoreBar = new JLabel("Score: " + score);
        scoreBar.setBounds(0,Repo.GAME_BOUNDS_Y, Repo.GAME_BOUNDS_X, Repo.DEFAULT_SCORE_BAR_HEIGTH);
        scoreBar.setBackground(Color.lightGray);
        scoreBar.setOpaque(true);
        this.add(scoreBar);


        background = new Background(Repo.GAME_SIZE_X, Repo.GAME_SIZE_Y, this);
        this.add(background);
        this.setVisible(true);
    }

    public void addScore(){
        score++;
        scoreBar.setText("Score: " + score);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        background.keyPressed(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

        background.removeOrder(e.getKeyChar());
    }
}