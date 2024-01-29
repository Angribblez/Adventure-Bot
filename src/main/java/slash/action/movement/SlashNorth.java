package slash.action.movement;

import main.action.movement.North;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import slash.map.SlashDisplayMap;

public class SlashNorth {
    public SlashNorth(SlashCommandInteractionEvent event, Player player, Map map){
        //move north
        if (event.getOption("magnitude") != null) {
            System.out.println("e");
            North northInstance = new North(player, event.getOption("magnitude").getAsInt());
        }else {
            North northInstance = new North(player, 1);
        }
        //display
        SlashDisplayMap slashDisplayMapInstance = new SlashDisplayMap(event, player, map);
    }
}
