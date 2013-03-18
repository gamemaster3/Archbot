package me.gamemaster3.Xbotmain;

import me.gamemaster3.chat.Chatmang;

import org.jibble.pircbot.*;

public class X__bot extends PircBot{
	public int countx = 0;
	public X__bot(){
		this.setName("Archbot");
	}
	public void onMessage(String channel, String sender,String login, String hostname, String message) {
		Chatmang.addText(channel + " - " + sender + ": " + message);
		if (message.equalsIgnoreCase("-time")) {
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": The time is now " + time);
		}
		if(message.equalsIgnoreCase("-counter")){
			countx++;
			sendMessage(channel, "Counter " + countx + " times");
		}
		if(sender.equalsIgnoreCase("song_bot")){
			sendMessage(channel, "Gamemaster3 dosn't hate you but its just mutual... USE BOTH OF US Kappa");
		}
	}
}
