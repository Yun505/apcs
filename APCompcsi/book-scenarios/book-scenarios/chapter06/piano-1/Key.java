import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    private boolean isDown = false; 
    private String letter;
    private String sound; 
    /**
     * Create a new key.
     */
    public Key(String let, String sound)
    {
        letter = let;
        this.sound = sound; 
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if ( !isDown &&Greenfoot.isKeyDown(letter)){
            setImage("white-key-down.png");
            Greenfoot.playSound(sound);
            isDown = true; 
        }
        else if (isDown &&Greenfoot.isKeyDown(letter)){
        setImage("white-key.png");
        isDown = false; 
        }
    

    }
}

