package com.company;

public class Repo {
    public final int GAME_SIZE_X = 600;
    public final int GAME_SIZE_Y = 600;
    public final int DEFAULT_PLAYER_WIDTH = 50;
    public final int DEFAULT_PLAYER_HEIGHT = 50;
    public final int DEFAULT_SPEED = 10;
    public final int DEFAULT_SCORE_BAR_HEIGTH = 30;
    public final int DEFAULT_POSITION_X = ((GAME_SIZE_X-16)/2)-(DEFAULT_PLAYER_WIDTH/2);
    public final int DEFAULT_POSITION_y = GAME_SIZE_Y-(2*DEFAULT_PLAYER_HEIGHT);
    public final int GAME_BOUNDS_Y = GAME_SIZE_Y-39;
    public final int GAME_BOUNDS_X = GAME_SIZE_X-16;
}