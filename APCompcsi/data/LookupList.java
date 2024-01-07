package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LookupList {
  private ArrayList<String> wordlist;

  public LookupList() {
    wordlist = new ArrayList<String>();
  }


  public LookupList (String fileName) throws FileNotFoundException {
    wordlist = new ArrayList<String>();
    Scanner file = new Scanner(new FileReader(fileName));
    while(file.hasNextLine())
    {
      String word = file.nextLine();
      if(word.length() == 0 || word.charAt(0) == '#') //skip blank lines or starting with #, treating them as comments
        continue;
        wordlist.add(word);
      /*
      // Track how quickly the wordlist is forming...
      if (wordlist.size() % 5000 == 0)
        System.out.println("Added " + numWords + " words.");
      */
    }
    file.close();

    //update to use merge sort!
    wordlist = mergeSort(wordlist);
  }

  private static ArrayList<String> mergeSort(ArrayList<String> list){
    int n = list.size();
    if (n==1){
        return list;
    }
    
    ArrayList<String> halfA = new ArrayList<String>(list.subList(0, n/2));
    ArrayList<String> halfB = new ArrayList<String>(list.subList(n/2, n));

    halfA = mergeSort(halfA);
    halfB = mergeSort(halfB);

    list = mergeArrayLists(halfA, halfB); 
    
    return list; 
}

  private static ArrayList<String> mergeArrayLists(ArrayList<String> listA, ArrayList<String> listB) {
      ArrayList<String> merged = new ArrayList<String>();

      int a = 0;
      int b = 0;
      
      while (a < listA.size() && b < listB.size()) {
        //listA.get(a).compareTo(listB.get(b)) < 0
          if (listA.get(a).compareTo(listB.get(b)) < 0){
              merged.add(listA.get(a++));
          }
          else {
              merged.add(listB.get(b++));
          }
      }

      while (a < listA.size()) {
        merged.add(listA.get(a++));
      }

      while (b < listB.size()) {
        merged.add(listB.get(b++));
      }


      return merged;
  }

  public static int binarySearch(ArrayList<String> list, String search) {
    return binarySearch(list, search, 0, list.size() - 1);
  }

  private static int binarySearch(ArrayList<String> list, String search, int low, int high) {
    //System.out.println("Searching -- low: " + low + "; high: " + high);
    if (high < low) {
      return -1;
    }

    int pos = (high + low) / 2;

    if (search.equals(list.get(pos)) == true) {
      return pos;
    }

    else if (search.compareTo(list.get(pos)) > 0) {
      return binarySearch(list, search, pos+1, high);
    }
    else {
      return binarySearch(list, search, low, pos-1);
    }
  }


  public int size(){
    return wordlist.size();
  }

  public String get(int index){
    return wordlist.get(index);
  }

  public int indexOf(String word){
    //return wordlist.indexOf(word);

    // update to use binary search!
    return binarySearch(wordlist, word);
  }

  public boolean contains(String word){
    //return wordlist.contains(word);

    //update to use binary search!
    if (binarySearch(wordlist, word) != -1){
      return true;
    }
    return false;
  }

  public List<String> toList(){
    return wordlist;
  }

  public void print() {
    int maxdigits = String.valueOf(wordlist.size()).length();;
    String format = "%" + maxdigits +"d: %s\n";

    System.out.printf("Wordlist (%d total):\n", wordlist.size());
    for (int i = 0; i < wordlist.size(); i++){
      System.out.printf(format,i,wordlist.get(i));
    }
  }



  public void insert(String word){
    //This inserts a word into the list in sorted position,
    //assuming that the list is already sorted.

    for(int i = wordlist.size(); i > 0; i--){ //work backwards
      String w = wordlist.get(i - 1);
      if (word.compareTo(w) >= 0){ //if >= item in list (w),
        wordlist.add(i, word); //insert at correct place, which is right after the item
        return; //done!
      }
    }
    wordlist.add(0, word); //if < all items in list, add to front of list

    //Optional?? Rewrite to work a little bit faster! Hint: Use binarySearch to know WHERE to insert...
  }

}
