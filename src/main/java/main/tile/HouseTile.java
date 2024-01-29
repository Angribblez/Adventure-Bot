package main.tile;

import main.housing.House;

import java.awt.*;

public class HouseTile extends Tile {
    private House attachedHouse;
    public HouseTile(int x, int y, House house){
        this.locationX = x;
        this.locationY = y;
        this.attachedHouse = house;
        this.tileColor = new Color(200,108,76);
    }

    public House getHouse() {
        return attachedHouse;
    }
}
