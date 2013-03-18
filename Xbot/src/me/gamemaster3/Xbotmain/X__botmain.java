package me.gamemaster3.Xbotmain;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import me.gamemaster3.Xbotmain.*;
import me.gamemaster3.chat.Commands;

public class X__botmain {
	
	private static X__bot bot;
	public static void main(String[] args) throws IOException {
		new Manager("Control Panel 0.03a",300,135);
	}
	public static void join(String User) throws IOException{
		
		bot = new X__bot();
		bot.setVerbose(true);
		try {
			bot.connect(User + ".jtvirc.com", 6667, "Gamemaster314");
		} catch (NickAlreadyInUseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
		bot.joinChannel("#" + User);
		bot.sendMessage("#" + User, "Archbot is here! 0.03a -" + User + ",");
	}
	public static void Quit(){
		X__bot bot = X__botmain.bot;
		
		bot.disconnect();
	}
	public static void SendMessage(String s, String User){
		X__bot bot = X__botmain.bot;
		
		bot.sendMessage("#" + User,"ArchbotCPMessage: " + s);
	}
	
}
