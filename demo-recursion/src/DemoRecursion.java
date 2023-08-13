public class DemoRecursion {
  public static void main(String[] args) {
    // algorithm -> algo
    System.out.println(sum(1000));
    System.out.println(sum2(10));
    print(8);
  }

  // Question 1:
  // k + (k - 1) + (k - 2) + ... + 0
  public static int sum(int k) {
    if (k < 1)
      return k; // find stop condition
    return k + sum(k - 1); // find pattern
    // 10 + sum(9) , not yet return
    // 10 + 9 + sum(8), not yet return
    // 10 + 9 + 8 + sum(7), not yet return
    // ...
    // 10 + 9 + 8 + ... + 2 + 1 + sum(0)
    // when sum(0) return 0, sum(10) return 10 + 9 + 8 + ... + 1 + 0 = 55
  }

  // Question 2:
  // 0, 1, 1, 2, 3, 5, 8, 13 ... kth elements
  public static int sum2(int k) {
    if (k <= 1)
      return k;
    return sum2(k - 1) + sum2(k - 2);
  } // use less memory

  // Question 3:
  // non-tail recursion
  // 3 2 1 1 2 3, k = 3
  public static void print(int k) {
    if (k < 1) { // stop condition
      return; // means stop
    }
    System.out.print(k + " ");
    print(k - 1);
    System.out.print(k + " "); // 前後都做
  }

}
