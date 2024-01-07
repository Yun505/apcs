import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int UfoTimer = 50; 
    private int score = 0 ; 
    private int timer = 2000;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        showScore();
        showTimer();
        
        Earth earth = new Earth(); 
        addObject(earth,300,370);
        
        Ship ship = new Ship();
        ship.turn(-90); 
        addObject(ship, 300, 350); 
         
        Ufo ufo = new Ufo();
        addObject(ufo,300,28); 
        
    }
    private void countTimer(){
     timer--;
     showTimer();
     if (timer == 0){
            showText("Time is up!", 390, 150); 
            showText("Final score: " + score, 390, 170); 
            Greenfoot.stop();
        }
    }
    private void showScore(){
        showText("Score: " + score, 60, 325); 
    }
    private void showTimer(){
        showText("Time: " + timer, 60, 350); 
    }
    public void act(){
        countTimer();
        int flipcoin = (int) (Math.random()*2);
        if (UfoTimer <=0){ 
            if (flipcoin ==1){
                addUfo(); 
                UfoTimer =50; 
            }
        }   
            UfoTimer--; 


    }
    public void addScore ( int points){
        score += points;
        showScore();
        if (score <0){
            Greenfoot.playSound("au.wav"); 
            Greenfoot.stop();
        }
    }
    private void checkKeyPress(){
        if (Greenfoot.isKeyDown("space")) 
        {
            Bullet bullet = new Bullet(); 
        }
    }
    public void addUfo(){
        Ufo ufo = new Ufo();
        addObject(ufo, xLocation(), yLocation()); 
    }
     private int xLocation(){
        int x = (int)(Math.random() *573); 
        if (x<28){
            x=28; 
        }
        return x;
    }
    private int yLocation(){
       int y=(int)(Math.random() * 240);
       if (y<28){
           y=28; 
        }
        return y; 
    }
    
}
