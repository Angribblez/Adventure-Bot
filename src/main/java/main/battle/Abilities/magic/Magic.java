package main.battle.Abilities.magic;

import main.battle.Abilities.Attack;
import main.battle.entities.Entity;

public class Magic extends Attack {
    protected String magicName = "Magic";

    public String getMagicName() {
        return magicName;
    }
}
