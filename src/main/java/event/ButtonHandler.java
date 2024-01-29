package event;

import button.action.movement.ButtonEast;
import button.action.movement.ButtonNorth;
import button.action.movement.ButtonSouth;
import button.action.movement.ButtonWest;
import button.battle.action.ButtonAttack;
import button.map.ButtonRefreshMap;
import button.player.ButtonPlayerCoordinates;
import main.Globals;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ButtonHandler extends ListenerAdapter {
    private final Map map = Globals.getMap();
    private static final HashMap<String, Player> players = Globals.getPlayers();
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        //get player, create player if necessary
        if(!players.containsKey(event.getMember().getId())) players.put(event.getMember().getId(), new Player());
        Player player = players.get(event.getMember().getId());
        System.out.println(event.getButton().getId());
        if (!event.getButton().getId().split("-")[1].equals(event.getMember().getId())){
            event.reply("This is not your command to click buttons on").setEphemeral(true).queue();
            return;
        }
        if (event.getButton().getId().startsWith("buttonNorth")) {
            ButtonNorth buttonNorthInstance = new ButtonNorth(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonSouth")) {
            ButtonSouth buttonSouthInstance = new ButtonSouth(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonEast")) {
            ButtonEast buttonEastInstance = new ButtonEast(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonWest")) {
            ButtonWest buttonWestInstance = new ButtonWest(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonRefreshMap")) {
            ButtonRefreshMap buttonRefreshMapInstance = new ButtonRefreshMap(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonCoordinates")) {
            ButtonPlayerCoordinates buttonPlayerCoordinatesInstance = new ButtonPlayerCoordinates(event, player, map);
        } else if (event.getButton().getId().startsWith("buttonAttack")) {
            ButtonAttack buttonAttackInstance = new ButtonAttack(event, player);
        } else if (event.getButton().getId().startsWith("buttonCycle")) {
        } else if (event.getButton().getId().startsWith("buttonFlee")) {
        } else if (event.getButton().getId().startsWith("buttonScrollUp")) {
        } else if (event.getButton().getId().startsWith("buttonScrollDown")) {
        } else if (event.getButton().getId().startsWith("buttonDefend")) {
        } else if (event.getButton().getId().startsWith("buttonSummon")) {
        } else if (event.getButton().getId().startsWith("buttonMagicOne")) {
        } else if (event.getButton().getId().startsWith("buttonMagicTwo")) {
        } else if (event.getButton().getId().startsWith("buttonMagicThree")) {
        } else {
            event.reply("Error").setEphemeral(true).queue();
        }
    }
}
