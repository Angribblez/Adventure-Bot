package slash.action.movement;

import main.action.movement.West;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import slash.map.SlashDisplayMap;

public class SlashWest {
    public SlashWest(SlashCommandInteractionEvent event, Player player, Map map){
        //move West
        if (event.getOption("magnitude") != null) {
            System.out.println("e");
            West WestInstance = new West(player, event.getOption("magnitude").getAsInt());
        }else {
            West WestInstance = new West(player, 1);
        }
        //display
        SlashDisplayMap slashDisplayMapInstance = new SlashDisplayMap(event, player, map);
    }
}
