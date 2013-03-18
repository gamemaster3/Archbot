package me.gamemaster3.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import me.gamemaster3.Xbotmain.X__botmain;

public class Chatmang extends JFrame{
	private static final long serialVersionUID = 1L;
	static JTextArea cha = new JTextArea("");
	static JScrollPane jsc= new JScrollPane(cha);
	public Chatmang(String title, int width, int height){
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
		setVisible(true);
		
		cha.setSize(490, 490);
		cha.setLocation(0,0);
		cha.setEditable(false);
		cha.setLineWrap(true);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(cha);
		add(jsc);
	}
	public static void addText(String text){
		cha.append(text + "\n");
	}
}
