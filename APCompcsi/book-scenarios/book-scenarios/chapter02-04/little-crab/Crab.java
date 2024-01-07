import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormsEaten = 0;
    
    public Crab() {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);        
    }
    
    public void act()
    {
        checkKeyPress();
        
        move(5);
        
        lookForWorm();
        
        if(getImage() == image1) {
            setImage(image2);
        }
        else {
            setImage(image1);
        }
    }

    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("left")) {
            turn(-4);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(4);
        }
        
    }
    
    public void lookForWorm() {
        if (isTouching(Worm.class)) {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            
            wormsEaten++;
            
            if (wormsEaten == 8) {
                Greenfoot.playSound("fanfare.wav");
                Greenfoot.stop();
            }            
        }        
}
}


