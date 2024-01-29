package event;

import main.Globals;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import slash.action.movement.SlashEast;
import slash.action.movement.SlashNorth;
import slash.action.movement.SlashSouth;
import slash.action.movement.SlashWest;
import slash.housing.SlashClaimHouse;
import slash.map.SlashDisplayMap;
import slash.other.SlashHelp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SlashHandler extends ListenerAdapter {
    private final Map map = Globals.getMap();
    private static final HashMap<String, Player> players = Globals.getPlayers();
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        ArrayList<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("help","help command"));
        commandData.add(Commands.slash("display","display map"));
        commandData.add(Commands.slash("claim","claims house at location, bottom left corner at player position"));
        /* OLD CODE
        commandData.add(Commands.slash("north","move north").addOption(OptionType.INTEGER, "magnitude", "how many steps to take", false));
        commandData.add(Commands.slash("south","move south").addOption(OptionType.INTEGER, "magnitude", "how many steps to take", false));
        commandData.add(Commands.slash("east","move east").addOption(OptionType.INTEGER, "magnitude", "how many steps to take", false));
        commandData.add(Commands.slash("west","move west").addOption(OptionType.INTEGER, "magnitude", "how many steps to take", false));
        */
        ((GuildReadyEvent) event).getGuild().updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        //get player, create player if necessary
        if(!players.containsKey(event.getMember().getId())) players.put(event.getMember().getId(), new Player());
        Player player = players.get(event.getMember().getId());

        //pass along command handle
        System.out.println(event.getName());
        if (event.getName().equals("help")) {
            SlashHelp slashHelpInstance = new SlashHelp(event, player, map);
        } else if (event.getName().equals("display")) {
            SlashDisplayMap slashDisplayMapInstance = new SlashDisplayMap(event, player, map);
        } else if (event.getName().equals("north")) {
            SlashNorth slashNorthInstance = new SlashNorth(event, player, map);
        } else if (event.getName().equals("south")) {
            SlashSouth slashSouthInstance = new SlashSouth(event, player, map);
        } else if (event.getName().equals("east")) {
            SlashEast slashEastInstance = new SlashEast(event, player, map);
        } else if (event.getName().equals("west")) {
            SlashWest slashWestInstance = new SlashWest(event, player, map);
        } else if (event.getName().equals("claim")) {
            SlashClaimHouse slashClaimHouseInstance = new SlashClaimHouse(event, player, map);
        } else{
            event.reply("Command not working").queue();
        }
    }
}
