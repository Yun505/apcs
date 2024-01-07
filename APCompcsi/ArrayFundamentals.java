import java.util.Arrays;

public class ArrayFundamentals {

 /**
  * Returns the position of the largest element of the array. If the element
  * appears in two places in the array, the first index of the element will
  * be returned.
  */
 public static int positionOfLargest(int[] nums) {
  //
  
  //
  int pos = 0;
  for (int i =1; i<nums.length; i++){
      if (nums[i] >nums[pos]){
          pos = i; 
      }
  }

  return pos;
 }

 /**
  * Returns the first index of "val" in the array. If "val" is not in the
  * array, returns -1. The array is not in sorted order.
  */
 public static int indexOf(int[] nums, int val) {
  //
 
  // 
  for (int i = 0; i<nums.length; i++){
      if (nums[i] ==val){
          return i; 
      }
  }
  return -1;
 }

  /**
  * Returns the number of times "val" appears in the array.  If "val" is not 
  * in the array, returns 0.
  */
  public static int count(int[] nums, int val) {
      int count = 0; 
    for (int i = 0; i<nums.length; i++){
        if (nums[i] ==val){
            count++;
        }
    }
    return count;
 
   }


 /**
  * Returns the last index of "val" in the array. If "val" is not in the
  * array, returns -1. The array is not in sorted order.
  */
 public static int lastIndexOf(int[] nums, int val) {
  //
  
  // 
  for (int i = nums.length-1; i>=0; i--){
    if (nums[i] ==val){
        return i; 
    }
}
return -1;
 }

 /**
  * Moves all elements of the array left by one position. The right-most
  * element of the array receives the value from the left-most element. For
  * example, rotateLeft ({9, 12, 14, 43}) becomes {12, 14, 43, 9}.
  */
 public static void rotateLeft(int[] nums) {
  //
  
  // 
  int t = nums[0];
  for (int i = 0; i<nums.length-1; i++){
      nums[i] = nums[i+1];
  }
  nums[nums.length-1] = t; 
 }

 /**
  * Moves all elements of the array right by one position. The left-most
  * element of the array receives the value from the right-most element. For
  * example, rotateRight ({9, 12, 14, 43}) becomes {43, 9, 12, 14}.
  */
 public static void rotateRight(int[] nums) {
  //
 
  // 
  int t = nums[nums.length-1];
  for (int i = nums.length-1; i>0; i--){
      nums[i] = nums[i-1];
  }
  nums[0] = t; 
 

 }

 /**
  * Swaps values of the array at position p1 with the element at position p2.
  * For example swap ({14, 29, 16, 2, 8}, 1, 4) will change the array to {14,
  * 8, 16, 2, 29}.
  */
 public static void swap(int[] nums, int p1, int p2) {
  //

  // 
    int t = nums[p1];
    nums[p1] = nums[p2];
    nums[p2] = t; 
 }

 /**
  * Returns a new array whose elements are in the reverse order of array "a"/
  * For example, reverse ({5, 19, 2, 6}) returns {6, 2, 19, 5}.
  */
 public static int[] reverse(int[] a) {
  //

  // 
  int[] b = new int[a.length];
  for (int i = 0; i<a.length; i++){
      b[b.length-1-i] = a[i]; 
  }
  return b;
 }

 /**
  * Returns true is the array is a palindrome, false otherwise. An array is a
  * palidrone if it has symmetry. For example, the following arrays are
  * palindromes: <br>
  * {2, 5, 5, 2}, {17, 14, 17}, {23, 25, 6, 5, 6, 25, 23}, {9, 0, 2, 2, 0, 9}
  * 
  */
 public static boolean isPalindrome(int[] nums) {
  //

  // 
  int i = 0;
  int j = nums.length-1; 
  while(j>i){
      if (nums[i] != nums[j]){
          return false; 
      }
      i++;
      j--; 
  }
  return true;
 }

