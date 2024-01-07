package bouncer;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class WheelSprite extends CircleSprite{
    private int radius2; 

    public WheelSprite (JPanel panel, int dx, int dy, int radius, Color color){
        super(panel, dx, dy, radius, color);

        radius2 = radius - 5;
    }

    public void paint(Graphics g){
        super.paint(g);

        g.setColor(panel.getBackground());
        g.fillOval(x-radius2, y-radius2, 2*radius2, 2*radius2);

    }
}
