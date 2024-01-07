import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays; 
/**
 * CardTable is a 2D surface for Card objects to sit on. 
 */
public class CardTable extends greenfoot.World
{
    private final CardHand hand;
    
    /**
     * IMPLEMENTED FOR YOU
     * Constructor for objects of class CardTable.
     */
    public CardTable()
    {    
        // Create a new world with 1000x500 cells with a cell size of 1x1 pixels
        super(1000,500, 1);
        //Create deck of all 52 cards
        Card[] deck = createAllCards();
        //Shuffle that deck
        shuffle(deck);
        //"Deal" the first 20 (or fewer) cards in deck to the World in two rows
        for(int i = 0; i < 20 && i < deck.length; i++){
            int x = (i/2 % 10) * 100 + 50;
            int y = (i % 2) * 100 + 100;
            addObject(deck[i], x, y);
            deck[i].setHome();
        }
        //Create a new Hand with max size 12
        hand = new CardHand(12);
        addObject(hand, getWidth()/2,300);
        
        showText("Click a card on top to add it to the Hand below.", getWidth()/2,25);
        showText("Click a card in the Hand to remove it.", getWidth()/2,getHeight() - 30);
        showText("Press '1' to clear, '2' to shuffle, '3' for selection sort, and '4' for insertion sort.", getWidth()/2,getHeight() - 15);
    }
    
    public CardHand getHand(){
        return hand;
    }
    
    /** 
     * Returns an array filled with all possible Cards (a full deck).
     */
    public Card[] createAllCards(){
        Card[] blop = new Card[52]; 
        int count = 0; 
        for (int suit= Card.DIAMONDS; suit <=Card.SPADES; suit++){
            for (int rank = Card.ACE; rank<= Card.KING; rank++){
                blop[count] = new Card(rank, suit); 
                count++; 
            }
        }
        return blop;
    }
    
    /** 
     * Shuffles a card array with the Fisher-Yates shuffle:
     * For each index i, pick a random card from i through
     * the end of the array and swap it into index i.
     */
    public static void shuffle(Card[] arr){
        Card[] replace = new Card[1]; 
        for ( int i =0; i<arr.length; i++){
            int j = (int)(Math.random()* (arr.length-i))+i;
            replace[0] = arr[i];
            arr[i] = arr[j];
            arr[j] = replace[0];

        }
    }
    
    /**
     * IMPLEMENTED FOR YOU
     * Put any cards not in the Hand back to its original spot
     * Assumes the contains() method in CardHand works!
     */
    public void act() {

        for( Card c : getObjects(Card.class)) {
            if(!hand.contains(c)){
                c.goHome();
            }
    
        }
    }
}
