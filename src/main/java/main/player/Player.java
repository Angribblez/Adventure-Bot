package main.player;

import main.battle.Battle;
import main.battle.entities.allies.BattlePlayer;
import net.dv8tion.jda.api.entities.Message;

import java.util.Random;

public class Player {
    private int playerX = 0;
    private int playerY = 0;
    private Battle battle = null;
    private String playerName = "Player"; //max 6 chars
    private final BattlePlayer battlePlayer = new BattlePlayer(this.playerName);
    private Random randomInstance = new Random();
    private int stepsSinceBattle = 0;
    private int battleThreshold = randomInstance.nextInt(1,2); //9, 13
    public boolean shouldBattle(){
        return this.stepsSinceBattle == this.battleThreshold;
    }

    public int getPlayerX() {
        return this.playerX;
    }

    public int getPlayerY() {
        return this.playerY;
    }

    public void move(int x, int y){
        //move
        this.playerX += Math.min(x, 5);
        this.playerY += Math.min(y, 5);

        //increment battle and check for reset
        this.stepsSinceBattle += 1;
        if (this.stepsSinceBattle > this.battleThreshold){
            this.stepsSinceBattle = 0;
            this.battleThreshold = randomInstance.nextInt(1,2);
        }
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public Battle getBattle() {
        return this.battle;
    }

    public BattlePlayer getBattlePlayer() {
        return this.battlePlayer;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        this.battlePlayer.setName(playerName);
    }
}
