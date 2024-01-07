
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int bulletTimer = 20;
    private boolean shoot = false; 
    public void act() 
    {
        checkKeyPress(); 
        checkCollision(); 
        if (bulletTimer<=0){
            shoot = true; 
        }
        if (shoot == true){
            if (Greenfoot.isKeyDown("space")){
              Bullet bullet = new Bullet(); 
              getWorld().addObject(bullet, getX(), getY()-8);
              shoot = false;
           } 
           if (bulletTimer <=0){ 
                bulletTimer =20; 
           }   
        }
        else{
            bulletTimer--; 
        }
    }  
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+ 4, getY());
        }
        else if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX() - 4, getY());
        }
    }
    private void checkCollision(){
        if (isTouching(Ufo.class)){
            Greenfoot.playSound("au.wav"); 
            Greenfoot.stop(); 
        }
    }
}
