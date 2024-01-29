package slash.other;

import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class SlashHelp {
    public SlashHelp(SlashCommandInteractionEvent event, Player ignoredPlayer, Map ignoredMap) {
        //handle message and respond
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(new Color(0x0099ff));
        embed.setTitle("Help");
        embed.addField("Welcome!","Welcome to adventure RPG bot! This bot is still under development", false);
        embed.addField("Movement:","north, south, east, west", false);
        embed.addField("Map:","display", false);
        event.replyEmbeds(embed.build()).queue();
    }
}
