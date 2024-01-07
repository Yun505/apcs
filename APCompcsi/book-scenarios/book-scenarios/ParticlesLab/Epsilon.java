import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Epsilon particles are small yellow particles, typically slightly negatively charged.
 * 
 */
public class Epsilon extends Particle
{
    private static final int defaultSize = 20;
    private static final double defaultMass = 100.0;
    private static final double defaultCharge = -1.0;
    private static final Color defaultColor = new Color(255, 255, 0, 100);
    
    /**
     * Construct an Epsilon Particle with default size, mass, velocity and color.
     */
    public Epsilon()
    {
        super(defaultSize, defaultMass, defaultCharge, new Vector(), defaultColor);
    }    
}
