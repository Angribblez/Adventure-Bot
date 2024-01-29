package main.action.movement;

import main.player.Player;

public class West {
    public West(Player player, Integer magnitude){
        player.move(-magnitude, 0);
    }
}
