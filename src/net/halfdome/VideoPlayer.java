package net.halfdome;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.MediaListenerAdapter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IVideoPictureEvent;

public class VideoPlayer
{
  
  public static void main(String[] args)
  {
    String sourceUrl = "/Users/jorma/Code/EclipseWSpace/YosemiteMovieViewer/res/gp_2012_04_24.mp4";
    
    VideoPlayer videoPlayer = new VideoPlayer();
    videoPlayer.play(sourceUrl);
  }

  public void play(String sourceUrl)
  {
    IMediaReader reader = ToolFactory.makeReader(sourceUrl);
    reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
    
    final MyVideoPanel panel = new MyVideoPanel();
    
    MediaListenerAdapter adapter = new MediaListenerAdapter()
    {
      @Override
      public void onVideoPicture(IVideoPictureEvent event)
      {
        panel.setImage((BufferedImage) event.getImage());
      }
    };
    reader.addListener(adapter);
    
    while (reader.readPacket() == null)
      do {} while(false);
  }
  
  @SuppressWarnings("serial")
  private class MyVideoPanel extends JPanel
  {
    Image image;
    
    public void setImage(final Image image)
    {
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          MyVideoPanel.this.image = image;
          repaint();
        }
      });
    }
  
    @Override
    public synchronized void paint(Graphics g)
    {
      if (image != null)
      {
        g.drawImage(image, 0, 0, null);
      }
    }
  }
}
