package main.battle;

import main.battle.Abilities.Attack;
import main.battle.entities.allies.Ally;
import main.battle.entities.enemies.Enemy;

public class Battle {
    private Ally player;
    private Enemy enemy;
    public Battle(Ally player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }
    public void AllyAttack(){
        Attack attack = new Attack();
        attack.attack(this.player, this.enemy);
        this.player = (Ally) attack.getAttacker();
        this.enemy = (Enemy) attack.getTarget();
    }
    public void EnemyAttack(){
        Attack attack = new Attack();
        attack.attack(this.enemy, this.player);
        this.enemy = (Enemy) attack.getAttacker();
        this.player = (Ally) attack.getTarget();
    }

    public Ally getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}