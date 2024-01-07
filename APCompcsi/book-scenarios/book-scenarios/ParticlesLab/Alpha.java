import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alpha particles are large red particles, typically without charge.
 * 
 */
public class Alpha extends Particle
{
    private static final int defaultSize = 40;
    private static final double defaultMass = 500.0;
    private static final double defaultCharge = 0.0;
    private static final Color defaultColor = new Color(255, 0, 0, 100);
    
    /**
     * Construct an Alpha Particle with default size, mass, velocity and color.
     */
    public Alpha()
    {
        super(defaultSize, defaultMass, defaultCharge, new Vector(), defaultColor);
    }
    
}
