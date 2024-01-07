import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gamma particles are medium-sized green particles, typically negatively charged.
 * 
 */
public class Gamma extends Particle
{
    private static final int defaultSize = 30;
    private static final double defaultMass = 180.0;
    private static final double defaultCharge = -3.0;
    private static final Color defaultColor = new Color(0, 255, 0, 100);
    
    /**
     * Construct a Gamma Particle with default size, mass, velocity and color.
     */
    public Gamma()
    {
        super(defaultSize, defaultMass, defaultCharge, new Vector(), defaultColor);
    }    
}
