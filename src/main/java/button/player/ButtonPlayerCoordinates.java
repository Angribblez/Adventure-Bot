package button.player;

import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class ButtonPlayerCoordinates {
    public ButtonPlayerCoordinates(ButtonInteractionEvent event, Player player, Map map){
        event.reply(String.format("Your coordinates are (%s,%s)", player.getPlayerX(), player.getPlayerY())).setEphemeral(true).queue();
    }
}
