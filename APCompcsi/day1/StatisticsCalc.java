package day1;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StatisticsCalc {
 private int array[];

 /**
  * Reads the first line from the file to determine the number of integers in
  * the file. Creates an array based upon this number. Then, reads the rest
  * of the file into the array.
  * 
  * @throws FileFormatException
  */
 public StatisticsCalc(String fileName) throws FileFormatException, FileNotFoundException {
    Scanner in = new Scanner(new FileReader(fileName));       

    try {
        int max = in.nextInt();
        array = new int[max];

        for (int i = 0; i < max; i++) {
        array[i] = in.nextInt();
        }
        Arrays.sort(array);
    }
    catch (java.util.InputMismatchException ex) {
       FileFormatException fe = new FileFormatException("Non-numeric data found in file.");
       throw fe;
    }
    catch (java.util.NoSuchElementException ex1) {
        throw new FileFormatException("Not enough data in file.");       
    }
    catch (Exception ex) {
        throw new FileFormatException(ex);       
    }
    finally {
        in.close();
    }
 }

 /** Returns the mean of the integers. */
 public double getMean() {
  long sum = 0;

  for (int i = 0; i < array.length; i++) {
   sum += array[i];
  }

  return (double) sum / array.length;
 }

 /** Returns the minimum value of the integers in the array. */
 public int getMin() {
  return array[0];
 }

 /** Returns the maximum value of the integers in the array. */
 public int getMax() {
  return array[array.length - 1];
 }

 /** Returns the median value of the integers in the array. */
 public double getMedian() {
  // If odd
  if (array.length % 2 == 1) {
   // Integer division intended here.
   return array[array.length / 2];
  }

  // If even
  else {
   int midpoint = array.length / 2;
   return (double) (array[midpoint - 1] + array[midpoint]) / 2;
  }
 }

 /** Returns the statistical range of the integers in the array. */
 public int getRange() {
  return array[array.length - 1] - array[0];
 }

 /** Returns the standard deviation for the integers in the array. */
 public double getStdDev() {
  float variance = 0;
  double mean = getMean();

  for (int i = 0; i < array.length; i++) {
   variance += Math.pow(mean - array[i], 2);
  }

  variance /= array.length;

  return Math.sqrt(variance);
 }
}
