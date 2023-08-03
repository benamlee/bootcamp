/*Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.


Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:
Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true */
public class JavaQuest34 {
  public static void main(String[] args) {
    System.out.println(arrayStringsAreEqual(new String[] { "ab", "c" }, new String[] { "a", "bc" }));// true
    System.out.println(arrayStringsAreEqual(new String[] { "ab", "cd" }, new String[] { "ab", "dc" }));// false
    System.out.println(arrayStringsAreEqual(new String[] { "ab", "c", "defg" }, new String[] { "abcdefg" }));// true

  }

  // Approach 1
  public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    String w1 = "";
    String w2 = "";
    for (String s: word1) {
      w1 += s;
    }
    for (String s: word2) {
      w2 += s;
    }
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i))
      return false;
    }
    return true;
  }
}
