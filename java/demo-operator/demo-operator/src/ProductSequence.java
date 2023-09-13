public class ProductSequence {
  public static void main(String[] args) {
    // 0, 1, 2, 3, 4, 5, ...
    // print out 0, 2, 6, 12, 20, ...
    // print the first 20 numbers, based on the above requirment
    String str = "";
    for (int i = 0; i < 20; i++) {
      str += i * (i + 1);
      // System.err.println(i*(i+1));
      if (i < 20 - 1) {
        str += ", ";
      }
    }
    System.out.println(str);

    for (int i = 0; i < 20; i++) {
      System.err.println(i * (i + 1));
    }

    int a, b, c; // can declare 2 variables in one go
    for (int i = 0; i < 20; i++) {
      a = i;
      b = i + 1;
      c = a * b;
      System.out.print(a * b + " "); // here a*b will be calculated before it trans to String, can use c
    }

  }
}
