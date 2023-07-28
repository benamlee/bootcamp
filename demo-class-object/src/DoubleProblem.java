import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleProblem {
  public static void main(String[] args) {
    double result = 0.1 + 0.2;
    System.out.println(result); // 0.30000000000000004

    if (result == 0.3)
      System.out.println("result == 0.3");
    else
      System.out.println("result != 0.3");

    System.out.println(0.3 / 0.1); // 2.9999999999999996
    System.out.println(0.2 * 0.1); // 0.020000000000000004

    // Solution:
    BigDecimal b = new BigDecimal(5);
    BigDecimal b2 = BigDecimal.valueOf(4);
    // BigDecimal b3 = 5.0; // Not OK
    Double d = 5.0d;

    // b value dont change
    System.out.println(b.multiply(b)); // 25
    System.out.println(b.subtract(b2)); // 1
    System.out.println(b.add(b)); // 10
    System.out.println(b.divide(b));
    System.out.println(b.add(new BigDecimal(7))); // 12

    System.out.println(b.compareTo(b2)); // 1
    System.out.println(b2.compareTo(b)); // -1
    System.out.println(b.compareTo(BigDecimal.valueOf(5)));
    BigDecimal b3 = BigDecimal.valueOf(3.456);
    System.out.println(b3.setScale(2, RoundingMode.UP));
    System.out.println(b3.setScale(2, RoundingMode.DOWN));

    System.out.println(b.equals(b2)); // false

    BigDecimal b4 = BigDecimal.valueOf(5);
    System.out.println(b.equals(b4)); // value equal
    System.out.println(b == b4); // false address

    System.out.println(b4.remainder(BigDecimal.valueOf(3)));
    // System.out.println(b);
    // System.out.println(b2);
    // System.out.println(d);

    System.out.println(b4.multiply(b4));


  }
}
