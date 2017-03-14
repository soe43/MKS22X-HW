import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String> words = new ArrayList<String>();
      ArrayList<String> setOne = new ArrayList<String>();
      words.add("");
      help(words , s, setOne);
      Collections.sort(words);
      return words;
  }
  
    private static void help(ArrayList<String> words, String combo, ArrayList<String> set1){
	if(combo.equals("")){
	    return;
	}
	for(String temp : words){
	    set1.add(temp);
	    set1.add(temp + combo.charAt(0));
	}
	words.removeAll(words);
	for(String temp : set1){
	    words.add(temp);
	}
	set1.removeAll(set1);
	help(words,combo.substring(1),set1);    
    }
}
