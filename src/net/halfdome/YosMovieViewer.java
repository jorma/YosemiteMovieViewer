package net.halfdome;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.*;

public class YosMovieViewer implements ActionListener {

	Color darkGreen = new Color(49, 69, 74);

	YosMovieViewer() {

		JFrame frame = new JFrame("Yosemite Movie Viewer");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JLabel label_heading = new JLabel("HalfDome Time-Lapse Viewer");
		label_heading.setForeground(Color.white);
		label_heading.setFont(new Font("Verdana", Font.BOLD, 16));

		JPanel panel_main = new JPanel();
		panel_main.setBackground(darkGreen);
		panel_main.add(label_heading, BorderLayout.NORTH);

		JPanel panel_bottom = new JPanel();
		JLabel label_bottomPanel = new JLabel("Choose a date:");

		JMenuBar menuBar = new JMenuBar();
		JMenu monthMenu = new JMenu("Month");
		JMenu dayMenu = new JMenu("Day");
		JMenu yearMenu = new JMenu("Year");

		menuBar.add(monthMenu);
		menuBar.add(dayMenu);
		menuBar.add(yearMenu);
		JButton submitButton = new JButton("View Movie");

		submitButton.addActionListener(this);
		monthMenu.addActionListener(this);

		panel_bottom.add(label_bottomPanel);
		panel_bottom.add(menuBar);
		panel_bottom.add(submitButton);

		frame.add(panel_main);
		frame.add(panel_bottom, BorderLayout.SOUTH);

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
			Downloader.downloadMovie(filePath, fileName);

		}
	}
}
