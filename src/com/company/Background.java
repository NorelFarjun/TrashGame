package com.company;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Background extends JLabel{


    private final Bin player;
    private final GameFrame myFrame;
    private final Repo repo;
    private boolean gameRuning;


    Random random = new Random();

    public Background(Bin player, int x, int y, GameFrame myFrame){
        repo = new Repo();

        this.myFrame = myFrame;
        this.setSize(x,y);
        this.player=player;
        this.add(player);
        this.gameRuning=true;
        moveTrashBags();
    }

    private void moveTrashBags() {
        ArrayList<TrashBag> bags = new ArrayList<>();
        this.initList(bags);
        new Thread(() -> {
            while (true){
                for(TrashBag bag : bags){
                    if(gameRuning){
                        bag.move();
                        if(CheckCollision(bag)){
                            myFrame.addScore();
                            repositionTrashBag(bag);
                        }
                        else if(CheckIfoUtsideFieldBoundary(bag)){
                            repositionTrashBag(bag);
                        }
                    }
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void keyPressed(char key){
        if(gameRuning){
            player.keyPressed(Character.toLowerCase(key));
        }
    }
    public void removeOrder(char key){
        if(gameRuning){
            player.removeOrder(Character.toLowerCase(key));
        }
    }

    private boolean CheckCollision(TrashBag bag){
        if(player.intersects(bag)){
            return true;
        }
        return false;
    }
    private boolean CheckIfoUtsideFieldBoundary(TrashBag bag){
        if(bag.getY()>repo.GAME_SIZE_Y+repo.DEFAULT_PLAYER_HEIGHT){
            return true;
        }
        return false;
    }
    private void initList (ArrayList<TrashBag> bags){
        // Start with between 5 and 12 garbage bags
        for(int i = 0; i<random.nextInt(8)+5; i++){
            addTrashBagToList(bags);
        }
    }

    private void addTrashBagToList(ArrayList<TrashBag> bags){
        //Each garbage bag gets a random position on the x-axis and a random speed between 6 and 10
        TrashBag bag = new TrashBag(random.nextInt(repo.GAME_BOUNDS_X-repo.DEFAULT_BAGS_WIDTH),(random.nextInt(repo.GAME_SIZE_Y)+100)*(-1),random.nextInt(6)+4);
        bags.add(bag);
        this.add(bag);
    }
    private void repositionTrashBag(TrashBag bag){
        bag.setLocation(random.nextInt(repo.GAME_SIZE_X - repo.DEFAULT_BAGS_WIDTH),(random.nextInt(repo.GAME_SIZE_Y)+100)*(-1));
    }

}



