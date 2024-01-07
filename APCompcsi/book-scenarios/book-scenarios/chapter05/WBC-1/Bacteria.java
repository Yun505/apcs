import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bacteria fload along in the bloodstream. They are bad. Best to destroy
 * them if you can.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bacteria extends Actor
{
    private int speed;
    
    /**
     * Constructor. Nothing to do so far.
     */
    public Bacteria()
    {
        speed = ((int)Math.random()*3) + 1;
    }

    /**
     * Float along the bloodstream, slowly rotating.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            ((Bloodstream)getWorld()).addScore(-15);
            getWorld().removeObject(this);
        }
    }
}
