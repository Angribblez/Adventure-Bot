package main;

import main.map.Map;
import main.player.Player;

import java.util.HashMap;

public class Globals {
    private static final String prefix = "rpg ";
    private static final Map map = new Map();
    private static final HashMap<String, Player> players = new HashMap<String, Player>();

    public static String getPrefix() {
        return prefix;
    }

    public static Map getMap() {
        return map;
    }

    public static HashMap<String, Player> getPlayers() {
        return players;
    }
}
