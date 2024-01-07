import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bit of empty space for bubbles to float in.
 * 
 * @author Michael KÃ¶lling
 * @version 1.0
 */
public class Space extends World
{
    private String lastKey = "";  // keeps track of the key from the last act cycle.

        /**
     * Create Space. Make it black.
     */
    public Space()
    {
        super(900, 600, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
    }
    
    
    public void act () {
        String key = Greenfoot.getKey();

        // If the user is currently pressing a key and that same key wasn't down last act cycle...
        if (key != null && !key.equals(lastKey)) {

            // Clears the world of all objects.
            removeObjects(getObjects(null));
            
            // Cascading if/else statements to check which key was pressed and call the appropriate method
            if (key.equals("1")) {
                bubbles1();
            }
            else if (key.equals("2")) {
                // create bubbles for key 2 here.  (Create a method called bubbles2 while doing so.)
                bubbles2(); 
            }
            // TODO: Create additional else/if cases here
            else if (key.equals("3")){
                bubbles3(); 
            }
            else if (key.equals("4")){
                bubbles4(); 
            }
            else if (key.equals("5")){
                bubbles5(); 
            }
        }
        lastKey = key;
    }
    
    // method for creating bubbles when 1 is pressed.
    public void bubbles1() {
        // create your 21 random bubbles
        for (int a = 0; a<21; a++){
            int xLocation = (int)(Math.random()*900); 
            int yLocation = (int)(Math.random()*600);
            Bubble bubble = new Bubble();
            addObject(bubble, xLocation, yLocation); 
        }
    }
    
    public void bubbles2(){
        for (int a= 0, b= 0; a<=600; a+=30, b+=30){
            Bubble bubble = new Bubble();
            addObject(bubble, a, b); 
        }
    }
    public void bubbles3(){
        for (int count =1,a= 0, b= 0; count<22;count++, a+=42.857142857142857142857142857143, b+=28.571428571428571428571428571429){
            Bubble bubble = new Bubble();
            addObject(bubble, a, b); 
        }
    }
    public void bubbles4(){
        for (int  count = 0, a = 300, b= 100,c =10; count<10; a+=40, c+=10, count++){
            Bubble bubble = new Bubble(c);
            addObject(bubble, a, b); 
        }
    }
    public void bubbles5(){
        for (int a = 0, size = 190,direction = 0; a<18; a++, size-=10, direction+=20){
            Bubble bubble = new Bubble(size, direction);
            addObject(bubble, 450,300); 
        }
    }
}


