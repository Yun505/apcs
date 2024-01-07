import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CardTable is a 2D surface for Card objects to sit on. 
 * Generates various card arrangements when 1,2,3,4 or 5 on the 
 * keyboard is pressed. 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardTable extends greenfoot.World
{
    private String lastKey = "";
    /**
     * Constructor for objects of class CardTable.
     * 
     */
    public CardTable()
    {    
        // Create a new world with 1000x500 cells with a cell size of 1x1 pixels
        super(1000,500, 1);
    }
    
    /**
     * Case "1":
     * Implemented already, but you will need to update it after changing the
     * Card class.
     * 
     * Show all the cards of one suit in increasing rank from left to right,
     *evenly distributed horizontally over the whole table and centered vertically.
     *Use for loop(s) and only one addObject call.  
     */
    public void case1(){
      
      int total_cards = Card.MAX_RANK - Card.MIN_RANK + 1;
      int horiDist = getWidth() / (total_cards + 1);
      int y = getHeight()/2;
        
      for(int rank = Card.MIN_RANK, suit = 0; rank <= Card.MAX_RANK; rank++){
        int nthCard = (rank - Card.MIN_RANK + 1);
        int x = nthCard * horiDist;
        
        addObject(new Card(rank,suit), x , y);
      }
    }
    /**
     * Case "2":
     * Show all the cards of all 4 suits in 4 rows;
     * each row has increasing rank from left to right, 
     * evenly distributed horizontally over the whole table,
     * the rows evenly distributed vertically over the whole table.
     * Use for loop(s) and only one addObject call.  
     */
    public void case2(){
      //your code here
     
      int q = getHeight()/5; 
      for (int suit = 0; suit <4; suit++, q+=getHeight()/5){
           int total_cards = Card.MAX_RANK - Card.MIN_RANK + 1;
           int horiDist = getWidth() / (total_cards + 1);
         for(int rank = 1;  rank <= Card.MAX_RANK; rank++){
             int nthCard = (rank - Card.MIN_RANK + 1);
             
             int x = nthCard * horiDist;
             
        
             addObject(new Card(rank,suit), x , q);
            }
        }
    }
    /**
     * Case "3":
     * Show all 12 face cards (Jacks, Queens, and Kings) in a 
     * grid 3 high and 4 wide, flipped up and down in a checkerboard pattern.
     * Have it arranged so cards with the same suits share a column,
     * and cards with the same faces share a row, and flip down every other
     * card so it looks a bit like the below pattern.
     * Use for loop(s) and only one addObject call.  
     * X O X O
     * O X O X
     * X O X O
     */
    public void case3() {
      // your code here
      int count = 1;  
      int x = getWidth()/4;
      
        for (int suit = 0, y = getHeight()/4; suit<=3; suit++){
            for (int rank = Card.JACK; rank<=Card.KING; rank++){
                Card card = new Card(rank, suit); 
                addObject(card, x , y);
                if (count%2 == 0){
                   card.flipDown();
                }
                count++; 
                y+= getHeight()/6;
          
            }
            y = getHeight()/4;
            x+=getWidth()/6;  
        }
    }
    
    /**
     * Case "4":
     * Generate all even numbered cards of all suits (no face cards)
     * and place them at random positions on the table.
     * Have them rotated and flipped up or down randomly too. 
     * Use for loop(s) and only one addObject call.  
     */
    public void case4() {
      //your code here
      int count = 1;
      
      for (int suit = Card.MIN_SUIT; suit <4; suit++){
         for(int rank = 2;  rank <= Card.MAX_RANK; rank+=2){
             int x= (int) (Math.random() *1000);
             int y = (int) (Math.random() * 500); 
             int rotate = (int) (Math.random() *720); 
             int coinToss = (int) (Math.random()*2); 
             Card card = new Card(rank, suit); 
                addObject(card, x , y);
               card.turn(rotate); 
            
            if (coinToss ==1){
                card.flipDown(); 
            }
             count++; 
            }
        }
    }
    
    /**
     * Case "5":
     * Create your own interesting arrangement of cards - you
     * must have at least 10 cards with no repeats, it
     * must use at least 2 suits, and some cards must be flipped face down. 
     * (Don't repeat any of the above cases
     * - make it different in at least some key way)
     * Use at least 2 nested for loops and only one addObject call. 
     * Describe your arrangement here:
     * >
     * > (Your description goes here)
     * >
     * >
     */
    public void case5() {
      //your code here
      int x = getWidth()/6; 
      int y = getHeight()/4;
      int blop = Card.MAX_RANK; 
      for (int suit = Card.MIN_SUIT; suit<=Card.SPADES; suit++){
           int k = (int)(Math.random()*5);
          for (int rank = blop; rank>=1; rank-=3){
              Card card = new Card(rank, suit); 
              addObject(card, x , y);
              card.turn(90); 
              y+=getHeight()/4; 
              int coinToss = (int) (Math.random()*2); 
              if (coinToss ==1){
                  card.flipDown(); 
                }
            }
            
            if ( k == 3 || k == 4 ){
                blop = Card.QUEEN; 
            }
            if (k ==2){
                blop = Card.JACK; 
            }
            else{
                blop = k+6;
            }
            y = getHeight()/4; 
            x+=200;
        }
    }    
    
    
    /**
     * When a number key from 1 to 5 is pressed, 
     * remove all Objects and run the corresponding case
     * 
     * Already partially implemented for you to run case1 appropriately.
     * You need to update it to work for all 5 cases, and to use a 
     * switch statement instead of if-else statements.
     */
    public void act() 
    {
      String key = Greenfoot.getKey();
      if (key != null && !key.equals(lastKey)) {
        removeObjects(getObjects(null));
        switch(key){    
            case(("1")):
                case1();
                break;
            
            case(("2")):
                case2(); 
                break;
            
            case(("3")):
                case3();
                break;
            
            case(("4")):
                case4();
                break; 
            
            case(("5")):
                case5(); 
                break;
        
        }
      }
    }
}
