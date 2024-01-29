package main.battle.entities.allies;

import main.battle.entities.Entity;

public class Ally extends Entity {
    protected String name = "Ally";
    protected String description = "an ally";
    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }
}
