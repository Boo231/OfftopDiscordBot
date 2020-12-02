package events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CleanBotMessageEvent extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().getIdLong() == 746130954355081408L) {  // ID Offtop BOT
            try {
                Thread.sleep(6000); // expectation time
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.getMessage().delete().complete();
        }
    }

}