 /**
  * Returns the position of the first matching pair of numbers in the array.
  * For example, for the array {9, 17, 24, 24, 9, 4, 4, 18}, the function
  * returns 2 since the first pair (24) begins at position 2.
  */
 public static int firstPairPosition(int[] nums) {
  //
 
  // 
  for (int i = 0; i<nums.length-1; i++){
        if (nums[i] ==nums[i+1]){
            return i; 
        }
    }
    return -1;

 }

 /**
  * Returns the position of the last matching pair of numbers in the array.
  * For example, for the array {9, 17, 24, 24, 9, 4, 4, 18}, the function
  * returns 5 since the last pair (4) begins at position 5.
  */
 public static int lastPairPosition(int[] nums) {
  //

  // 
  for (int i = nums.length-2; i>=0; i--){
        if (nums[i] ==nums[i+1]){
            return i; 
        }
    }
    return -1;
 }

 public static void main(String[] args) {
  int[] a = { 19, 12, 45, 1, 4, 19, 21, 12, 45, 3 };

  if (positionOfLargest(a) == 2)
   System.out.println("Passed 1");
  else
   System.out.println("Failed 1");

  if (indexOf(a, 1) == 3)
   System.out.println("Passed 2");
  else
   System.out.println("Failed 2");

  if (indexOf(a, 19) == 0)
   System.out.println("Passed 3");
  else
   System.out.println("Failed 3");

  if (indexOf(a, 55) == -1)
   System.out.println("Passed 4");
  else
   System.out.println("Failed 4");

  if (lastIndexOf(a, 55) == -1)
   System.out.println("Passed 5");
  else
   System.out.println("Failed 5");

  if (lastIndexOf(a, 19) == 5)
   System.out.println("Passed 6");
  else
   System.out.println("Failed 6");
  
  a = new int[] {5, 12, 19, 23};
  rotateLeft(a);
  if (Arrays.equals(a, new int[] {12, 19, 23, 5}))
   System.out.println("Passed 7");
  else
   System.out.println("Failed 7");

  a = new int[] {5, 12, 19, 23};
  rotateRight(a);
  if (Arrays.equals(a, new int[] {23, 5, 12, 19}))
   System.out.println("Passed 8");
  else
   System.out.println("Failed 8");

  a = new int[] {5, 12, 95, 16, 77, 19, 23};
  swap(a, 1, 3);
  if (Arrays.equals(a, new int[] {5, 16, 95, 12, 77, 19, 23}))
   System.out.println("Passed 9");
  else
   System.out.println("Failed 9");
  
  a = new int[] {5, 12, 19, 23};
  int[] b = reverse(a);
  if (Arrays.equals(b, new int[] {23, 19, 12, 5}))
   System.out.println("Passed 10");
  else
   System.out.println("Failed 10");
  
  if (isPalindrome(new int[] {5, 12, 5}))
   System.out.println("Passed 11");
  else
   System.out.println("Failed 11");

  if (!isPalindrome(new int[] {9, 11, 12, 9}))
   System.out.println("Passed 12");
  else
   System.out.println("Failed 12");
  
  if (isPalindrome(new int[] {5, 12, 45, 45, 12, 5}))
   System.out.println("Passed 13");
  else
   System.out.println("Failed 13");
   
  if (firstPairPosition(new int[] {7, 8, 12, 12, 9, 14, 14, 9, 1, 5})== 2)
   System.out.println("Passed 14");
  else
   System.out.println("Failed 14");

  if (firstPairPosition(new int[] {7, 8, 12, 9, 14, 9, 1, 5})== -1)
   System.out.println("Passed 15");
  else
   System.out.println("Failed 15");

  if (lastPairPosition(new int[] {7, 8, 12, 12, 9, 14, 14, 9, 1, 5})== 5)
   System.out.println("Passed 16");
  else
   System.out.println("Failed 16");
  
   if (count(new int[] {7, 7, 12, 7, 9, 7, 14, 9, 1, 5}, 7)== 4)
   System.out.println("Passed 17");
  else
   System.out.println("Failed 17");

  if (count(new int[] {7, 7, 12, 7, 9, 7, 14, 9, 1, 5}, 16)== 0)
   System.out.println("Passed 18");
  else
   System.out.println("Failed 18");
 }

}
