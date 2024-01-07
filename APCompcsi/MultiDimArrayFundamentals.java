import java.util.Arrays;

public class MultiDimArrayFundamentals {

    /**
     * Print the 2d array in row major order.
     * Works with jagged arrays.
     * Format each int to print with 4 characters.
     */
    public static void printArray(int[][] ma) {
        for (int i =0; i < ma.length; i++){
            for(int j=0; j< ma[i].length; j++){
              System.out.printf("%4d", ma[i][j]);
            }
            System.out.println(); 
          }
    }

    /**
     * Compares two 2d arrays. Returns true if they are identical, false otherwise.
     * Returns false if the arrays are a different shape -- should not throw an exception.
     * Works with jagged arrays.
     */
    public static boolean equals(int[][] a, int[][] b) {
      if (a.length != b.length){
        return false; 
      }
      for (int i =0; i < a.length; i++){
        if (a[i].length != b[i].length){
          return false; 
        }

        for(int j=0; j< a[i].length; j++){
          if (a[i][j] != b[i][j]){
            return false;
          }
        }
      }
        return true;
    }

    /**
     * Fill 2d array with int "fill".  After this method runs, all positions in the array will 
     * have the same value.
     * For example: 
     *    Given the array ma={{5,7},{16,23,4},{7}}; fill = 5
     *    After the method runs, ma will now equal {{5,5},{5,5,5},{5}}
     */
    public static void fillWith(int[][] ma, int fill) {
      for (int i = 0; i < ma.length; i++) {
        for (int j = 0; j < ma[i].length; j++) {
          ma[i][j] = fill;
        }
      }
    }
    
    


    /**
     * Fill 2d array with ascending numbers starting from 1. 
     * For example: 
     *    Given the array ma={{5,7},{16,23,4},{7}} 
     *    After the method runs, ma will now equal {{1,2},{3,4,5},{6}}
     */
    public static void numberEveryCell(int[][] ma) {
      int count = 1; 
      for (int i = 0; i < ma.length; i++) {
        for (int j = 0; j < ma[i].length; j++) {
          ma[i][j] = count;
          count++; 
        }
      }
    }

    /**
     * Creates and returns a deep copy of the passed array 'oldArr'
     */
    public static int[][] deepCopy(int[][] oldArr) {
      int[][] newArr = new int[oldArr.length][];

      for (int i = 0; i < oldArr.length; i++) {
        newArr[i] = new int[oldArr[i].length]; 
        for (int j = 0; j < newArr[i].length; j++) {
          newArr[i][j] = oldArr[i][j]; 
        }
      }
      return newArr; 
    }


    /**
     * Get the value of 2d arr at pos.  "pos" is the index if arr was 
     * "flattened" or read in row-major order.
     * If no such position, throw an IndexOutOfBoundsException
     * NOTE: Only works for rectangular arrays, behaviour undefined for jagged arrays
     * Do NOT use a  loop in the implementation. 
     * <p>
     * Example: if arr = {{14, 15, 16},{1,5,9},{18,7,6}}
     * getValueRect(arr, 3) returns 1
     * getValueRect(arr, 5) returns 9
     * getValueRect(arr, 9) throws an exception
     */
    public static int getValueRect(int[][] arr, int pos) {
        //- can be done WITHOUT loops.
        
        int row = pos / arr[0].length;
        int col = pos % arr.length;

        if (row >= arr.length || col >= arr[0].length || pos < 0){
          throw new IndexOutOfBoundsException("Invalid pos.");
        }
        return arr[row][col]; 
    }

