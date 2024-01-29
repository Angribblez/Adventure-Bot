package button.action.movement;

import button.battle.ButtonBattleInitiate;
import button.map.ButtonDisplayMap;
import main.action.movement.East;
import main.battle.entities.allies.Ally;
import main.battle.entities.enemies.Enemy;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonEast {
    public ButtonEast(ButtonInteractionEvent event, Player player, Map map){
        //move East
        East EastInstance = new East(player, 1);

        //update display with map
        ButtonDisplayMap buttonDisplayMapInstance = new ButtonDisplayMap(event, player, map);

        //check for battle
        if (player.shouldBattle()) {
            //create new battle
            Ally[] allies = new Ally[1];
            Enemy[] enemies = new Enemy[1];
            allies[0] = player.getBattlePlayer();
            enemies[0] = new Enemy();
            ButtonBattleInitiate buttonBattleInitiateInstance = new ButtonBattleInitiate(event, player, allies, enemies);
        }
    }
}
