package main.battle;

import main.player.Player;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.ArrayList;

public class BattleAttack {
    private final boolean success;
    private final ArrayList<String> events = new ArrayList<String>();
    public BattleAttack(Player player){
        //check for no battle(check for error)
        Battle battle = player.getBattle();
        if (battle == null) {
            this.success = false;
            return;
        }
        String enemyDescription = battle.getEnemy().getDescription();
        battle.AllyAttack();
        this.events.add(String.format("You attack %s",enemyDescription));
        if (!battle.getEnemy().isAlive()){
            this.events.add(String.format("%s dies",enemyDescription));
            player.getBattlePlayer().reset();
            player.setBattle(null);
        }
        if (battle.getEnemy().isAlive()) {
            battle.EnemyAttack();
            this.events.add(String.format("%s attacks you",enemyDescription));
        }
        if (!battle.getPlayer().isAlive()){
            this.events.add("You die");
            player.getBattlePlayer().reset();
            player.setBattle(null);
        }
        int playerHp = Math.max(0,battle.getPlayer().getHp());
        int enemyHp = Math.max(0,battle.getEnemy().getHp());
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public ArrayList<String> getEvents() {
        return events;
    }
}
