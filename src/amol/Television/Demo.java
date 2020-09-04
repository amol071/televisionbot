package amol.Television;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Demo extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		if (args[0].equalsIgnoreCase(Television.prefix + "info")) {
			
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle(" 📺 Television Bot Information");
			info.setDescription("Completely useless information about this useless bot called Television");
			info.setColor(0xf45642);
			info.setFooter("Created by Amol Vyavaharkar",event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
	}
}
