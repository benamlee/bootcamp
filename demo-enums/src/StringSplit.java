import java.util.Arrays;

public class StringSplit {
  public static void main(String[] args) {
    String s = "abc def xyz";
    // s.split("XX") turns to array
    System.out.println(Arrays.toString(s.split("e"))); // 不要所有'e',

    for (String str : s.split(" ")) {
      System.out.println(str);
    }

    System.out.print("\n"); // \n means next line

    for (String str : s.split("\\s")) { // \s means space
      System.out.println(str);
    }

    System.out.println(); // \n means next line

    String s2 = "   abc     def   xyz   pld   ";
    for (String str : s2.trim().split("\\s+")) { // \s means space
      System.out.println(str);
    }

    System.out.println("\\"); // print \

    char c = '\\';
    System.out.println(c);

  }
}
