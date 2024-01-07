import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Delta particles are small purple particles, typically slightly positively charged.
 * 
 */
public class Delta extends Particle
{
    private static final int defaultSize = 20;
    private static final double defaultMass = 100.0;
    private static final double defaultCharge = 1.0;
    private static final Color defaultColor = new Color(255, 0, 255, 100);
    
    /**
     * Construct a Delta Particle with default size, mass, velocity and color.
     */
    public Delta()
    {
        super(defaultSize, defaultMass, defaultCharge, new Vector(), defaultColor);
    }    
}
