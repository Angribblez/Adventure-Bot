package button.action.movement;

import button.map.ButtonDisplayMap;
import main.action.movement.South;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonSouth {
    public ButtonSouth(ButtonInteractionEvent event, Player player, Map map){
        //move South
        South SouthInstance = new South(player, 1);

        //update display
        ButtonDisplayMap slashDisplayMapInstance = new ButtonDisplayMap(event, player, map);
    }
}
