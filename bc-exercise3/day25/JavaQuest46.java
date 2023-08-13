/*
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * 
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * 
 */
public class JavaQuest46 {
  public static void main(String[] args) {
    System.out.println(findGCD(new int[] {2, 5, 6, 9, 10}));
    System.out.println(findGCD(new int[] {7, 5, 6, 8, 3}));
    System.out.println(findGCD(new int[] {3, 3}));

  }

  public static int findGCD(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    for (int i = min; i > 0; i--) {
      if (max % i == 0 && min % i == 0)
        return i;
    }
    return 1;
  }

}
