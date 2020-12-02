
import events.CleanBotMessageEvent;
import events.ReactionRecivedEvent;
import events.ReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.List;

import static net.dv8tion.jda.api.requests.GatewayIntent.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<GatewayIntent> intents = List.of(GUILD_MEMBERS, GUILD_EMOJIS, GUILD_MESSAGES, GUILD_MESSAGE_REACTIONS, GUILD_MESSAGE_TYPING, DIRECT_MESSAGE_REACTIONS);
        JDA jda = JDABuilder.create(Secret.TOKEN, intents).build();
        jda.addEventListener(new ReactionRecivedEvent());
        jda.addEventListener(new ReadyEvent());
        jda.addEventListener(new CleanBotMessageEvent());
    }
}