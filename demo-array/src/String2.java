public class String2 {
  public static void main(String[] abc) {
    // method signature = method name + parameter type & quantity
    // "args" change to "abc", doesn't matter

    // trim(), remove leading space and trail space
    String str = "hello  ";
    String str2 = "   hel   lo  ";
    System.out.println("str.trim()=" + str.trim()); // "hello"
    System.out.println("str2.trim()=" + str2.trim()); // "hel lo"

    // startsWith(), check if the string starts with the target string
    if (str.startsWith("hel")) {
      System.out.println("The string starts with hel");
    }
    // endsWith(), check if the string ends with the target string
    boolean endsWithSpace = str.endsWith(" ");
    if (endsWithSpace) {
      System.out.println("The string ends with space");
    }

    // indexOf(int) or indexOf(char)
    System.out.println("The index of o in str=" + str.indexOf('o')); // 4, 'o' upcast to int
    // indexOf(String)
    System.out.println("The index of ll in str=" + str.indexOf("ll")); // 2, 默認做indexOf(String)
    System.out.println("The index of lll in str=" + str.indexOf("lll")); // -1, means not found
    System.out.println(
        "The index of o in str, search from index 5=" + str.indexOf('o', 5)); // -1
    System.out.println(
        "The index of ll in str, search from index 1=" + str.indexOf("ll", 1)); // -1

    // lastIndexOf(int/char,index), search backwwrd
    String str3 = "abcdefgh";
    System.out.println(str.lastIndexOf('o', 4)); // 4
    System.out.println(str.lastIndexOf("llo", 4)); // 2
    System.out.println(str.lastIndexOf("llo  ")); // 2
    System.out.println(str.lastIndexOf('h')); // 0
    System.out.println(str.lastIndexOf('l')); // 3
    System.out.println(str.indexOf('l')); // 2
    System.out.println(str3.indexOf('f')); // 5

    // replace
    String s = "Java is a programming language";
    System.out.println((s.replace("Java", "Python"))); // Python is a programming language
    System.out.println(s.replace('p', 'q')); // Java is a qrogramming language
    System.out.println(s.replace('a', 'b')); // Java is a qrogramming language

    // equals(), equalsIgnoreCase()
    str3 = "hello";
    if ("hello".equals(str3)) { // true
      System.out.println("str3=hello");
    }
    if ("Hello".equals(str3)) { // false, case sensitive
      System.out.println("str3=Hello");
    }
    if ("Hello".equalsIgnoreCase(str3)) { // true, non case sensitive
      System.out.println("non case sensitive checking");
    }
    if ("HELLO".equals(str3.toUpperCase())) {
      System.out.println("Alternative");
    }

    // concat(String), append something
    String newString = str3.concat(" Java!"); // + operation
    System.out.println("newString=" + newString); // hello Java!
    str3 = str3.concat(" Java!");
    System.out.println("str3=" + str3); // hello Java!

    // compareTo
    String apple = "rrrapple";
    String facebook = "rrrfacebook";// compare the first difference letter by ASCII
    System.out.println(apple.compareTo(facebook)); // -5, 97-102 ('a'-'f')

  }
}
