/*
 * Question : Given two strings s and goal, 
 * return true if and only if s can become goal after N shifts on s.

Definition of a shift:
Moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Assume the input need to be lowercase English letters.
*/
public class JavaQuest20 {

  public static void main(String[] args) {
    System.out.println(rotateString("abcde", "cdeab"));// true
    System.out.println(rotateString("abcde", "abced"));// false
    System.out.println(rotateString("abcde", "eabcd"));// true
    System.out.println(rotateString("abcde", "abcde"));// true
  }

  public static boolean rotateString(String s, String goal) {

    if(s.length()!=goal.length()){ // case check
      return false;
    }

    int indexShift=0;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)==goal.charAt(0)){
        indexShift=i;
      }
    }
    for(int i=0;i<goal.length();i++){
      if(indexShift==goal.length()){
        indexShift=0;
      }
      if(goal.charAt(i)==s.charAt(indexShift)){
        indexShift++;
      }else{
        return false;
      }
    }return true;
  }
}
