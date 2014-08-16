package net.halfdome;

public class Tester {
	public static void main(String[] args){
		String url = "http://halfdome.net/glacier_point/2010/gp_2010_10_10.mp4";
		
		String file = url.substring(39);
		System.out.println(file);
	}
}
