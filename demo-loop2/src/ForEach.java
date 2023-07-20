import java.util.Arrays;

public class ForEach {
  public static void main(String[] args) {
    // basic
    for (int i = 0; i < 3; i++) {
      System.out.println("basic for-loop: hello");
    }
    // For-each
    int[] arr = new int[] {200, 100, 3, 4};
    // for (Type Element : Dataset)
    for (int x : arr) { // loop through all elements
      System.out.println("for-each: hello, x=" + x);
      System.out.println(arr[0]); // but you still access element by index
      arr[0] = 8;
    } // weakness: cannot skip first/end n elements by control counter, cannot loop backward
    // 要skip 要用if, 照loop哂element, 會慢

    for (int i = 0; i < arr.length; i++) { // counter control, can be changed i from i=1, i<arr.length-3, i+=2
      System.out.println("arr[0]=" + arr[0]);
      arr[0] = 9;
    }

    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    arr[3] = 4;
    for (int i = 0; i < arr.length; i++) {
      if (i > arr.length / 2 - 1) {
        break;
      }
      System.out.println("aa");
      System.out.println("bb" + arr[i] + arr[arr.length - i - 1]);
    }

    // Difference of for-each:
    // 1. for-each do not have stop condition/ counter in loop signature

    // try
    String[] strs = new String[] {"hello", "world"};
    for (String s : strs) {
      System.out.println(s);
    }

    // Integer, Character (Wrapper Class)
    Character[] chars = new Character[] {'L', 'a', '!', '('};
    for (Character c : chars) {
      System.out.println(c);
    }

    String s2 = "Hello world ! I am Ben";
    String[] strings = s2.split(" ");
    for (String s : strings) {
      System.out.println(s);
    }

    // Without using split, use a for loop to split s2
    // Output: Sting[]
    // 1. substring()
    // 2. toCharArray()

    split(s2);



    // 1st
    int count = 0;
    for (int i = 0; i < s2.length(); i++) {
      if (s2.charAt(i) == ' ') {
        count++;
      }
    }
    int[] index = new int[count];
    int a = 0;
    for (int j = 0; j < s2.length(); j++) {
      if (s2.charAt(j) == ' ') {
        index[a] = j;
        a++;
      }
    }
    String[] strs2 = new String[count + 1];
    strs2[0] = s2.substring(0, index[0]);
    strs2[count] = s2.substring(index[4] + 1, s2.length());
    for (int i = 0; i < (count - 1); i++) {
      strs2[i + 1] = s2.substring(index[i] + 1, index[i + 1]);
    }
    System.out.println("Ben1" + Arrays.toString(strs2));
    // 1st

    // 2nd
    count = 0;
    for (int i = 0; i < s2.length(); i++) {
      if (s2.charAt(i) == ' ') {
        count++;
      }
    }
    char[] arrs2 = s2.toCharArray();
    int temp = 0;
    String[] strs3 = new String[count + 1];
    for (int i = 0; i < count + 1; i++) {
      strs3[i] = "";
    }
    for (int i = 0; i < arrs2.length; i++) {
      if (arrs2[i] == ' ') {
        temp++;
        continue;
      }
      strs3[temp] += arrs2[i];
    }
    System.out.println("Ben2" + Arrays.toString(strs3));
    // 2nd



  }

  public static String[] split(String s) {
    // Approach 1: substring()
    // count Spaces
    int spaceCount = 0;
    String s2 = s.trim();
    for (int i = 0; i < s2.length(); i++) {
      if (s2.charAt(i) == ' ') {
        spaceCount++;
      }
    }
    int startIdx = 0;
    int idx = 0;
    String[] result = new String[spaceCount + 1];
    for (int i = 0; i < s2.length(); ++i) {
      if (s2.charAt(i) == ' ') {
        result[idx] = s2.substring(startIdx, i);
        idx++;
        startIdx = i + 1;
      } else if (i == s2.length() - 1) {
        result[idx] = s2.substring(startIdx, s2.length());
      }
    }
    System.out.println("vincent1" + Arrays.toString(result));
    // Approach 1: substring()
    // count Spaces
    return result;
  }

}
