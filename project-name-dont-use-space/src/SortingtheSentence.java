import java.util.Arrays;

public class SortingtheSentence {
  public static void main(String[] args) {
    String s = "is2 sentence4 This1 a3";
    System.out.println(sortSentence(s));
  }

  public static String sortSentence(String s) {
    // split() -> " " -> String[]
    String[] strings = s.split(" ");
    String[] words = new String[strings.length];
    int idx;
    for (int i = 0; i < strings.length; i++) {
      idx = strings[i].charAt(strings[i].length() - 1) - '1';
      // this is a char, use ASCII
      // swap
      words[idx] = strings[i].substring(0, strings[i].length() - 1);
    }
    StringBuilder sb = new StringBuilder();
    for (String str : words) {
      sb.append(str).append(" ");
    }
    return sb.toString().trim();
  }
}
