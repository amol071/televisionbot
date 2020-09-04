package amol.Television;

import javax.security.auth.login.LoginException;

import amol.Television.Commands.Clear;
import amol.Television.Events.GuildMemberJoin;
import amol.Television.Events.GuildMemberLeave;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Television {
	public static JDA jda;
	public static String prefix = "~"; 
	
	//Main method
	@SuppressWarnings("deprecation")
	public static void main(String[] args)  throws LoginException{
		jda = new JDABuilder(AccountType.BOT).setToken("NzUxNDI2NDQwMjM4NzI3MjY5.X1I6aA.gvCYyg8G0z4-8dr73nxRM5BAItI").build();
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setActivity(Activity.watching("Current Channel"));

		jda.addEventListener(new Demo());
		jda.addEventListener(new Clear());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMemberLeave());
	}
}
