package main.battle.entities.allies;

import main.player.Player;

public class BattlePlayer extends Ally{
    protected String description;
    protected String name;
    public BattlePlayer(String name){
        this.name = name;
        this.description = name;
    }
    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }
}
