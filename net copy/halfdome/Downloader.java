package net.halfdome;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
	static URL website;
	static FileOutputStream fos;
	static ReadableByteChannel rbc;

	//static String filePath = "http://halfdome.net/glacier_point/2010/gp_2010_10_10.mp4";

	public static void downloadMovie(String url,String fileName){

		try {
			website = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rbc = Channels.newChannel(website.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fos = new FileOutputStream("movies/" + fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND!!!");
			e.printStackTrace();
		}
	}
}
