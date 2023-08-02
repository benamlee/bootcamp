public interface Move2 {
  
    // After Java 8, lambda, stream
    default void print() { // instance method, implicitly public
      System.out.println("I am Java 8 default method");
    } // Duplicate default methods named print with the parameters () and () are inherited from the types Move2 and Move


}
