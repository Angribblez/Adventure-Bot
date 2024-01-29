package event;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReadyHandler extends ListenerAdapter {
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("RPG bot ready");
    }
}
