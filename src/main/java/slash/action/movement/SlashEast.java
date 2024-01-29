package slash.action.movement;

import main.action.movement.East;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import slash.map.SlashDisplayMap;

public class SlashEast {
    public SlashEast(SlashCommandInteractionEvent event, Player player, Map map){
        //move East
        if (event.getOption("magnitude") != null) {
            System.out.println("e");
            East EastInstance = new East(player, event.getOption("magnitude").getAsInt());
        }else {
            East EastInstance = new East(player, 1);
        }
        //display
        SlashDisplayMap slashDisplayMapInstance = new SlashDisplayMap(event, player, map);
    }
}
