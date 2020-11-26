package events;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyEvent extends ListenerAdapter {


    public void onReady(net.dv8tion.jda.api.events.ReadyEvent event) {
        event.getJDA().getTextChannelById(734167565756137492L).sendMessage("ГОТОВ ВКАЛЫВАТЬ!").complete();
    }
}
