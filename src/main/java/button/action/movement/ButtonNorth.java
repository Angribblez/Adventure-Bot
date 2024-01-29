package button.action.movement;

import button.map.ButtonDisplayMap;
import main.action.movement.North;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonNorth {
    public ButtonNorth(ButtonInteractionEvent event, Player player, Map map){
        //move north
        North northInstance = new North(player, 1);

        //update display
        ButtonDisplayMap slashDisplayMapInstance = new ButtonDisplayMap(event, player, map);
    }
}
