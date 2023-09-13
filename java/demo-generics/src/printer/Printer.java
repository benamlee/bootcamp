package printer;
// Generic

public class Printer<T> { // T 我宜家未知放咩，用既時候放真 CLASS
  // 1. Class Signature, add <>, T represent any Class, now just a name
  T value; // T 不是 existing CLASS
  // whatever class declare, T become the class
  T value2;

  // 用 Object 雖然裝到，但要用到時要downcast，危險
  Object object; // Object is existing real class

  public void setObject(Object object) {
    this.object = object;
  }

  public Object getObject() {
    return this.object;
  }


  public T getValue() { // T is any TYPE of CLASS
    return this.value; // value is attribute name
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setValue2(T value2) {
    this.value2 = value2; // here force input T same Class
  }

  public void print() {
    System.out.println(this.value);
  }

  public static void main(String[] args) {
    Printer<String> p1 = new Printer<>();
    // Strong Type checking -> check if you put a real class into <>
    p1.setValue("abc");
    System.out.println(p1.getValue());

    Printer<Integer> p2 = new Printer<>();
    p2.setValue(333);
    System.out.println(p2.getValue());
    p2.setValue2(123);

    Printer<NumberPrinter> np1 = new Printer<>();
    np1.setValue(new NumberPrinter());
    np1.getValue().number = 3;
    np1.print();
    np1.getValue().print();

    // 專登做唔同野用Object
    Printer<Boolean> p3 = new Printer<>();
    p3.setObject("String");
    System.out.println(((String) p3.getObject()).charAt(1)); // downcast just ensure can use .charAt

    Object a = new NumberPrinter();


  }
}
