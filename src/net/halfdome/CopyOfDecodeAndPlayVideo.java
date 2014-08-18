package net.halfdome;

import javax.swing.JPanel;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.ToolFactory;

public class CopyOfDecodeAndPlayVideo extends JPanel{


	CopyOfDecodeAndPlayVideo(){
		
	}
  public static void main(String[] args)
  {
	String fileName = "/Users/jorma/Code/EclipseWS/YosMovieViewer/movies/gp_2012_04_24.mp4";
	
    if (fileName.length() <= 0)
      throw new IllegalArgumentException(
          "must pass in a filename as the first argument");

    
    // create a new reader

    IMediaReader reader = ToolFactory.makeReader(fileName);

    //
    // Create a MediaViewer object and tell it to play video only
    //
    reader.addListener(ToolFactory.makeViewer(IMediaViewer.Mode.VIDEO_ONLY));

    // read out the contents of the media file, and sit back and watch

    while (reader.readPacket() == null)
      do {} while(false);
    
  }
}