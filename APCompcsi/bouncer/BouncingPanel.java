package bouncer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BouncingPanel extends JPanel { 
  ArrayList<Sprite> spriteList = new ArrayList<Sprite>();
  
  public BouncingPanel() {
    super();
    
    Timer timer = new Timer(30, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (Sprite s : spriteList) {
          s.move();
        }

        repaint();
      }
    });
    timer.start();
  }
  
  public void add (Sprite sprite)
  {
    spriteList.add(sprite);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Sprite s: spriteList) {
      s.paint(g);
    }
  } 
}
