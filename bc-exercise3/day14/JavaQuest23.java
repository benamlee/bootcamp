/*
 * Question : given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 * 
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 * 
 * Return true if a and b are alike. Otherwise, return false.
 */

// hints : substring() , toCharArray() ?
public class JavaQuest23 {
  public static void main(String[] args) {
    System.out.println(sameNumberOfVowels("book")); // true
    System.out.println(sameNumberOfVowels("textbook")); // false
  }

  public static boolean sameNumberOfVowels(String s) {
    // code here
    String vowels="aeiouAEIOU";
    int slen=s.length();
    String a=s.substring(0, slen/2);
    String b=s.substring(slen/2, slen);
    int counta=0;
    int countb=0;
    for(int i=0;i<slen/2;i++){
      if(vowels.contains(String.valueOf(a.charAt(i))))
      counta++;
      if(vowels.contains(String.valueOf(b.charAt(i))))
      countb++;
    }
    return counta==countb?true:false;

  }
}
