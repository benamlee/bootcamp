public class Array2 {
  public static void main(String[] args) {
    String str1 = "hello";
    System.out.println(swap(str1, 2, 4));

    int[] aaa = new int[] {1, 1, 2, 3};
    System.out.println(String.valueOf(aaa));

  }

  public static String swap(String str, int idx1, int idx2) {
    // Swap two characters in the string (index1 and index2)
    // return the modified String
    // 將所有非法野寫先，exceptional case early return
    if (str == null) {
      return null; // early return
    }
    if (str.isBlank()) {
      return str;
    }
    if (idx1 < 0 || idx1 >= str.length()) {
      return str;
    }
    if (idx2 < 0 || idx2 >= str.length()) {
      return str;
    }
    char[] chars = str.toCharArray();
    char temp = chars[idx1];
    chars[idx1] = chars[idx2];
    chars[idx2] = temp;
    return String.valueOf(chars);

  }

}
