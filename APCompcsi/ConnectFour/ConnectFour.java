package ConnectFour;
//(annoying error)import ConnectFour.Board;
import java.util.Scanner;

public class ConnectFour {
  // Player 0 is Red; Player 1 is Yellow
  // Use the following arrays to get a label or checker letter for the player.
  static String colorLabelCaps[] = { "Red", "Yellow" };
  static String colorLabel[] = { "red", "yellow" };
  static char colorChar[] = { 'R', 'Y' };
  
  public static void main(String[] args) {
    int player = 0;  // Player 0 is red; Player 1 is yellow.  
    
    Board board = new Board();
    Scanner input = new Scanner(System.in);
    board.draw();
    while (board.checkWinner() == false && board.checkDraw() == false) {
      System.out.println("\nDrop a " + colorLabel[player] + " disk at column (0-6):");
      String chosen_column = input.nextLine();
      int column_int = Integer.parseInt(chosen_column);

      if (board.dropChecker(column_int, colorChar[player]) == true){
        if (player == 0){
          player = 1;
        }
        else{
          player = 0;
        }
        board.draw();
      }
      else{
        System.out.println("Column Full.");
      }

    }
    if (board.checkDraw() == true){
      System.out.println("The game has ended in a draw.");
    }
    else{
      if (player == 0){
        player = 1;
      }
      else{
        player = 0;
      }
      System.out.println("\n" + colorLabelCaps[player] + " wins!!!\n");
    }
    //
    //  Once the program gets here, the game has either been won or ended in a draw.
    //   Determine which case is true and print out the final board along with a message 
    //  to the user.
    // 
    //annoyin gpoorblm below
    input.close();
  }
}
