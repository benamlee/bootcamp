import java.util.Arrays;

public class Math1 {
  public static void main(String[] args) {
    System.out.println(Math.ceil(3.01)); // 4.0
    System.out.println(Math.floor(3.9995)); // 3.0
    System.out.println(Math.round(5.4)); // 5
    System.out.println(Math.round(5.5)); // 6
    System.out.println(Math.round(5.45)); // 5
    System.out.println(Math.round(5.49)); // 5
    System.out.println(Math.round(5.099)); // 5

    System.out.println(Math.sqrt(-26)); // NaN
    System.out.println(Math.sqrt(30));


    int num = -26;
    if (num > 0 && Math.sqrt(num) == 5) {
    }

    Math.random();
    System.out.println(Math.random());

    System.out.println(Math.log(Math.E)); // Math.E is e natural number; Math.log is natural log

    int[] nums = new int[] {-100, 100, 90, 50};
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += Math.abs(nums[i]);
    }
    System.out.println(sum);


    double[] arr = new double[] {-5.64, 5.23, 9.800, 6.55};

    int total = 0;
    int total2 = 0;
    for (int i = 0; i < arr.length; i++) {
      total += Math.round(Math.abs(arr[i])); // 唔洗(int)，vincent都唔知點解，估背後convert了
      total2 = total2 + (int) Math.round(Math.abs(arr[i])); // 要用(int)
    }
    System.out.println(total);
    System.out.println(total2);


    int cubeLength = 3;
    double volume = Math.pow(cubeLength, 3);

    int[] bases = new int[] {2, 3, 4, 5};
    int[] index = new int[] {3, 4, 5, 6};
    int[] result = new int[bases.length];
    for (int i = 0; i < bases.length; i++) {
      result[i] = (int) Math.pow(bases[i], index[i]);
    }
    System.out.println(Arrays.toString(result));


  }
}
