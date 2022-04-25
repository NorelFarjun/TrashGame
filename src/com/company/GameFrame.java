package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameFrame extends JFrame implements KeyListener {
    private Bin player;
    private Background background;
    private JLabel scoreBar;
    private int score;
    private Repo repo = new Repo();

    public GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(repo.GAME_SIZE_X,repo.GAME_SIZE_Y+repo.DEFAULT_SCORE_BAR_HEIGTH);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setTitle("Trash Game");
        score=0;
        player = new Bin(repo.DEFAULT_POSITION_X,repo.DEFAULT_POSITION_y,repo.DEFAULT_PLAYER_WIDTH,repo.DEFAULT_PLAYER_HEIGHT,repo.DEFAULT_SPEED);
        background = new Background(player,repo.GAME_SIZE_X,repo.GAME_SIZE_Y, this);
        this.add(background);
        scoreBar = new JLabel("Score: "+String.valueOf(score));
        scoreBar.setBounds(0,repo.GAME_BOUNDS_Y,repo.GAME_BOUNDS_X,repo.DEFAULT_SCORE_BAR_HEIGTH);
        scoreBar.setBackground(Color.lightGray);
        scoreBar.setOpaque(true);
        this.add(scoreBar);
        this.setVisible(true);
    }

    public void upDateScore(int newScore){
        score = newScore;
        scoreBar.setText("Score: "+String.valueOf(score));
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