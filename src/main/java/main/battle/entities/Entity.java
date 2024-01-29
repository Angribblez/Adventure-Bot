package main.battle.entities;

import main.battle.Abilities.magic.Magic;
import main.battle.Abilities.magic.bolt.Bolt;
import main.battle.Abilities.magic.cure.Cure;
import main.battle.Abilities.magic.fire.Fire;
import main.battle.Abilities.magic.ice.Ice;
import main.battle.Abilities.magic.water.Water;

import java.util.ArrayList;

public class Entity {
    protected int lv = 1; //level
    protected int maxHp = 100; //max health points, max 5 digits no commas
    protected int hp = maxHp; //health points, max 5 digits no commas
    protected int xp = 0; //experience points
    protected int mp = 1; //magic points
    protected int str = 40; //strength
    protected int dex = 1; //dexterity
    protected int vit = 1; //vitality
    protected int mag = 1; //magic
    protected int spr = 1; //spirit
    protected int lck = 1; //luck
    protected int atk = 1; //evasion
    protected int def = 1; //magic defense
    protected String description = "an entity"; //description for battle dialogue
    protected String name = "an entity"; //name for battle panel, max 6 chars for ally, no current max for enemy
    protected ArrayList<Magic> magics = new ArrayList<>();
    public Entity(){
        magics.add(new Bolt());
        magics.add(new Cure());
        magics.add(new Fire());
        magics.add(new Ice());
        magics.add(new Water());
    }

    public ArrayList<Magic> getMagics() {
        return magics;
    }

    public int getStr() {
        return str;
    }

    public int getLv() {
        return lv;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void subtractHp(int damage){
        this.hp -= damage;
    }
    public boolean isAlive(){
        return this.hp > 0;
    }
    public void reset(){
        this.hp = 100; //health points
        this.mp = 1; //magic points
        this.str = 40; //strength
        this.dex = 1; //dexterity
        this.vit = 1; //vitality
        this.mag = 1; //magic
        this.spr = 1; //spirit
        this.lck = 1; //luck
        this.atk = 1; //evasion
        this.def = 1; //magic defense
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
