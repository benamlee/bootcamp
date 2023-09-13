import java.util.Arrays;

public class Array3 {
  public static void addOne(int[] arr) { // arr -> object reference // pass by reference
    for (int i = 0; i < arr.length; i++) {
      arr[i] += 1;
    }
  } // input地址做修改，不需要又 return 地址出去，所以修改可以用 void ，這是 action 動作


  public static String concat(String s1, String s2) { // all Wrapper Class + String + Primitives -> pass by value
    s1 = "hello"; // 因為 String 係 value ，唔係 address ，所以唔係改寫 a 的動作
    return s1 + s2;
  }



  public static void main(String[] args) {
    int[] nums = new int[] {3, 4, 8};
    addOne(nums); // [4, 5, 9]
    System.out.println(Arrays.toString(nums));

    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }

    String a = "abc"; // 儲存左 value，a b 係 object reference
    String b = "def";
    System.out.println(concat(a, b)); // 出 abcdef
    System.out.println(a); // 仍然係 abc
    System.out.println(b); // def

  

    



  }
}
