package main.housing;

import main.player.Player;

public class House {
    private Player owner;
    private int x; //bottom left x coordinate
    private int y; //bottom left y coordinate
    private int width;
    private int height;
    public House(Player owner, int x, int y, int width, int height){
        this.owner = owner;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getOwner() {
        return owner;
    }
}
