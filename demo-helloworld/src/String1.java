public class String1 {
  public static void main(String[] args) {
    String str = "I am happy, and good";
    str = str + ".";
    System.out.println("str=" + str); // I am happy, and good.

    // Method
    // length()
    int i = str.length(); // length(), tool to return the length of str
    System.out.println("i=" + i);
    System.out.println("hi".length()); // 2


    // equals()
    String str1 = "abc";
    String str2 = "abcd";
    String str3 = "abc";
    boolean areTheyEqual = str1.equals(str2); // false
    boolean areTheyEqual2 = str1.equals(str3); // true
    // str2.equals(str1) 先後一樣
    System.out.println(areTheyEqual);
    System.out.println(areTheyEqual2);
    boolean b4 = str2.equals(str1 + "d"); // true
    System.out.println(b4); // true

    // chatAt(2), find the char at index of the string
    String str4 = "helloworld";
    // index 0 if str4 -> 'h'
    System.out.println(str4.charAt(1)); // result:e
    System.out.println(str4.charAt(0));
    // System.out.println(str4.charAt(20)); // error 冇紅線但run error
    // System.out.println(str4.charAt(-3)); // error



  }
}


