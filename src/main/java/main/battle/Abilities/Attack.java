package main.battle.Abilities;

import main.battle.entities.Entity;

public class Attack {
    private Entity attacker;
    private Entity target;
    public void attack(Entity attacker, Entity target){
        int atk = attacker.getStr();
        int lvl = attacker.getLv();
        int def = target.getDef();
        double baseDamage = atk + ((double) (atk + lvl) /32) * ((double) (atk * lvl) /32);
        double maxDamage = (512-def)*baseDamage/(512);
        int randomDamage = (int) (Math.random()*256);
        int actualDamage = (int) (maxDamage*(3841+randomDamage)/4096);
        target.subtractHp(actualDamage);
        this.attacker = attacker;
        this.target = target;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public Entity getTarget() {
        return target;
    }
}
