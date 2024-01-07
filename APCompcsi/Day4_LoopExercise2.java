/**
 * This is an exercise in nested loops. You can use while loops, but
 * for loops are recommended.
 */
public class Day4_LoopExercise2{

    /**
     * Called when the first command line argument is "a"
     * Prints out the following triangular number pattern with the
     * largest number as num (2nd command line argument)
     * Example:
     * > run Day4_LoopExercise2 a 5
     * > 1
     * > 1 2
     * > 1 2 3
     * > 1 2 3 4
     * > 1 2 3 4 5
     */
    private static void patternA(int num) {
      for (int i = num; i<0; i--){
        for (int j=1; j<=1;j++){
            System.out.print(j+" ");
        }
        System.out.println(); 
      }
    }
  
    /**
     * Called when the first command line argument is "b"
     * Prints out the following triangular number pattern with the
     * largest number as (2nd command line argument)
     * Example:
     * > run Day4_LoopExercise2 b 5
     * > 1 2 3 4 5
     * > 1 2 3 4
     * > 1 2 3
     * > 1 2
     * > 1
     */
    private static void patternB(int num) {
      
            for (int i = 1; i<=num; i++){
              for (int j=1; j<=1;j++){
                  System.out.print(j+" ");
              }
              System.out.println(); 
            }
          }
    
  
    /**
     *Called when the first command line argument is "c"
     * Prints out the following triangular number pattern with the
     * largest number as (2nd command line argument)
     * Example:
     * > run Day4_LoopExercise2 c 5
     * >         1
     * >       1 2
     * >     1 2 3
     * >   1 2 3 4
     * > 1 2 3 4 5
     */
    private static void patternC(int num) {
        for (int i = 1; i<=num; i++){
            for (int j=0; j<num-i; j++){
                System.out.print("  "); 
            }
        
            for (int j= 1; j<=i; j++){
                System.out.print(j+" ");   
            }
        }
      //your code here
    }
  
    /**
     * Called when the first command line argument is "d"
     * Prints out the following triangular number pattern with the
     * largest number as (2nd command line argument)
     * Example:
     * > run Day4_LoopExercise2 d 5
     * > 1 2 3 4 5
     * >   1 2 3 4
     * >     1 2 3
     * >       1 2
     * >         1
     */
    private static void patternD(int num) {
      //your code here
      for (int i = num; i>0; i--){
        for (int j=0; j<num-i; j++){
            System.out.print("  "); 
        }
    
        for (int j= 1; j<=i; j++){
            System.out.print(j+" ");   
        }
    }
    }
  
    /**
     * Takes two command line arguments; the first determines the pattern
     * type: a, b, c, or d. The second argument determines the size of the
     * printed pattern.
     */
    public static void main(String[] args) {
      if(args.length < 2) {
        System.out.println("Enter a, b, c, or d as first argument.");
        System.out.println("Enter a positive integer as second argument.");
        return;
      }
  
      if(args[0].equals("a") || args[0].equals("A"))
        patternA(Integer.parseInt(args[1]));
      else if(args[0].equals("b") || args[0].equals("B"))
        patternB(Integer.parseInt(args[1]));
      else if(args[0].equals("c") || args[0].equals("C"))
        patternC(Integer.parseInt(args[1]));
      else if(args[0].equals("d") || args[0].equals("D"))
        patternD(Integer.parseInt(args[1]));
    }
  
  
  }
  