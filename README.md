# OfftopDiscordBot
This bot will help you remove unwanted content from the chat. Just enter N number of responses and the message will be deleted.

A bot that will help you monitor the content on the server and stick to the topic.

# BEFORE RUNNING:
1) In the "ReactionRecivedEvent" file, specify the ID of the reaction that you will use as a counter.
In the same file, one line below, specify the number of responses that you need to dial to delete the message.
BE CAREFUL, the default value is "1".

2) In the "ReadyEvent" file, specify your default channel ID.
A message about the bot's readiness will be sent there. This message is deleted after the same period of time as any other message from this bot.

3) In the" Secret " file, specify your TOKEN.

4) In the" CleanBotMessageEvent " file, specify the necessary delay before deleting the message and the ID of your bot.


When creating a bot on the Discord Developer site, don't forget to check the "PRESENCE INTENT" and "SERVER MEMBERS INTENT"boxes.
Also grant the bot Administrator-level access or the necessary permissions.
