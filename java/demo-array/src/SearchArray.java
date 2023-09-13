import java.util.Arrays;

public class SearchArray {
  public static void main(String[] args) {
    // search
    char target = 'm';
    char[] chars = new char[] {'j', 'p', 'm', 'm', 'q', 'c'};
    // Loop to find the index of the target in array chars
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == target) {
        System.out.println("index=" + i);
      }
    }

    // toCharArray()
    String str = "I am a boy."; // 11 characters
    char[] arr = str.toCharArray(); // no need to new and define the length // 常用
    // System.out.println(arr[11]); // error
    System.out.println(Arrays.toString(arr));
    // [I, , a, m, , a, , b, o, y, .]

    int[] arr2 = new int[] {0, 2, 4, 5, 6, 2};
    String aaaa = Arrays.toString(arr2);
    System.out.println(aaaa);

    // Find Max. value in the array
    int[] nums = new int[] {240, 800, -23, 6, 3};
    int max = 0; // not perfect, cos if negative
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    System.out.println("max=" + max);

    int[] nums2 = new int[] {240, 800, -23, 6, 98};
    int min = nums2[0];
    for (int i = 0; i < nums2.length; i++) {
      if (nums2[i] < min) {
        min = nums2[i];
      }
    }
    System.out.println("min=" + min);

    int[] try2 = nums2;
    System.out.println(Arrays.toString(try2));



  }
}
