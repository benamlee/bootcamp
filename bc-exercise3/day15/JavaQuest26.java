/*
 * 
 * Question : You are given an integer array nums. 
 * The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

public class JavaQuest26 {
  public static void main(String[] args) {
    System.out.println(sum(new int[] { 1, 2, 3, 2 })); // 4
    System.out.println(sum(new int[] { 1, 1, 1, 1, 1 }));// 0
    System.out.println(sum(new int[] { 1, 2, 3, 4, 5, 6 }));// 21
    System.out.println(sum(new int[] { 1 }));// 1
  }

  public static int sum(int[] nums) {
    // code here
    int[] nums2=new int[nums.length]; // make a copy
    for(int i=0;i<nums2.length;i++){
      nums2[i]=nums[i];
    }
    int check=0; // all repeated numbers set 0
    for(int i=0;i<nums2.length;i++){
      check=nums2[i];
      for(int j=0;j<nums2.length;j++){
        if(i!=j&&nums2[j]==check){
          nums2[j]=0;
          nums2[i]=0;
        }
      }
    }
    check=0; // return sum of unique numbers
    for(int i=0;i<nums2.length;i++){
      check+=nums2[i];
    }
    return check;
  }

}
