package net.halfdome;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoviePanel extends JPanel {

	private BufferedImage image;

	public MoviePanel() {
		
//		try {
//			image = ImageIO.read(new File("images/halfdome.png"));
//		} catch (IOException ex) {
//			// handle exception...
//		}

	ImageIcon icon = new ImageIcon("images/halfdome.png"); 
	JLabel label = new JLabel(icon);
	add(label);
	}

}
