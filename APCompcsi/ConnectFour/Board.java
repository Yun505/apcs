package ConnectFour;

/** Implements a ConnectFour board */
public class Board {
  static final int ROWS = 6; // The number of rows on the board.
  static final int COLUMNS = 7; // The number of columns on the board.

  // board is the instance variable that stores the actual board, a 2-array of chars.
  // The possible characters stored in the board include:
  //  ' ' - Empty Space
  //  'R' - Red checker
  //  'Y' - Yellow checker
  private char[][] board;

  /** Constructor of a Board object.
    *
    * Instantiates the 'board' variable and initializes all of the cells to ' '.
    */
  public Board() {
    board = new char[ROWS][COLUMNS];
    for (int i = 0; i < ROWS; i++) {
      board[i] = new char[COLUMNS];
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = ' ';
      }
    }
  }

  /** Writes the current board to System.out, per the format in the assignment PDF. */
  public void draw() {
    for (int i = 0; i < ROWS; i++) {
      System.out.println(); 
      for (int j = 0; j < COLUMNS; j++) {
        System.out.print("|" + board[i][j]);
        if(j == 6){
          System.out.print("|");
        }
      }
    }
    System.out.println("\n-----------------");
  }

  /** Attempts to drop the specified checker in the specified column.  If the checker is
    * successfully dropped, the method adds the checker to the board variable and returns true.
    * If the specified column is full, the method returns false.
    */
  public boolean dropChecker(int column, char checker) {
      for (int i = ROWS - 1; i > -1; i--){
        if (board[i][column] != 'R' && board[i][column] != 'Y'){
          board[i][column] = checker;
          return true;
        }
      }
    return false;
  }

  /** Determines if the game has a winner.  The method returns true if either user
    * has four in a row in any direction.
    **/
  public boolean checkWinner() {
    //rows
    for (int i = 0; i < ROWS; i++){
     for(int j = 0; j < board[i].length-3; j++){
      if(board[i][j] == 'R' || board[i][j] == 'Y'){
        if(board[i][j+1] == board[i][j] && board[i][j+2] == board[i][j+3] && board[i][j] == board[i][j+3]){
          return true; 
        }
      }
     }
    }

    //columns
    for (int i = 0; i < ROWS-3; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == 'R' || board[i][j] == 'Y'){
          if(board[i+1][j] == board[i][j] && board[i+2][j] == board[i+3][j] && board[i][j] == board[i+3][j]){
            return true;
          }
        }
      }
    }

    //diagonal left
    for (int i = 0; i < ROWS-3; i++){
      for (int j = 0; j < board[i].length-3; j++){
        if(board[i][j] == 'R' || board[i][j] == 'Y'){
          if(board[i][j] == board[i+1][j+1] && board[i+2][j+2] == board[i+3][j+3] && board[i][j] == board[i+3][j+3]){
            return true;
          }
        }
      }
    }


    // //diagonal right
    for (int i = 0; i < ROWS-3; i++){
      for (int j = board[i].length-1; j > 2; j--){
        if(board[i][j] == 'R' || board[i][j] == 'Y'){
          if(board[i][j] == board[i+1][j-1] && board[i+2][j-2] == board[i+3][j-3] && board[i][j] == board[i+3][j-3]){
            return true;
          }
        }
      }
    }
    return false;
  }

  /** Determines if the game is a draw.
    * This method assumes the user already checked if there is a winner via a call to
    * checkWinner. This method returns true if there are no more blank squares. */
  public boolean checkDraw() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if(board[i][j] == ' '){
          return false;
        }
      }
    }
    return true;
  }
}
