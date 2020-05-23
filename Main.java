import java.util.*;

//After I finished the assignment I realized that yes, I could have merged the two methods - palindromeRearrange and hashArrange - together. But I still think this is more modular considering that hashArrange() can be easily used to get the keys & values.

//Time: 1h 20m ish

class Main {
  public static void main(String[] args) {
    System.out.println(palindromeRearrange("z"));
    System.out.println(palindromeRearrange("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"));
    System.out.println(palindromeRearrange("zyyzzzzz"));
    System.out.println(palindromeRearrange("taco cat"));
    System.out.println(palindromeRearrange("oogaBooga"));

  }

  public static boolean palindromeRearrange(String s){
    //Converts collection of values into an integer ArrayList.
    ArrayList<Integer> countOfLetters = new ArrayList<Integer>(hashArrange(s).values());
    int oddLetterCount = 0;

    //Conditions for the assignment.
    for (int i : countOfLetters){
      if (i % 2 != 0){
        oddLetterCount++;
      }

      if (oddLetterCount >= 2){
        return false;
      }
    }

    return true;
  }

  //I could have done a 2D ArrayList to perform the same job?
  public static HashMap<Character, Integer> hashArrange(String s){
    char[] str = s.toCharArray(); //Convert to char arr in order to use for each.
    //For sorting/filtering purposes 
    HashMap<Character, Integer> arrange = new HashMap<Character, Integer>();

    for (char a : str){
      //Find index of char in string, if not added to the map, then add new.
      if (a != ' '){ //Ignores spaces
        int i = new ArrayList<Character>(arrange.keySet()).indexOf(a); 
        if (i != -1){
          arrange.put(a, arrange.get(a) + 1); //Increment if found again.
        }
        else{
          arrange.put(a, 1); //Create new key for new letter.
        }
      }
    }

    return arrange;
  }
}


////Character c = new  ArrayList<Character>(arrange.keySet()).get(i);

//Conditions:
// - More than two odd letters return false.
// - Rest has to be even.
// - Use hash to contain letters. 


// Good Links: https://www.logicbig.com/how-to/code-snippets/jcode-java-collections-set-element-index.html https://javaconceptoftheday.com/convert-hashmap-to-arraylist-in-java/