package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReactionRecivedEvent extends ListenerAdapter {

    public void onGenericGuildMessageReaction(GenericGuildMessageReactionEvent e) {
        e.getChannel().retrieveMessageById(e.getMessageId()).queue();
        Message msg = e.getChannel().retrieveMessageById(e.getMessageId()).complete();


        for (MessageReaction react : msg.getReactions()) {
            if (react.getReactionEmote().getEmote().getIdLong() == 768253311353880586L) {  // ID used emote
                if (react.getCount() == 1) {  // count emote
                    msg.delete().complete();

                    EmbedBuilder eb = new EmbedBuilder();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyy HH:mm");
                    Date date = new Date();
                    Member member = msg.getMember();
                    assert member != null;
                    String img = msg.getMember().getUser().getAvatarUrl();
                    String ping = member.getAsMention();
                    eb.setTitle("Don't write offtop!");
                    eb.addField("Your message was deleted.", "Be careful, " + ping +
                            "\nstick to the conversation topic set by the server.", true);
                    eb.setColor(Color.orange);
                    eb.setThumbnail(img);
                    eb.setFooter("Message deleted   " + formatter.format(date), e.getGuild().getIconUrl());

                    e.getChannel().sendMessage(eb.build()).queue();
                    member.getUser().openPrivateChannel().queue(channel -> channel.sendMessage(eb.build()).queue());
                }
            }
        }
    }
}
