package amol.Television.Commands;

import java.util.List;
import amol.Television.Television;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase(Television.prefix + "clear")) {
			if (args.length < 2) {
				// Too Many Messages
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete!");
				usage.setDescription("Usage: " + Television.prefix + "clear [# of messages]");
				event.getChannel().sendMessage(usage.build()).queue();
			} else {
				try {

					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]))
							.complete();
					event.getChannel().deleteMessages(messages).queue();
					
					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("✅ Successfully deleted "+ args[1] + " messages ✅");
					event.getChannel().sendMessage(success.build()).queue();

				} catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException : Message retrieval")) {
						// Too Many Messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("⚠ Too Many Messages Selected!");
						error.setDescription("⚠ Between 1 to 100 messages can be set! ⚠");
						event.getChannel().sendMessage(error.build()).queue();
					} else {
						// Messages too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("⚠ Selected messages are older than 2 weeks!");
						error.setDescription("⚠ Messages older than 2 weeks cannot be deleted! ⚠");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		}
	}
}
