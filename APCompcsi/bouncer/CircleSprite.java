package bouncer;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class CircleSprite extends Sprite{
    protected int radius;
    protected Color color;

    public CircleSprite (JPanel panel, int dx, int dy, int radius, Color color){
        super(panel, dx, dy);
        this.radius = radius;
        this.color = color;
    }

    public int getLeft(){
        return x - radius;
    }

    public int getRight(){
        return x + radius; 
    }

    public int getTop(){
        return y - radius; 
    }

    public int getBottom(){
        return y + radius; 
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);

    }
}
