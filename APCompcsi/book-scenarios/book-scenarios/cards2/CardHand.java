import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CardHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardHand extends Actor {
    //Don't worry about these:
    private static final int xSpace = 5;
    private static final int ySpace = 10;
    private String lastKey = "";
    
    //You should understand and use these:
    private Card[] cards;
    private int numCards;
    
    /**
     * IMPLEMENTED FOR YOU
     * Constructs an empty hand with the specified initial capacity.
     */
    public CardHand(int capacity) {
        cards = new Card[capacity];
        numCards = 0;
    }
    
    /**
     * Appends the specified Card to the end of this hand.
     */ 
    public void add (Card c) {
        cards[numCards] = c; 
        numCards++; 
    }
    
    /**
     * Inserts the specified Card at the specified position in this hand.
     * Shifts the Card currently at that position (if any) and any 
     * subsequent Cards to the right (adds one to their indices).
     */ 
    public void add (int index, Card c) {
        //copy of array
        Card[] blopp = new Card[cards.length];
        for (int b = 0; b<size(); b++){
            blopp[b] = cards[b];
        }
        //shifting
        for (int a =index; a< size(); a++){
            
                cards[a+1] = blopp[a]; 
            
        }
        cards[index] = c; 
        numCards++;
    }
    
    /**
     * Returns the Card at the specified position in this hand.
     */
    public Card get(int i) { 
        return cards[i]; 
    }
    
    /**
     * Returns the number of Cards in this hand.
     */
    public int size() {
        return numCards;  
    }    
    
    /**
     * Returns true if this hand contains no Cards.
     */ 
    public boolean isEmpty() {
        if (numCards == 0){
            return true; 
        }
        return false;
    }    
    
    /**
     * Returns true if this hand contains the specified Card.
     */ 
    public boolean contains(Card c) {
        for (int i = 0; i<size(); i++){
            if (cards[i].equals(c)){
                return true; 
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the first occurrence of the specified Card in this list,
     * or -1 if this hand does not contain the Card.
     */ 
    public int indexOf(Card c) {
        for (int i = 0; i<size(); i++){
            if (cards[i].equals(c)){
                return i; 
            }
        }
        return -1;
    } 
    
    /**
     * Returns the index of the last occurrence of the specified Card in this list,
     * or -1 if this hand does not contain the Card.
     */
    public int lastIndexOf(Card c) {
        for (int i = numCards-1; i>=0; i--){
            if (cards[i].equals(c)){
                return i; 
            }
        }
        return -1;
    }
    
    /**
     * Removes the Card at the specified position in this hand. 
     * Shifts any subsequent Cards to the left 
     * (subtracts one from their indices).
     * Returns the Card that was removed from the hand.
     */
    public Card remove (int index) {
        // new array storing removed card + copy of array
        int d = index;
        Card[] removed = new Card[1];
        removed[0] = cards[index];
        Card[] blopp = new Card[cards.length];
        for (int b = 0; b<size(); b++){
            blopp[b] = cards[b];
        }
        //shifting
        for (int a =index+1; a< size(); a++){
                cards[a-1] = blopp[a]; 
           
        }
        numCards--;
        return removed[0];
        
    }
    
    /**
     * Removes the first occurrence of the specified 
     * Card from this hand.
     * Shifts any subsequent Cards to the left 
     * (subtracts one from their indices).
     * If the hand does not contain the Card, it is unchanged.
     * 
     * Returns true if this hand contained the specified Card.
     */
    public boolean remove (Card c ) {
        if ((indexOf(c))!= -1){
             remove((indexOf(c))); 
             return true; 
        }
        return false; 
    }
    
    /**
     * Removes all of the Cards from this hand. 
     * The hand will be empty after this call returns.
     */
    public void clear() {         
        for(int b = 0; b<size(); b++){
            cards[b] = null; 
        }
        numCards=0;
    }
    
    /**
     * Shuffles the order of the Cards in this hand.
     * (This method is nearly the same as the one in CardTable)
     * 
     * DEBUGGING SUGGESTION: Put
     *    debugPause("Step " + <loopvar>, 60);
     * at the end of the loop to see each "step" of the algorithm.
     */ 
    public void shuffle() {
        Card[] replace = new Card[1]; 
        for ( int i =0; i<size(); i++){
            int j = (int)(Math.random()* (size()-i))+i;
            replace[0] = cards[i];
            cards[i] = cards[j];
            cards[j] = replace[0];
        }
    }
    
    /**
     * Sorts the Cards in this hand using the Selection Sort algorithm.
     * Use the Card object's .compareTo method to compare Cards. 
     * 
     * DEBUGGING SUGGESTION: Put
     *    debugPause("Step " + <loopvar>, 60);
     * at the end of the outer loop to see each "step" of the algorithm.
     */
    public void selectionSort() {
        Card[] replace = new Card[1]; 
       for (int i = 0; i<size()-1; i++){
            int  smPos = i; 
            for ( int j= i+1; j<size(); j++){
                if (cards[j].compareTo(cards[smPos]) <0){
                    smPos = j; 
                }
            }
            replace[0]= cards[i]; 
            cards[i] =  cards[smPos];
            cards[smPos] = replace[0]; 
        }
    }
    
    /**
     * Sorts the Cards in this hand using the Selection Sort algorithm.
     * Use the Card object's .compareTo method to compare Cards. 
     * 
     * DEBUGGING SUGGESTION: Put
     *    debugPause("Step " + <loopvar>, 60);
     * at the end of the outer loop to see each "step" of the algorithm.
     */
    public void insertionSort() {
        Card[] replace = new Card[1]; 
        for (int i =1; i<size(); i++){
                replace[0] = cards[i];
                int j = i-1;
                while (j>= 0 && cards[j].compareTo(replace[0])==1){
                    cards[j+1]= cards[j];
                    j--;
                }
                cards[j+1]=replace[0];
        }
    }
    
    /**
     * IMPLEMENTED FOR YOU
     * A useful method for debugging your shuffle and sort methods.
     * Sets position of cards in hand and repaints the world.
     * Prints a temporary message above the CardHand and pauses for pauseCycles.
     */
    private void debugPause(String message,int pauseCycles) {
        World myWorld = getWorld();
        myWorld.showText(message, getX(), getY() - 20);
        setCardCoordinates();
        myWorld.repaint();
        Greenfoot.delay(pauseCycles);
        myWorld.showText("", getX(), getY() - 20);
    }
    
    /**
     * IMPLEMENTED FOR YOU
     * Sets the position of all Cards in the hand.
     */
    private void setCardCoordinates() {
        if (size() > 0) {
            int x = getX() - ((size()-1) * (Card.CARD_BACK.getWidth() + xSpace))/2;
            int y = getY() + Card.CARD_BACK.getHeight() + ySpace;
            for (int i=0; i<size(); i++) {
                get(i).setLocation(x,y);
                x+= Card.CARD_BACK.getWidth() + xSpace;
            }
        }
    }   
    
    /**
     * IMPLEMENTED FOR YOU
     * Sets the coordinates of all Cards in the hand.
     * Checks if certain keys are pressed and performs 
     * special actions (clear, shuffle, selectionSort, and insertionSort)
     * when pressed.
     */
    public void act() {
        setCardCoordinates();
        
        String key = Greenfoot.getKey();
        if (key != null && !key.equals(lastKey)) {
            
            switch(key){
                case "1":    
                    clear();
                    break;  
                case "2":    
                    shuffle();
                    break;
                case "3":
                    selectionSort();
                    break;
                case "4": 
                    insertionSort();
                    break;
                default:
                    break;
            }
        }
        lastKey = key;
    }
}
