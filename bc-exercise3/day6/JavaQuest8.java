/**
 * Example Output
 * Second Max = 230
 */
public class JavaQuest8 {
  // Write a loop to find the second max number.
  public static void main(String[] args) {
    int[] nums = new int[] {-10, 5, 100, 240, 230, 80}; // Second Max = 230
    int[] nums2 = new int[] {-10, 5, 100, 120, 240, 200}; // Second Max = 200
    int[] nums3 = new int[] {-10, 5, 120, -100, 100, 240}; // Second Max = 120
    int[] nums4 = new int[] {-10, 5, 100, 240, 240, 80}; // Second Max = 240

    // Your program should be able to handle all the above test case.
    int secondMax;
    // code here
    int[] testCase = nums; // input test case here
    int maxNumPosition = 0;
    secondMax = testCase[0];
    for (int i = 0; i < testCase.length; i++) { // to find the position of the max Num
      if (testCase[i] > secondMax) {
        secondMax = testCase[i];
        maxNumPosition = i;
      }
    }
    if (maxNumPosition == 0) {
      secondMax = testCase[1]; // prevent if index=0 is max, below code will not work
    } else {
      secondMax = testCase[0]; // clear the max Num saving
    }
    for (int i = 0; i < testCase.length; i++) { // to find the second max Num
      if (i != maxNumPosition && testCase[i] > secondMax) {
        secondMax = testCase[i];
      }
    }
    System.out.println("Second Max = " + secondMax);
  }
}
