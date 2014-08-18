package net.halfdome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuExample implements ActionListener{
	
	static JMenu monthMenu;
	
	MenuExample(){
		
		JFrame frame = new JFrame("Tester");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JPanel panel = new JPanel();

		JMenuBar menuBar = new JMenuBar();
		monthMenu = new JMenu("Month");
		JMenu dayMenu = new JMenu("Day");
		JMenu yearMenu = new JMenu("Year");
		
		JMenuItem monthMenuItem1 = new JMenuItem("Jan");
		JMenuItem monthMenuItem2 = new JMenuItem("Feb");
		JMenuItem monthMenuItem3 = new JMenuItem("March");
		
		monthMenu.add(monthMenuItem1);
		monthMenu.add(monthMenuItem2);
		monthMenu.add(monthMenuItem3);

		menuBar.add(monthMenu);
		menuBar.add(dayMenu);
		menuBar.add(yearMenu);
		
		monthMenuItem1.addActionListener(this);
		monthMenuItem2.addActionListener(this);
		monthMenuItem3.addActionListener(this);
		
		panel.add(menuBar);
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		System.out.println(ae.getActionCommand());
		monthMenu.setText(ae.getActionCommand());
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MenuExample();
			}
		});
	}
}