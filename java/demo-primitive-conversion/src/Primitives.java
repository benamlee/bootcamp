public class Primitives {
  public static void main(String[] args) {
    // Correct Syntax
    // Upcasting (Implicit conversion隱藏地做)
    // byte -> short -> int -> long -> float -> double
    byte b = 2;
    short s = b; // byte -> short, upcasting (promotion)
    int i = s;
    long l = i;
    float f = l;
    double d = f;
    // char -> int // ASCII 讀ask ki
    char c = 'A';
    int j = c;

    // Downcasting
    double d2 = 10.03d;
    // float f2= d2; // why error? double precision is larger than float
    float f2 = (float) d2; // developer take responsibility for the risky of data loss // 強行轉換

    short s2 = 128;
    // byte b2 = s2; // error
    byte b2 = (byte) s2; // Explicit conversion強行轉換
    System.out.println("b2=" + b2); // -128

    // for (byte k = 127; k < 129; k++) { // 128 -> =128
    // System.out.println("hello");
    // }

    // long[] arr = new long[Integer.MAX_VALUE]; //
    // for (int n = 0; n < arr.length; n++) {

    // }u
    System.out.println(Integer.MIN_VALUE);


    char c2 = 'B'; // 66, ASCII code
    if (c2 == 'B') {
      System.out.println("c2 is B");
    }
    if (c2 == 66) {
      System.out.println("c2 is 66");
    }
    char c3 = 67;
    if (c3 == 'C') {
      System.out.println("c3 is C");
    }

    // ASCII (int) to char
    int g = 'a';
    int g2 = 10;
    char k = (char) g2; // downcasting, g2 is int, put int variable into char will not check
    char k2 = 66; // why? downcast, 66 is ASCII code, put directly number will convert

    //
    int h = (int) 1000L; // downcasting, Explicit conversion強行轉換
    short s10 = 128;
    byte o = (byte) s10;
    // byte o2 = 128; // error

    // char try2=97;
    // System.out.println(try2);

    double try3 = 3452.773543d;
    // float try3 = 463.9999d; downcasting
    int try4 = (int) try3;
    System.out.println(try4);

    char character = 'a' + 1;
    if (character == 'b') {
      System.out.println("character=" + character);
    }
    if (character == 98) {
      System.out.println("character=" + character);
    }
    if (character > 'a') { // ASCII
      System.out.println("character>a");
    }


  }
}
