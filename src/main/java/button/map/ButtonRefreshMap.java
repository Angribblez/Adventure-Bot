package button.map;

import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonRefreshMap {
    public ButtonRefreshMap(ButtonInteractionEvent event, Player player, Map map){
        //update map
        ButtonDisplayMap buttonDisplayMapInstance = new ButtonDisplayMap(event, player, map);
    }
}
