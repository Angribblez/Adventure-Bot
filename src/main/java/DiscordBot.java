import event.ButtonHandler;
import event.MessageHandler;
import event.ReadyHandler;
import event.SlashHandler;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        //setup bot
        final String TOKEN = "no";
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS);
        jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL);
        jdaBuilder.addEventListeners(new ReadyHandler());
        jdaBuilder.addEventListeners(new MessageHandler());
        jdaBuilder.addEventListeners(new SlashHandler());
        jdaBuilder.addEventListeners(new ButtonHandler());
        jdaBuilder.build();
    }
}
