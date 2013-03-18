package me.gamemaster3.Xbotmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import me.gamemaster3.chat.Chatmang;

import org.jibble.pircbot.*;

public class Manager extends JFrame{
	private static final long serialVersionUID = 1L;
	static String US = null;
	static int conn = 0;
	public Manager(String title, int width, int height){
		super(title);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		setLayout(null);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		JButton Connect = new JButton("Connect");
		Connect.setSize(110, 25);
		Connect.setLocation(10,10);
		Connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(US == null){
					try {
						Usrset();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else{
					if(conn == 0){
						conn = 1;
						try {
							X__botmain.join(US);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(getParent(), "Archbot is aready in a channel \n Please disconnect first!", "Err", NORMAL);
					}
					
				}
			}
			
		});
		add(Connect);
		JButton Mess = new JButton("Send Message");
		Mess.setSize(110, 25);
		Mess.setLocation(120,10);
		Mess.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(conn == 1){
					int g2 = 0;
					while(g2 < 1){
						String i = JOptionPane.showInputDialog("Text to send:");
						if(i.length() > 0){
							g2 = 1;
							X__botmain.SendMessage(i, US);
						}
					}
				}else{
					JOptionPane.showMessageDialog(getParent(), "Archbot is not in a Channel \n Please Connect first!", "Err", NORMAL);

				}
				
			}
			
		});
		add(Mess);
		
		JButton Dis = new JButton("Disconnect");
		Dis.setSize(110, 25);
		Dis.setLocation(10,35);
		Dis.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(conn == 1){
					X__botmain.Quit();
					conn = 0;
					US = null;
				}else{
					JOptionPane.showMessageDialog(getParent(), "Archbot is not in a Channel \n Please Connect first!", "Err", NORMAL);
				}
				
			}
			
		});
		add(Dis);
		
		JButton Con = new JButton("Console/Chat");
		Con.setSize(110, 25);
		Con.setLocation(120,35);
		Con.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(conn == 1){
					new Chatmang("Chat", 500, 500);
				}else{
					JOptionPane.showMessageDialog(getParent(), "Archbot is not in a Channel \n Please Connect first!", "Err", NORMAL);
				}
				
			}
			
		});
		add(Con);
	}
	public static String getUS() {
		return US;
	}
	public static void setUS(String uS) {
		US = uS;
	}
	public void Usrset() throws IOException{
		int g = 0;
		while(g < 1){
			String input = JOptionPane.showInputDialog("Please Input Your Twitch Username:");
			if(input.length() > 0){
				g = 1;
				US = input;
				X__botmain.join(US);
				conn = 1;
			}
		}
	}
}
