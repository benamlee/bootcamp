import java.util.Arrays;

public class Swap {
  public static void main(String[] args) {
    int[] arr = new int[] {100, -400, 3, 99};
    // code here ... to swap 100 and 99
    int temp = arr[0]; // backup
    arr[0] = arr[arr.length - 1];
    arr[arr.length - 1] = temp;

    // print all elements
    for (int i = 0; i < arr.length; i++) {
      // code here
      System.out.println("arr[" + i + "]=" + arr[i]);
    }

    String str = "hello!";
    String str2 = "abcd";
    String str3 = "aabb";
    String str4 = "abcdef";
    String str5 = "abc";
    String str6 = "c";
    System.out.println(SwapOddEvenCharacter(str));

    char[] arr2 = new char[] {'f', 'e', 'r', 't'};
    System.out.println(String.valueOf(arr2));

    int a = Math.abs(-123); // 123

  }

  // Swap
  public static String SwapOddEvenCharacter(String str) {
    // hello! -> ehll!o
    // abcd -> badc
    // aabb -> aabb
    // abcdef -> badcfe
    // abc -> bac
    // c-> c
    char[] arr = str.toCharArray();
    char temp = 0;
    // if (str.length() > 1) {
    // for (int i = 1; i < str.length(); i += 2) {
    // temp = arr[i - 1];
    // arr[i - 1] = arr[i];
    // arr[i] = temp;
    // }
    // }
    for (int i = 0; i < str.length(); i++) {
      if (i % 2 == 1) {
        temp = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = temp;
      }
    }
    // String str2 = "";
    // for (int i = 0; i < str.length(); i++) {
    //   str2 += arr[i];
    // }
    // return str2;
    String str1 = String.valueOf(123); // "123"
    String str2 = String.valueOf(true); // "true"
    return String.valueOf(arr);
  }


}
