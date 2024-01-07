public class MagicBoxChecker {
  public static boolean isSolution(int[][]box) {
    return isNormal(box) && isMagic(box);
  }

  /** Verifies that each value in the box is unique and in the range [1, m*n]. */
  public static boolean isNormal(int[][] box) {
    //box is an m-by-n 2d-array
    int m = box.length; //num rows or height
    int n = box[0].length; //num columns or width
    int size = m*n;
    
    //Check if each item in the box is unique 
    //and within range of 1 and m*n
    
    //Boolean array values default to false
    //Extra throwaway [0] index for convenience
    boolean[] seen = new boolean[size + 1];
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int num = box[i][j];
        
        if ((num <= 0) || (num > size) || seen[num])
          return false;
        else
          seen[num] = true;
      }
    }
    return true;
  }

  /** Assumes the box isNormal.
   * Verifies that each row and each column has the same sum.
   * (Note that columns can have different sums from rows for rectangles.)
   * For boxes, also check that the diagonals have this sum.
   */
  public static boolean isMagic(int[][] box) {
    //box is an m-by-n 2d-array
    int m = box.length; //num rows
    int n = box[0].length; //num columns

    //We can actually determine what the sum must be: the total of all the
    //numbers divided by the number of rows/columns:
    
    int total = 0;
    for (int[] row : box){
      for (int i : row) {
        total += i;
      }
    }
    
    int correct_row_sum = total / m;
    int correct_col_sum = total / n;
    
    //Add up each row
    for(int i = 0; i < m; i++) {
      int row_sum = 0;
      for(int j = 0; j < n; j++) {
        row_sum += box[i][j];
      }
      if (row_sum != correct_row_sum)
        return false;
    }
    
    //Add up each col
    for(int j = 0; j < n; j++) {
      int col_sum = 0;
      for(int i = 0; i < m; i++) {
        col_sum += box[i][j];
      }
      if (col_sum != correct_col_sum)
        return false;
    }
    
    //If square shaped, check diagonals too.
    if(m == n) {
      int down_diag_sum = 0;
      for(int i = 0; i < m; i++)
        down_diag_sum += box[i][i];
      if (down_diag_sum != correct_row_sum)
        return false;
      
      int up_diag_sum = 0;
      for(int i = 0; i < m; i++)
        up_diag_sum += box[i][n-i-1];
      if (up_diag_sum != correct_row_sum)
        return false;
    }
    
    //If we've made it this far, sums are good!
    return true;
    
  }
}