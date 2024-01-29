package main.action.movement;

import main.player.Player;

import java.util.Random;

public class East {
    public East(Player player, Integer magnitude){
        player.move(magnitude, 0);
    }
}
