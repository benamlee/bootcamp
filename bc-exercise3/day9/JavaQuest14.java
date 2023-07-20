public class JavaQuest14 {
  // Given an integer x, return true if x is a palindrome (迴文), and false otherwise.
  // Palindrome: it is same text, no matter you read it from left to right, or from right to left

  // Case 1: 13431
  // true

  // Case 2: -123
  // false

  // Case 3: 1
  // true

  // Case 4: 22
  // true

  // Case 5: 1231
  // false

  // Do not change anything in main method
  public static void main(String[] args) {
    boolean res = palindrome(13431); // true
    boolean res2 = palindrome(-121); // false
    boolean res3 = palindrome(1); // true
    boolean res4 = palindrome(22); // true
    boolean res5 = palindrome(1231); // false
  }

  // Code a method here to return true if the integer is palindrome, otherwise false
  public static boolean palindrome(int res) {
    boolean isPalindrome = true;
    String str = "" + res;
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length / 2; i++) {
      if (arr[i] != arr[arr.length - i - 1]) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }

}
