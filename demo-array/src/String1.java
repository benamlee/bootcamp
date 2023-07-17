public class String1 {
  public static void main(String[] args) {
    // length(), equals(), charAt()
    String str = "hello";
    System.out.println(str.isEmpty()); // true or false
    String str2 = "";
    System.out.println(str2.isEmpty());
    String str3 = "   ";
    System.out.println(str3.isEmpty());

    // isBlank(), blank form, 冇人填過野
    System.out.println(str.isBlank());
    System.out.println(str2.isBlank());
    System.out.println(str3.isBlank());

    // toLowerCase(), toUpperCase()
    System.out.println(str.toUpperCase()); // HELLO, it dont save str
    System.out.println(str);
    System.out.println(str.toUpperCase().toLowerCase()); // hello
    if (str.toUpperCase().equals("HELLO")) {
      System.out.println("yes, it is HELLO");
    }

    // substring
    // startIndex,is normal index
    // endIndex, represents the position of the last character +1
    // str = hello
    System.out.println(str.substring(0, 2)); // he
    System.out.println(str.substring(2, 3)); // l
    System.out.println(str.substring(0, 5)); // hello
    System.out.println(str.substring(0)); // hello
    System.out.println(str.substring(3)); // lo
    if (str.substring(3).equals("lo")) { // remember again, string use .equals, not ==
      System.out.println("yes, str.substring(3) = lo");
    }


    // contains
    String s = "lo";
    System.out.println(str.contains(s)); // true (hello contains lo)
    System.out.println(str.contains("ol")); // false (hello Not contains ol)
    if (str.contains("lo")) {
      System.out.println("str contains lo");
    }

    str = str.toUpperCase();
    System.out.println(str); // HELLO
str+=str.toLowerCase();
System.out.println(str); // HELLOhello

  }
}
