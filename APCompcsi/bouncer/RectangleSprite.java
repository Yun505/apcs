package bouncer;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class RectangleSprite extends Sprite {
    private int width;
    private int height;
    private Color color;

    public RectangleSprite(JPanel panel, int dx, int dy, int width, int height, Color color) {
        super(panel, dx,dy);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getLeft() {
        return x - width/2;
    }

    public int getRight() {
        return x + width/2;
    }

    public int getTop() {
        return y - height/2;
    }

    public int getBottom() {
        return y + height/2;
    }
    
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x-width/2,y-height/2,width,height);
    }
}
