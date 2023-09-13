package unchecked;
public class DemoArithmeticException {
  public static void main(String[] args) {
    int i = 0;
    int n = 100;
    int result = 0;
    try {
      result = n / i;

    } catch (ArithmeticException e) {
      result = 0;
    }
    System.out.println("result=" + result);
  }

}
