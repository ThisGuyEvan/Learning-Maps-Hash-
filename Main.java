import java.util.*;

class Main {
  public static void main(String[] args) {
    //Tests:
    System.out.println(palindromeRearrange("z"));
    System.out.println(palindromeRearrange("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"));
    System.out.println(palindromeRearrange("zyyzzzzz"));
    System.out.println(palindromeRearrange("zaa"));
    System.out.println(palindromeRearrange("oogaBooga"));

  }

  public static boolean palindromeRearrange(String s){
    ArrayList<Integer> countOfLetters = new ArrayList<Integer>(hashArrange(s).values());
    int oddLetterCount = 0;

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
    char[] str = s.toCharArray();
    HashMap<Character, Integer> arrange = new HashMap<Character, Integer>();

    for (char a : str){
      int i = new ArrayList<Character>(arrange.keySet()).indexOf(a);
      if (i != -1){
        arrange.put(a, arrange.get(a) + 1);
      }
      else{
        arrange.put(a, 1);
      }
    }

    return arrange;
  }
}


////Character c = new  ArrayList<Character>(arrange.keySet()).get(i);

//Conditions:
// - More than two single letters return false.
// - Rest has to be pairs.
// - Use hash to contain letters. 


// Good Links: https://www.logicbig.com/how-to/code-snippets/jcode-java-collections-set-element-index.html https://javaconceptoftheday.com/convert-hashmap-to-arraylist-in-java/