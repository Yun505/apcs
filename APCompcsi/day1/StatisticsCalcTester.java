package day1;

//import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;

public class StatisticsCalcTester {
  static String[] files = {
    "test_num_1.txt", 
    "test_num_error_1.txt",
    "test_num_2.txt", 
    "test_num_error_2.txt"
  };

 public static void main(String[] args) throws IOException {
   
   for (int i=0; i<files.length; i++) {
     try{
      System.out.println("\n\nFile: " + files[i]);
      StatisticsCalc calc = new StatisticsCalc("day1/" + files[i]);
    
      System.out.printf("Average: %.2f\n", calc.getMean());
      System.out.printf("Standard Deviation: %.2f\n", calc.getStdDev());
      System.out.printf("Min: %d\n", calc.getMin());
      System.out.printf("Max: %d\n", calc.getMax());
      System.out.printf("Median: %.2f\n", calc.getMedian());
      System.out.printf("Range: %d\n", calc.getRange());
     }
     catch(Exception ex) {
       System.out.println("Caught exception: " + ex);
     }
   }
   System.out.println("Program successfully completed.");
 }
}
