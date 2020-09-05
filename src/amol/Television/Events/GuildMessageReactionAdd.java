package amol.Television.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
	@SuppressWarnings("unlikely-arg-type")
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		if (event.getReactionEmote().getName().equals("❌")
				&& !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			if (event.getUser()
					.equals(event.getChannel().retrieveMessageById(event.getMessageId()).complete().getAuthor())) {
//If it's the author of the message
				event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
			}
			else {
				event.getReaction().removeReaction().queue();
			}
		}
	}
}
