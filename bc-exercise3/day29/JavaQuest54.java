/* Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.


Example 1:
Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.

Example 2:
Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
Output: [2,3,1]
Explanation: The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.

Example 3:
Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
Output: []
Explanation: No value is present in at least two arrays.


Constraints:

1 <= nums1.length, nums2.length, nums3.length <= 100
1 <= nums1[i], nums2[j], nums3[k] <= 100*/

import java.util.ArrayList;
import java.util.List;

public class JavaQuest54 {
  public static void main(String[] args) {
    int[] nums1 = new int[] { 3, 1 };
    int[] nums2 = new int[] { 2, 3 };
    int[] nums3 = new int[] { 2, 1 };
    System.out.println(twoOutOfThree(nums1, nums2, nums3));// [1,2,3]

    int[] nums4 = new int[] { 1, 1, 3, 2 };
    int[] nums5 = new int[] { 2, 3 };
    int[] nums6 = new int[] { 3 };
    System.out.println(twoOutOfThree(nums4, nums5, nums6));// [2,3]

    int[] nums7 = new int[] { 1, 2, 2 };
    int[] nums8 = new int[] { 4, 3, 3 };
    int[] nums9 = new int[] { 5 };
    System.out.println(twoOutOfThree(nums7, nums8, nums9));// []

  }

  public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

  }

}
