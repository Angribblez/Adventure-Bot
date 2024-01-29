package event;

import main.Globals;
import main.map.Map;
import main.player.Player;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MessageHandler extends ListenerAdapter {
    private final String prefix = Globals.getPrefix();
    private final Map map = Globals.getMap();
    private static final HashMap<String, Player> players = Globals.getPlayers();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        /* OLD CODE, message reading phased out
        //receive message event setup
        Message message = ((MessageReceivedEvent) event).getMessage();
        Guild server = message.getGuild();
        User author = message.getAuthor();
        if(author.isBot() || !message.getContentDisplay().startsWith(prefix)) {
            return; //ignore if message from bot or does not start with prefix
        }
        String authorId = author.getId();
        //create player if necessary, create player
        if (!players.containsKey(authorId)){
            //create
            players.put(authorId, new Player());
        }
        Player player = players.get(authorId);
        //start passing off message
        if(message.getContentDisplay().startsWith(prefix +"help")){
            Help helpInstance = new Help(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"north")){
            North northInstance = new North(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"south")){
            South southInstance = new South(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"east")){
            East eastInstance = new East(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"west")){
            West westInstance = new West(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"display")){
            try {
                DisplayMap displayMapInstance = new DisplayMap(message, server, author, player, map);
            } catch (IOException e){
                message.getChannel().sendMessage("Error").queue();
            }
        } else if (message.getContentDisplay().startsWith(prefix +"battle")){
            BattleStart battleStart = new BattleStart(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"attack")) {
            BattleAttack battleAttack = new BattleAttack(message, server, author, player, map);
        } else if (message.getContentDisplay().startsWith(prefix +"claim house")) {
            ClaimHouse claimHouse = new ClaimHouse(message, server, author, player, map);
        }
         */
    }
}
