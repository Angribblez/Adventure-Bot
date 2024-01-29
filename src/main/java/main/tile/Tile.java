package main.tile;

import java.awt.*;

public class Tile {
    protected int locationX;
    protected int locationY;
    protected Color tileColor = new Color(255,255,255);

    public int getLocationX() {
        return this.locationX;
    }
    public int getLocationY() {
        return this.locationY;
    }

    public Color getTileColor() {
        return this.tileColor;
    }
}
