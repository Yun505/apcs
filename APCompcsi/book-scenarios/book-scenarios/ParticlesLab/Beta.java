import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Beta particles are medium-sized blue particles, typically positively charged.
 * 
 */
public class Beta extends Particle
{
    private static final int defaultSize = 30;
    private static final double defaultMass = 180.0;
    private static final double defaultCharge = 3.0;
    private static final Color defaultColor = new Color(50, 50, 255, 100);
    
    /**
     * Construct a Beta Particle with default size, mass, velocity and color.
     */
    public Beta()
    {
        super(defaultSize, defaultMass, defaultCharge, new Vector(), defaultColor);
    }    
}
