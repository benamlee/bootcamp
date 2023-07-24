import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) { // compare from left, smallest, use while loop can stop earlier
    // [5, 1, 4, 8, 2]
    // Step1.1: [1, 5, 4, 8, 2] (insert 1 to arr[0], 1 < 5)
    // After round 1, [1, 5] is sorted
    // Step2.1: 4 < 5
    // Step2.2: 1 < 4 -> [1, 4, 5]
    // After round 2, [1, 4, 5] is sorted

    int[] arr = new int[] {5, 1, 4, 8, 2};
    System.out.println(Arrays.toString(sort(arr)));
    System.out.println(Arrays.toString(sort2(arr)));

  }

  public static int[] sort(int[] arr) {
    int temp = 0;
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }

  public static int[] sort2(int[] arr) {
    int temp = 0;
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (arr[j] < arr[j - 1]) {
        temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
        j--;
      }
    }
    return arr;
  }

}
