public class LogicalOperators {
  public static void main(String[] args) {
    boolean isExpensive = true;
    boolean isWorthToBuy = false;
    boolean result = isExpensive && isWorthToBuy; // false
    // && Operator -> AND
    // || Operator -> OR
    boolean result2 = isExpensive || isWorthToBuy; // true
    // System.out.println(result);
    // System.out.println(result2);
    int a = 5;
    int b = 10;
    int c = 13;
    boolean result3 = a > 6 && b < 12;
    // System.out.println(result3);
    boolean result4 = c < 15 || a > 6 && b < 12; // AND is before OR
    boolean result5 = c < 15 || (a > 6 && b < 12); // ()show more readable
    boolean result6 = a < 6 || b < 9 || c < 9;
    // System.out.println(result6);

    // ==, >=, <=, !=

    // ==, means asking if they equal -> true/ false
    // =, assignment

    boolean result7 = a == b; // false
    boolean result8 = a >= 5; // true
    boolean result9 = c <= 13; // true
    boolean result10 = c != 13; // false
    // ! -> NOT
    boolean result11 = !(c < 13); // true, 加了()變了T/F event
    boolean result12 = !(b == 9) && c != 13;
    // System.out.println(result12);

    boolean try1 = !false;
    // System.out.println(try1);

    // Operators Precedence
    int result13 = (1 + 9) * 3; // 30
    int result14 = ++result13 + 1;
    System.out.println(result14);
    System.out.println(result13);
    int i = 27;
    int result15 = i++ + 3; // ++ after i is not add to result15
    // result15 = i++ +3; it means ->
    // result15 = i +3;
    // i = i + 1;
    System.out.println(result15); // result15 = 30
    System.out.println(i); // i = 28

    boolean result16 = 25 + 2 < result15 - 2; // true
    System.out.println(result16);

    int x = 5;
    int y = 10;
    int z = x += 3 * y; // 1. 3*y=30, 2. 5+30=35
    System.out.println("z=" + z);
    System.out.println("x=" + x); // x += means x=x+ also is assignment to x
    int result171 = (x++ + 2) * x++;
    System.out.println("result171=" + result171);
    System.out.println("x=" + x);

    int x2 = 5;
    int result17 = (x2++ + 2) * x2++; // 1. 5+2=7, x->6, 2. 7*6=42, x->7
    // ()入面會做哂先
    // result17 = (x2++ + 2) * x2++;
    // result17 = (5 + 2) * x2++;
    // x2 ++; x2 = 6
    // result17 = 7 * 6; result17 = 42
    // x2 ++; x2 = 7
    System.out.println("result17=" + result17);
    System.out.println("x2=" + x2);


  }
}
