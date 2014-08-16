package net.halfdome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CalendarItems {
	
	public static String movieDate;
	public static String movieDay;
	public static String movieMonth;
	public static String movieYear;
	
	public static String[] monthList = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	public static String[] dayList = new String[32];
	public static String[] yearList = {"2007","2008","2009","2010","2011","2012","2013"};
	
	public static void populateDateMenu(JMenu monthMenu, JMenu dayMenu, JMenu yearMenu) {
		JMenuItem monthMenuItem;
		JMenuItem dayMenuItem;
		JMenuItem yearMenuItem;
		// populate dayList array
		for (int i = 0; i < 32; i++) {
			String j = String.valueOf(i);
			CalendarItems.dayList[i] = j;
		}
		
		// add each item in dayList array to dayMenu and add ActionListener
		for (int i = 0; i < CalendarItems.dayList.length; i++) {
			dayMenuItem = new JMenuItem(CalendarItems.dayList[i]);
			dayMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					movieDay = e.getActionCommand();
					
					
				}
			});
			dayMenu.add(dayMenuItem);
		}
		
		// add each item in monthList array to monthMenu and add ActionListener
		for (int i = 0; i < CalendarItems.monthList.length; i++) {
			monthMenuItem = new JMenuItem(CalendarItems.monthList[i]);
			monthMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					movieMonth = e.getActionCommand();
					//monthMenu.setText(movieMonth);
					
				}
			});
			monthMenu.add(monthMenuItem);
		}
		
		// add each item in yearList array to yearMenu and add ActionListener
		for (int i = 0; i < CalendarItems.yearList.length; i++) {
			yearMenuItem = new JMenuItem(CalendarItems.yearList[i]);
			yearMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
					movieYear = e.getActionCommand();
				}
			});
			yearMenu.add(yearMenuItem);
		}
	}
	
	public static void convertMonth(String month){
		switch (month) {
		case "January":
			movieMonth = "01";
			break;
		case "February":
			movieMonth = "02";
			break;
		case "March":
			movieMonth = "03";
			break;
		case "April":
			movieMonth = "04";
			break;
		case "May":
			movieMonth = "05";
			break;
		case "June":
			movieMonth = "06";
			break;
		case "July":
			movieMonth = "07";
			break;
		case "August":
			movieMonth = "08";
			break;
		case "September":
			movieMonth = "09";
			break;
		case "October":
			movieMonth = "10";
			break;
		case "November":
			movieMonth = "11";
			break;
		case "December":
			movieMonth = "12";
			break;

		default:
			break;
		}
	}
	
}
