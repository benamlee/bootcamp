package math;

public class MathDemo {

  public static int calculate(int i, int j, MathOperation formula) {
    return formula.operate(i, j);
  }

  public static void main(String[] args) {
    MathOperation addition = (a, b) -> a + b; // variable name can change
    MathOperation substract = (x, y) -> x - y; // all defination of how is the method
    MathOperation multiply = (x, y) -> x * y;
    MathOperation divide = (x, y) -> x / y;

    System.out.println(calculate(1, 3, addition)); // 4
    System.out.println(calculate(10, 2, divide)); // 5
    System.out.println(calculate(2, 3, (i, j) -> i % j + (int) Math.pow(j, 2))); // 11, can define anywhere
    // force to use operate
    System.out.println(addition.operate(5, 10));


  }
}
