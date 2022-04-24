package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Background extends JLabel{

    ArrayList<TrashBag> bags;
    Bin player;
    boolean gameOver;
    int score;

    Random random = new Random();

    public Background(Bin player, int x, int y){
        this.setSize(x,y);
        this.setBackground(new java.awt.Color(200,210,230));
        this.setOpaque(true);
        this.player=player;
        bags = new ArrayList<TrashBag>();
        this.add(player);
        this.gameOver=false;
        this.score=0;
        this.initList();
        moveCoins();
    }

    private void moveCoins() {
        new Thread(() -> {
            while (true){
                for(TrashBag bag : bags){
                    bag.move();
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void keyTyped(char key){
        if(!gameOver){
            player.keyPressed(Character.toLowerCase(key));
        }
    }
    public void removeOrder(char key){
        if(!gameOver){
            player.removeOrder(Character.toLowerCase(key));
        }
    }

    private void CheckCollision(TrashBag bag){
        if(player.intersects(bag)){
            this.remove(bag);
            score++;
        }
    }
    private void initList (){
        // Start with between 3 and 10 garbage bags
        for(int i = 0; i<random.nextInt(8)+3; i++){
            //Each garbage bag gets a random position on the x-axis and a random speed between 4 and 8
            TrashBag bag = new TrashBag(random.nextInt(584),-50,random.nextInt(4)+4);
            bags.add(bag);
            this.add(bag);
        }
    }
}



