package events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionRecivedEvent extends ListenerAdapter {

    public void onGenericGuildMessageReaction(GenericGuildMessageReactionEvent e) {

        e.getChannel().retrieveMessageById(e.getMessageId()).queue();
        Message msg = e.getChannel().retrieveMessageById(e.getMessageId()).complete();
        for (MessageReaction react : msg.getReactions()) {
            if (react.getReactionEmote().getEmote().getIdLong() == 768253311353880586L) {  // ID used emote
                if (react.getCount() == 2) {  // count emote
                    msg.delete().complete();
                }
            }
        }
    }
}