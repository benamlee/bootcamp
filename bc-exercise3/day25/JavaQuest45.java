/*
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class JavaQuest45 {
  public static void main(String[] args) {
    System.out.println(backspaceCompare("ab#c", "ad#c"));
    System.out.println(backspaceCompare("ab##", "c#d#"));
    System.out.println(backspaceCompare("a#c", "b"));

  }

  // Approach 1
  public static boolean backspaceCompare(String s, String t) {
    return backspace(s).equals(backspace(t));
  }

  public static String backspace(String s ) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '#') {
        if (i > 0) {
          s = s.substring(0, i-1) + s.substring(i + 1, s.length());
          i-=2;
        } else {
          s = s.substring(1, s.length());
          i--;
        }
      }
    }
    return s;
  }

}
