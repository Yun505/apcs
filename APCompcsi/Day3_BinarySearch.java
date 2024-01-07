// commented because annoying prob
//import java.util.Arrays;

public class Day3_BinarySearch {

  /** 
   Provided as a reminder of the while loop implementation of binary search.
   */
  public static int binarySearch_withLoop (int[] a, int num) {
    int low = 0;
    int high = a.length - 1;

    while (high >= low) {
      int pos = (high + low) / 2;

      if (num == a[pos])
        return pos;
      else if (num > a[pos])
        low = pos + 1;
      else
        high = pos - 1;
    }

    return -1;
  }
  
  /**
   *  This is the one we will implement! Recursion!
   */
  public static int binarySearch(int[] list, int val) {
    return binarySearch(list, val, 0, list.length - 1);
  }

  private static int binarySearch(int[]list, int num, int low, int high) {
    if (high < low) {
      return -1;
    }

    int pos = (high + low) / 2;

    if (num == list[pos]) {
      return pos;
    }

    else if (num > list[pos]) {
      return binarySearch(list, num, pos+1, high);
    }
    else {
      return binarySearch(list, num, low, pos-1);
    }
  }



  public static void main (String[] args) {
    int[] list = {1, 3, 4, 5, 7, 9, 14, 15, 16, 25, 35, 89, 95, 100, 105};
    System.out.println(binarySearch(list, 27));
  }
}