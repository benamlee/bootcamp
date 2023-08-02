public interface Move extends BigMove {
  // not allow instance variables in interface


  // Constant ，公用 constant，習慣用全大寫
  static final int MAX_SPEED = 10; // public

  // Java -> naming convention 改名習俗 -> Camlcase
  // "noOfDay"

  // void left(); // public abstract

  // void right(); // public abstract

  // void up(); // public abstract

  // void down(); // public abstract

  // Behaviors
  void jump(); // public abstract // 合約內未寫好

  // No method implementations

  // After Java 8, lambda, stream
  default void print() { // instance method, implicitly public
    System.out.println("I am Java 8 default method");
  } // 合約內寫好

  static String concat(String a, String b) {
    return a + b;
  }

}
