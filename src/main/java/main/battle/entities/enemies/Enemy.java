package main.battle.entities.enemies;

import main.battle.entities.Entity;

public class Enemy extends Entity {
    protected String description = "an enemy";
    protected String name = "Enemy";
    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }
    public void doAction(){

    }
}