    /**
     * This method has the same behavior as getValueRect except it works with jagged arrays.
     * If no such position, throw an IndexOutOfBoundsException
     * NOTE: Works for jagged arrays
     */
    public static int getValueJagged(int[][] arr, int pos) {
      int count = 0; 
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
          if (count == pos){
            return arr[i][j];
          }
          count++; 
        }
      }
        throw new IndexOutOfBoundsException(); 
    }

    /**
     * Gets (copy of) row from 2d arr
     * Works for jagged arrays.
     * Must create a deep copy of the row.
     * <p>
     * If "row" is invalid, the method throws an ArrayIndexOutOfBoundsException.
     */
    public static int[] getRow(int[][] arr, int row) {
      int[] newArr = new int[arr[row].length];
      for (int i = 0; i< arr[row].length; i++){
        newArr[i] = arr[row][i];
      }
      return newArr;
    }

    /**
     * Gets (copy of) column from 2d arr
     * Won't work for jagged arrays if any row's length is < col
     * <p>
     * If "col" is invalid, the method throws an ArrayIndexOutOfBoundsException.
     */
    public static int[] getCol(int[][] arr, int col) {
        int[] columnCopy = new int[arr.length];
        for (int i = 0; i < columnCopy.length; i++){
          columnCopy[i] = arr[i][col]; 
        }
        return columnCopy;
    }

    /**
     * Reshapes arr (1d) into a rectangular array with row length of "rowLength"
     * If arr's length is not divisible by rowLength, throws an
     * IllegalArgumentException
     */
    public static int[][] reshape(int[] arr, int rowLength) {
      if (arr.length % rowLength != 0)
          throw new IllegalArgumentException("arr.length not divisible by rowLength");

      int rows = arr.length / rowLength;
      
      int[][] grid = new int[rows][rowLength];
      int pos = 0;
      for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[i].length; j++){
          grid[i][j] = arr[pos++];
        }
      }
      return grid;
    }

    /**
     * Flattens arr (2d) into a 1d array, elements in row-major order.
     * Works even with jagged arrays!
     */
    public static int[] flatten(int[][] arr) {
      int count = 0;
        for (int i = 0; i < arr.length; i++){
            count += arr[i].length; 
        }
        int[] flattenedArray = new int[count];
        int pos = 0;

        for (int i = 0; i < arr.length; i++){
          for (int j = 0; j < arr[i].length; j++){
            flattenedArray[pos] = arr[i][j]; 
            pos++;
          }
        }
        return flattenedArray;
    }

    /**
     * Creates a 2d array that has two rows with the contents of row1 and row2.
     * This method must perform a deep copy of the contents of row1 and row2.
     */
    public static int[][] packRows(int[] row1, int[] row2) {
      int[][] packedArray = new int[2][]; //don't yet initialize size of subarrays - may be jagged!
    
      packedArray[0] = new int[row1.length];
      for(int i = 0; i < row1.length; i++)
        packedArray[0][i] = row1[i];
      
      packedArray[1] = new int[row2.length];
      for(int i = 0; i < row2.length; i++)
        packedArray[1][i] = row2[i];
      
      return packedArray;
  
    }


    public static void main (String[] args) {
        int[][] sample = {{9,14,2},{3,8},{45,31,-4,2}};
    
        System.out.println("printArray Test");
        printArray(sample);
        System.out.println();
    
        //
        // equals
        //
        int[][] sample1 = {{9,14,2},{3,8},{45,31,-4,2}};
        if (equals(sample, sample1)) {
          System.out.println("equals 1 -- passed");
        } 
        else {
          System.out.println("equals 1 -- failed");
        }
    
        int[][] sample2 = {{9,14,2},{3,8},{45,31,-4,3}};
        if (!equals(sample, sample2)) {
          System.out.println("equals 2 -- passed");
        } 
        else {
          System.out.println("equals 2 -- failed");
        }
    
        int[][] sample3 = {{9,14,2},{3,8}};
        if (!equals(sample, sample3)) {
          System.out.println("equals 3 -- passed");
        } 
        else {
          System.out.println("equals 3 -- failed");
        }
    
        int[][] sample4 = {{9,14,2},{3},{45,31,-4,3}};
        if (!equals(sample, sample4)) {
          System.out.println("equals 4 -- passed");
        } 
        else {
          System.out.println("equals 4 -- failed");
        }
    
        //
        // fillWith
        //
        fillWith(sample, 3);
        if (equals(sample, new int[][]{{3,3,3},{3,3},{3,3,3,3}})) {
          System.out.println("fillWith -- passed");
        } 
        else {
          System.out.println("fillWith -- failed");
        }
    
        //
        // fillWith
        //
        numberEveryCell(sample);
        if (equals(sample, new int[][]{{1,2,3},{4,5},{6,7,8,9}})) {
          System.out.println("numberEveryCell -- passed");
        } 
        else {
          System.out.println("numberEveryCell -- failed");
        }
    
        //
        // deepCopy
        //
        int[][]dc={{9,2,6},{},{6},{65,2}};
        int[][] dc2 = deepCopy(dc);
        dc[0][1] = 15;
    
        if (equals(dc2, new int[][]{{9,2,6},{},{6},{65,2}})) {
          System.out.println("deepCopy -- passed");
        } 
        else {
          System.out.println("deepCopy -- failed");
        }
    
        //
        // getValueRect
        //
        int[][] varr = {{14, 15, 16},{1,5,9},{18,7,6}};
        if (getValueRect(varr, 3) == 1) {
          System.out.println("getValueRect -- passed 1");
        }
        else {
          System.out.println("getValueRect -- failed 1");
        }
    
        if (getValueRect(varr, 5) == 9) {
          System.out.println("getValueRect -- passed 1");
        }
        else {
          System.out.println("getValueRect -- failed 1");
        }
    
    
        //
        // getValueJagged
        //
        int[][] varr2 = {{14, 15, 16},{1},{18,7}};
        if (getValueJagged(varr2, 3) == 1) {
          System.out.println("getValueJagged -- passed 1");
        }
        else {
          System.out.println("getValueJagged -- failed 1");
        }
    
        if (getValueJagged(varr2, 5) == 7) {
          System.out.println("getValueJagged -- passed 2");
        }
        else {
          System.out.println("getValueJagged -- failed 2");
        }
    
        //
        // getRow
        //
        int[][] varrRow = {{14, 15, 16},{1,7},{12,9,18,7},{17}};
        int[] row = getRow(varrRow,2);
        varrRow[2][3] = -1;
    
        if (Arrays.equals(row, new int[] {12,9,18,7})) {
          System.out.println("getRow -- passed");
        } 
        else {
          System.out.println("getRow -- failed");
        }
      
    
        //
        // getColumn
        //
        int[][] varrColumn = {{14, 15, 16},{1,7,4},{12,9,18,7},{17,23,95,72}};
     
        int[] column = getCol(varrColumn,2);
        if (Arrays.equals(column, new int[] {16,4,18,95})) {
          System.out.println("getColumn -- passed");
        } 
        else {
          System.out.println("getColumn -- failed");
        }
     
        //
        // reshape
        //
        int[] arrReshape = {1,2,3,5,6,7,9,10,11,13,14,15};
        int[][] arr2Reshape = reshape(arrReshape, 3);
    
        if (equals(arr2Reshape, new int[][] {{1,2,3},{5,6,7},{9,10,11},{13,14,15}})) {
          System.out.println("reshape -- passed");
        } 
        else {
          System.out.println("reshape -- failed");
        }
    
        //
        // flatten
        //
        int[][] arr2Flatten = {{4,5},{9},{17,12,6},{},{99,4,18}};
        int[] arrFlattened = flatten(arr2Flatten);
    
        if (Arrays.equals(arrFlattened, new int[]{4,5,9,17,12,6,99,4,18})) {
          System.out.println("flatten -- passed");
        } 
        else {
          System.out.println("flatten -- failed");
        }
    
    
        //
        // packRows
        //
        int[] r1 = {5, 7, 2};
        int[] r2 = {1, 3, -4};
    
        int[][]packed = packRows(r1, r2);
        r1[0]=5;
        r2[2]=1;
    
        if (equals(packed, new int[][] {{5, 7, 2},{1, 3, -4}})) {
          System.out.println("packRows -- passed");
        } 
        else {
          System.out.println("packRows -- failed");
        }
    
    }  
}