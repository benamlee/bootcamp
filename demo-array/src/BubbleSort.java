import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    // [5, 1, 4, 2, 8]
    // Step1.1: [1, 5, 4, 8, 2]
    // Step1.2: [1, 4, 5, 8, 2]
    // Step1.3: [1, 4, 5, 8, 2] (No change, due to 5 < 8)
    // Step1.4: [1, 4, 5, 2, 8]

    // Step2.1: [1, 4, 5, 2, 8] (No change, due to 1 < 4)
    // Step2.2: [1, 4, 5, 2, 8] (No change, due to 4 < 5)
    // Step2.3: [1, 4, 2, 5, 8]

    // Step3.1: [1, 4, 2, 5, 8] (No change, due to 1 < 4)
    // Step3.2: [1, 2, 4, 5, 8] (No change, due to 1 < 4)

    // Step4.1: [1, 2, 4, 5, 8] (No change, due to 1 < 2)

    // target: [1, 2, 4, 5, 8]
    int[] nums = new int[] {5, 1, 4, 8, 2};
    System.out.println(Arrays.toString(sort(nums)));

  }

  // interview可能會問
  public static int[] sort(int[] arr) {
    int temp;
    for (int j = 0; j < arr.length - 1; j++) {
      for (int i = 0; i < arr.length - j - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
        }
      }
    }
    return arr;
  }


}


