public class Methods {
  // 預先define method，在冇comment的情況下，改method名可變得readible；統一複雜算法，避免重複的地方打錯code
  // 在main前或後都得
  // public static "return type" "name" (input parameters) {}, nothing return = void
  // 比大家communication，不同人改寫時用一樣的方式做
  public static void main(String[] args) { // method name: main(), String[] is a string array, args=arguments
    // main(String[] args) // JVM will look for this main method
    String str = "hello";
    str = str + " world"; // append operation

    // Approach 1
    System.out.println("Hello in print() method.");
    // Approach 2: by method
    print(); // print "Hello in print() method."

    // Approach 1
    int x = 10;
    int y = 100;
    int sum = x + y; // 110
    // Approach 2
    int z = sum(x, y); // z=110
    int i = sum(1000, -30); // z=970
    // int o = sum("hello",123); // cannot put String into variable defined to be int

    // if (sum(1000, -30) == 970) {
    if (i == 970) {
      System.out.println("the sum is 970");
    }

    // call method2
    method2("hello"); // print string=hello
    method2("Github"); // print string=Github
    method2("");

    double circleArea = 5 * 5 * pi();
    System.out.println("circle area=" + circleArea);


  }

  public static void print() { // method name: print()
    System.out.println("Hello in print() method.");
  }

  public static int sum(int a, int b) { // define: int sum(,)
    // left int = return type
    // the int inside the bracket are parameters
    int c = a + b;
    return c; // 有return應該要有variable接住
  }

  public static int substract(int x, int y) {
    return x - y; // execute x - y first, then return the result
  }

  public static void method2(String str) {
    if (str == null || "".equals(str)) { // null is not empty, empty is "" ; null is exception for string to use ==
    // 要咁寫 "".equals(str)，not咁寫 str.equals("")
      return;
    }
    System.out.println("string=" + str);
  }

  public static double pi() {
    return 3.14159;
  }

  public static int a(int a){
    return 1;
  }
  public static int a(int a, int b){
    return 1;
  } // method可以同名，但input不能一樣
  // method不是同名決定，是用名加input決定

}
