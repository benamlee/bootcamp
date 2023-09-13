import java.util.Arrays;

public class Method2 {
  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 10, 3, 4, 20};
    products(nums);
    System.out.println(Arrays.toString(nums));
  }


  public static int[] products(int[] arr) {
    int temp = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = product(arr[i], arr[i + 1]);
    }
    arr[arr.length - 1] *= temp;
    return arr;
  }


  public static int product(int a, int b) {
    return a * b;
  }
}
