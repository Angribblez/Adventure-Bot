package slash.action.movement;

import main.action.movement.South;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import slash.map.SlashDisplayMap;

public class SlashSouth {
    public SlashSouth(SlashCommandInteractionEvent event, Player player, Map map){
        //move South
        if (event.getOption("magnitude") != null) {
            System.out.println("e");
            South SouthInstance = new South(player, event.getOption("magnitude").getAsInt());
        }else {
            South SouthInstance = new South(player, 1);
        }
        //display
        SlashDisplayMap slashDisplayMapInstance = new SlashDisplayMap(event, player, map);
    }
}
