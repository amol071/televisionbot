package amol.Television.Events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberLeave extends ListenerAdapter {
	
	String[] messages = {
		    "[member] couldn't handle the party! So, [member] left ☹.  "
		  };
	
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		Random rand = new Random();
		int number = rand.nextInt(messages.length);

		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0x66d8ff);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

		// Add Roles
		event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("Members", true).get(0))
				.complete();

	}
}
