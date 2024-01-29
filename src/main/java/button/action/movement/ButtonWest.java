package button.action.movement;

import button.map.ButtonDisplayMap;
import main.action.movement.West;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonWest {
    public ButtonWest(ButtonInteractionEvent event, Player player, Map map){
        //move West
        West WestInstance = new West(player, 1);

        //update display
        ButtonDisplayMap slashDisplayMapInstance = new ButtonDisplayMap(event, player, map);
    }
}
