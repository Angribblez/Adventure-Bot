package slash.housing;

import main.housing.ClaimHouse;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashClaimHouse {
    public SlashClaimHouse(SlashCommandInteractionEvent event, Player player, Map map){
        ClaimHouse claimHouseInstance = new ClaimHouse(player, map);
        if (claimHouseInstance.isSuccess()){
            event.reply("Successfully claimed house").setEphemeral(true).queue();
        }else {
            event.reply("Cannot claim house").setEphemeral(true).queue();
        }
    }
}
