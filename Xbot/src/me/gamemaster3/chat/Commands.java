package me.gamemaster3.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Commands {
	static int intcount = 0;
	static String[] comname;
	static String[] comout;
	static int[] ID;
	public static void setCommands() throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("commands.txt")));
			String line;
			while((line = br.readLine()) != null){
				intcount++;
				String[] parts = line.split(";");
					System.err.println(intcount + " Command: -" + parts[0] + " Output: " + parts[1]);
					comname[intcount] = parts[0];
					comout[intcount] = parts[1];
					ID[intcount] = intcount;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
