package lab4_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Lab4_1_ParenChecker {

  public static void main(String[] args) {
    String[] files = {"lab4_1/invalid1.in","lab4_1/invalid2.in","lab4_1/invalid3.in",
            "lab4_1/invalid4.in","lab4_1/invalid5.in",
            "lab4_1/valid1.in","lab4_1/valid2.in"};

    for (String filename: files) {
      System.out.println("\nTesting file: " + filename);
      try {
          checkParens(filename);
        }
      catch (FileNotFoundException ex) {
        System.err.println("File not found");
      }
      catch (Exception ex) {
        System.out.println(ex);
      }
    }
  }


	
  public static void checkParens(String fileName) throws FileNotFoundException {
    Scanner in = new Scanner(new FileReader(fileName));
    ArrayList<Character> openSymbols = new ArrayList<>(Arrays.asList('[', '{', '('));
    ArrayList<Character> closeSymbols = new ArrayList<>(Arrays.asList(']', '}', ')'));

    //
    // Declare any other variables you need here.
    //
    Stack<Character> stack = new Stack<Character>();
    int lineCounter = 1; 
    int errorLine = lineCounter; 
    char wrongChar = 'b'; 
    char expectedChar = 'b'; 


    // Read through the file one line at a time.
    while (in.hasNextLine()) {
      String line = in.nextLine();

      for (int i= 0; i <line.length(); i++){
        boolean isOpenSymbol = false;
        for (int a = 0; a < openSymbols.size(); a++){
          if (line.charAt(i) == openSymbols.get(a)){
            stack.push(closeSymbols.get(a));
            isOpenSymbol = true;
            break;
          }
        }
        if (isOpenSymbol){
          continue;
        }
        for(int c = 0; c < closeSymbols.size(); c++){
          if (line.charAt(i) == closeSymbols.get(c)){
            if(stack.empty()){
              throw new InputMismatchException("On line " + lineCounter + " at pos " + (i+1) + " found '" + line.charAt(i) + "' there is no matching opening symbol.");
            }
            else if (line.charAt(i) == stack.peek()){
              stack.pop(); 
            }
            else{
              expectedChar = stack.peek(); 
              wrongChar = line.charAt(i);
              errorLine = lineCounter; 
              throw new InputMismatchException("On line " + errorLine + " at pos " + (i+1) + " found '" + wrongChar + "' expected '" + expectedChar + "' ");
            }
            break; 
          }
        }
      }
      lineCounter++; 
    }
    if(stack.isEmpty()){
      System.out.println("The parentheses in the file are valid!");
    }

    else{
        throw new InputMismatchException("At the end of input -- expecting '" + stack.peek() +"'.");
    }
  }
}