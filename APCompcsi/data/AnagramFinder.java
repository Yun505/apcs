package data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramFinder {

  public static List<String> getAnagrams(String word, LookupList dict){
    // stuff I added 
    int length = word.length();
    ArrayList<String> legal = new ArrayList<>();
    
    getAnagrams("", word, length, legal, dict);

    return legal;
  }

  private static void getAnagrams(String word_used, String word, int max, ArrayList<String> anagrams, LookupList dict){
    String word_checker = "";
    
    if (word_used.length() == max && dict.contains(word_used) && anagrams.contains(word_used) == false){
      anagrams.add(word_used);
      return;
    }

    //recursive
      for(int a = 0; a < word.length(); a++){
        word_checker = word_used + word.charAt(a);
        String unused = word.substring(0, a) + word.substring(a+1);
        getAnagrams(word_checker, unused, max, anagrams, dict);
      }
    
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);

    System.out.println("Which word list?  (large, medium, small, tiny)");
    String listSize = input.nextLine();
    String filename = "data/scrabbleWords/words_" + listSize + ".txt";

    System.out.printf("Reading in word list from file %s...\n", filename);
    double start = System.nanoTime();
    LookupList dict = new LookupList(filename);
    System.out.print("Successfully read in word list from file!\n");
    System.out.printf("Time: %.4f seconds.\n\n", (System.nanoTime() - start) / 1000000000);

    System.out.print("\n\nEnter word/letters to find anagrams (enter blank to stop) >>>  ");
    String word = input.nextLine();
    while (!word.equals("")) {
      start = System.nanoTime();
      System.out.printf("Searching for anagrams of \"%s\"...\n", word);
      List<String> anagrams = getAnagrams(word, dict);
      System.out.printf("Found %d anagrams!\n", anagrams.size());
      System.out.println(anagrams);
      System.out.printf("Time: %.4f seconds.\n\n", (System.nanoTime() - start) / 1000000000);

      System.out.print("Enter another word to find anagrams >>> ");
      word = input.nextLine();
    }
    System.out.println("All done!");
    input.close(); //anoying porblem
  }


}
