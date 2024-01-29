package main.action.movement;

import main.player.Player;

public class North {
    public North(Player player, Integer magnitude){
        player.move(0, magnitude);
    }
}