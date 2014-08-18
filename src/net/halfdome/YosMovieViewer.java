package net.halfdome;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class YosMovieViewer implements ActionListener {

	Color darkGreen = new Color(49, 69, 74);
	JMenu monthMenu;
	JFrame frame;
	
	MoviePanel panel_movie;
	MoviePanel2 panel_movie2;

	YosMovieViewer() {
		panel_movie = new MoviePanel();
		panel_movie2 = new MoviePanel2();
		//DecodeAndPlayVideo panel_movie = new DecodeAndPlayVideo();
		
		frame = new JFrame("Yosemite Movie Viewer");

		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JLabel label_heading = new JLabel("HalfDome Time-Lapse Viewer");
		label_heading.setForeground(Color.white);
		label_heading.setFont(new Font("Verdana", Font.BOLD, 16));

		
		JPanel panel_top = new JPanel();
		panel_top.add(label_heading);

		JPanel panel_bottom = new JPanel();
		JLabel label_bottomPanel = new JLabel("Choose a date:");
		label_bottomPanel.setFont(new Font("Verdana", Font.BOLD, 16));
		label_bottomPanel.setForeground(Color.white);

		JPanel panel_left = new JPanel();
		JPanel panel_right = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		monthMenu = new JMenu("Month");
		JMenu dayMenu = new JMenu("Day");
		JMenu yearMenu = new JMenu("Year");

		menuBar.add(monthMenu);
		menuBar.add(dayMenu);
		menuBar.add(yearMenu);
		JButton submitButton = new JButton("View Movie");

		submitButton.addActionListener(this);
		monthMenu.addActionListener(this);
		
		panel_top.setBackground(darkGreen);
		panel_bottom.setBackground(darkGreen);
		panel_movie.setBackground(darkGreen);
		panel_left.setBackground(darkGreen);
		panel_right.setBackground(darkGreen);

		panel_bottom.add(label_bottomPanel);
		panel_bottom.add(menuBar);
		panel_bottom.add(submitButton);
		
		
		frame.add(panel_top, BorderLayout.NORTH);
		frame.add(panel_bottom, BorderLayout.SOUTH);
		frame.add(panel_movie, BorderLayout.CENTER);
		frame.add(panel_left, BorderLayout.WEST);
		frame.add(panel_right, BorderLayout.EAST);

		CalendarItems.populateDateMenu(monthMenu, dayMenu, yearMenu);
		


		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new YosMovieViewer();
			}
		});
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals("View Movie")) {

			CalendarItems.convertMonth(CalendarItems.movieMonth);
			CalendarItems.movieDate = (CalendarItems.movieYear + "_"
					+ CalendarItems.movieMonth + "_" + CalendarItems.movieDay + ".mp4");
			String filePath = "http://halfdome.net/glacier_point/"
					+ CalendarItems.movieYear + "/gp_"
					+ CalendarItems.movieDate;
			String fileName = "/gp_" + CalendarItems.movieDate;
			System.out.println(filePath);
			//Downloader.downloadMovie(filePath, fileName);
			
			frame.remove(panel_movie);
			//frame.add(panel_movie2, BorderLayout.CENTER);

			frame.repaint();
			
			frame.add(panel_movie2, BorderLayout.CENTER);
			
			frame.repaint();
		}
	}
}
