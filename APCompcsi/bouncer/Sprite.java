package bouncer;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Sprite {
  protected JPanel panel;
  protected int x, y;
  protected int dx, dy;
  
  protected int theta;
  protected int dTheta;
  
  public Sprite (JPanel panel, int dx, int dy)
  {
    this (panel, dx, dy, 0);
  }
  
  public Sprite (JPanel panel, int dx, int dy, int dTheta)
  {
    this.panel = panel;

    this.x = panel.getWidth() / 2;
    this.y = panel.getHeight() / 2;
    this.theta = 0;
    
    this.dTheta = dTheta;
    this.dx = dx;
    this.dy = dy;    
  }
  
  public void move() {
    x += dx;
    y += dy;
    theta += dTheta;

    if (getLeft() < 0)
      dx *= -1;
    
    if (getRight() > panel.getWidth()) 
      dx *= -1;
    
    if (getTop() < 0 || getBottom() > panel.getHeight()) {
      dy *= -1;
    }
  }
  
  public abstract void paint(Graphics g);
  public abstract int getRight();
  public abstract int getLeft();
  public abstract int getTop();
  public abstract int getBottom();
    
}
