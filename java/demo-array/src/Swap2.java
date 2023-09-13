import java.util.Arrays;

public class Swap2 {
  public static void main(String[] args) {
    int[] nums = new int[] {8, 3, -10, 30, 100, -19};
    // Swap the max number to the tail
    // {8, 3, -10, 30, -19, 100}
    int max = nums[0];
    int index = 0;
    for (int i = 0; i < nums.length; i++) { // 方法1
      if (nums[i] > max) {
        max = nums[i];
        index = i;
      }
    }
    for (int i = 0; i < nums.length; i++) { // 方法2
      if (nums[i] > nums[index]) {
        index = i;
      }
    }
    nums[index] = nums[nums.length - 1];
    nums[nums.length - 1] = max;


    System.out.println(Arrays.toString(nums));

    // Test average(int[])
    int[] testCase = new int[] {2, 3, 0};
    System.out.println(average(testCase));

    int[] classA = new int[] {20, 30, 80, 100, 30, 90, 90};
    int[] classB = new int[] {90, 30, 50};
    if (average(classA) > average(classB)) {
      System.out.println("classA average is higher than classB");
    }



  }

  public static double average(int[] arr) {
    // calculate the average of all numbers in arr.
    if (arr.length == 0) {
      return -1.0d; // early return
    }
    double sum = 0.0d;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    // double result = sum / arr.length; dont work
    // return (double) sum / arr.length; its ok to change to double here
    return sum / arr.length; // int/int->int; double/int->double
  }
}
