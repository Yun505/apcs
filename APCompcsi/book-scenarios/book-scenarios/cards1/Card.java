import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Card represents a standard playing card.
* As first implemented, all cards are the suit of Diamonds.
* When finished, the class should be abstracted for all 4 suits.
* It should also be able to flip front and back when clicked.
* @author (your name) 
* @version (a version number or a date)
*/
public class Card extends Actor
{
  
  
  public static final int KING = 13;
  public static final int QUEEN = 12;
  public static final int JACK = 11;
  public static final int ACE = 1;
  public static final int MAX_RANK = KING;
  public static final int MIN_RANK = ACE;
    
  private static final GreenfootImage CARD_BACK = new GreenfootImage("cardBack_blue2.png");
  private final GreenfootImage CARD_FRONT;
    
  
  private int rank;
  //CODE I ADDED
  private int suit;
  public static final int DIAMONDS = 0;
  public static final int CLUBS = 1;
  public static final int  HEARTS = 2;
  public static final int SPADES = 3;
  public static final int MAX_SUIT = SPADES;
  public static final int MIN_SUIT = DIAMONDS; 
  public static boolean flips = true; 

  
  //
  // Constructor for a Card.  The values of rank are defined by the constants above.
  // TODO: Update this constructor so that a Card is constructed with both a rank and a suit.
  // 
  public Card(int rank,int suit) {
    this.rank = rank;
    this.suit = suit;
    CARD_FRONT = new GreenfootImage("card" + suitToString(suit) + rankToString(rank) + ".png");
    flipUp();
  }
  
  //
  // Overloaded constructor that calls another constructor with "this" keyword
  // TODO: Add suit as a second parameter for this constructor.
  //
  public Card(String rank, String suit) {
    this(rankToInt(rank),suitToInt(suit));
  }
   
  // Create a "getter" method like getRank() 
  // that returns the suit of the card.
  
  public int getRank() {
    return rank;
  }
  //getter method for suit
  public int getSuit(){
      return suit; 
    }
  public static String rankToString(int rank) {
    String strRank;
    switch (rank) {
      case ACE: strRank = "A"; 
        break;
      case JACK: strRank = "J";
        break;
      case QUEEN: strRank = "Q";
        break;
      case KING: strRank = "K";
        break;
      default: strRank = Integer.toString(rank);
        break;
    }
    return strRank;
  }
  
  public static int rankToInt(String strRank) {
    
    int intRank;
    switch (strRank.toLowerCase()) {
      case "a": 
      case "ace":
        intRank = ACE; 
        break;
      case "j":
      case "jack":
        intRank = JACK; 
        break;
      case "q":
      case "queen":
        intRank = QUEEN; 
        break;
      case "k":
      case "king":
        intRank = KING; 
        break;
      default: intRank = Integer.parseInt(strRank);
        break;
    }
    return intRank;
  }
  
  //Implement two public static "helper" methods similar to
  //the two above; one that converts representations of the 
  //suit from an int to a String (namely, "Diamonds", "Clubs", "Hearts", and "Spades")
  //and the other from String to int (for example, "d", "diamond", "diamonds", 
  // and any capitalization variant of those to whatever int represents
  // Diamonds)
  public static String suitToString(int suit) {
    String strSuit;
    switch (suit) {
      case DIAMONDS: strSuit = "Diamonds"; 
        break;
      case CLUBS: strSuit = "Clubs";
        break;
      case HEARTS: strSuit = "Hearts";
        break;
      case SPADES: strSuit = "Spades";
        break;
      default: strSuit = Integer.toString(suit);
        break;
    }
    return strSuit;
  }
  public static int suitToInt(String strSuit) {
    
    int intSuit;
    switch (strSuit.toLowerCase()) {
      case "d": 
      case "diamonds":
      case "diamond":
        intSuit = DIAMONDS; 
        break;
      case "c":
      case "clubs":
      case "club":
        intSuit = CLUBS; 
        break;
      case "h":
      case "hearts":
      case "heart":
        intSuit = HEARTS; 
        break;
      case "s":
      case "spades":
      case "spade":
        intSuit = SPADES; 
        break;
      default: intSuit = Integer.parseInt(strSuit);
        break;
    }
    return intSuit;
  }
  
  // Implement the public methods flipDown so that it changes the image to CARD_BACK 
  // and flip() so that it flips between the front and back.
  // You may want to edit flipUp() as well.
  //

  public void flipUp() {
    setImage(CARD_FRONT);
    flips = true; 
  }
  public void flipDown() {
    //your code here
    setImage(CARD_BACK); 
    flips = true; 
  }
  
  public void flip() {
    //your code here
    flips = false; 
    if (getImage() == CARD_FRONT && flips ==false){
        flipDown(); 
    }
    if (getImage() == CARD_BACK && flips == false){
        flipUp(); 
    }
  }

  
  /**
   * If clicked on by the mouse, flip the card.
   */
  public void act() 
  {
    //your code here
    if(Greenfoot.mousePressed(this)){
        flip();
        }
  }    
}
