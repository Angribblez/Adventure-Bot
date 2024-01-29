package main.action.movement;

import main.player.Player;

public class South {
    public South(Player player, Integer magnitude){
        player.move(0, -magnitude);
    }
}
