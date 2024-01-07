import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Stickman world. Very simple; just place a stickman.
 * 
 * @author mik
 * @version 1.0
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        super(750, 500, 1); 
        addObject(new Stickman(), 375, 325);
        
        FallingObject fallingobject= new FallingObject();
        addObject(fallingobject,60,60); 
        
        FallingObject fallingobject3= new FallingObject();
        addObject(fallingobject3,25,100); 
        
        FallingObject fallingobject4= new FallingObject();
        addObject(fallingobject4,200,50); 
        
        FallingObject fallingobject5= new FallingObject();
        addObject(fallingobject5,270,200); 
        
        FallingObject fallingobject6= new FallingObject();
        addObject(fallingobject6,340,50); 
        
        FallingObject fallingobject7= new FallingObject();
        addObject(fallingobject7,700,90); 
        
       
    }
}
