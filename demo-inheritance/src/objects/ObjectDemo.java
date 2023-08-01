package objects;

import shapes.Circle10;
import shapes.Shape;

public class ObjectDemo {
  // Rule 1: All class extends Object implicitly

  String name = "hello";

  @Override
  public String toString() {
    return this.name;
  }

  public static void main(String[] args) {
    // Example 1: ObjectDemo extends Object
    ObjectDemo objectDemo = new ObjectDemo();
    // hash code -> int
    objectDemo.hashCode(); // another presentation of object reference
    // Because hash code has a short range of value storage
    // so, it cannot store all memory address (object reference) in your machine
    // => object reference is unique, but hash code may duplicate

    int[] arr = new int[] {1, 2, 3};
    System.out.println(arr); // [I@2f92e0f4
    // 唔寫=call .toString
    System.out.println(arr.toString()); // [I@2f92e0f4
    // 用緊Object class 的 .toString(), (Array class 本身冇寫 override method)

    String str = "abc";
    System.out.println(str); // cos String class has override toSting()

    // not yet override // objects.ObjectDemo@372f7a8d // after override // hello
    System.out.println(objectDemo);
    System.out.println(objectDemo.toString());

    System.out.println("abc hashCode()=" + str.hashCode()); // 96354
    // a * 31^2 + b * 31^1 + c
    System.out.println(97 * (int) Math.pow(31, 2) + 98 * 31 + 99); // 96354

    ObjectDemo a = new ObjectDemo();
    ObjectDemo b = new ObjectDemo();
    System.out.println(a); // objects.ObjectDemo@33c7353a
    System.out.println(b); // objects.ObjectDemo@681a9515

    if (a == b) { // address (object reference)
      System.out.println(true);
    } else {
      System.out.println(false);
    }

    Integer i1 = 3;
    System.out.println(i1.hashCode()); // 3
    Long l1 = 4295000000L;
    System.out.println(l1.hashCode()); // overflow // 32705 cos return int

    // equals()
    String s1 = "abc";
    String s2 = "abc";
    System.out.println(s1.equals(s2)); // true

    // instanceOf, Object.class
    Object obj = new String("abc");
    Shape shape = new Circle10(5.0d);
    System.out.println(obj instanceof String); // true
    obj = Long.valueOf(10);
    System.out.println(obj instanceof String); // false
    System.out.println(obj instanceof Long); // true
    obj = shape;
    System.out.println(obj instanceof String); // false
    System.out.println(obj instanceof Shape); // true
    // shape.print(); // no print() method in shape
    // Hide child print() method
    Circle10 c = (Circle10) shape; // downcast
    c.print(); // Circle10 Class object can use object method

    // Number
    Integer int1 = Integer.valueOf(100);
    System.out.println(int1 instanceof Number); // true
    Double d1 = Double.valueOf(100);
    System.out.println(d1 instanceof Number); // true

    // Primitives, for comparison, we use ==
    // Wrapper Class, for comparison, we use equals
    System.out.println("Wrapper Class");
    Integer j1 = 128;
    Integer j2 = 128;
    System.out.println(j1.equals(j2) + " Override equals method"); // Override equals method in Integer Class
    System.out.println(j1 == j2); // false, internal cache
    j1 = 127;
    j2 = 127;
    System.out.println(j1.equals(j2) + " Override equals method"); // Override equals method in Integer Class
    System.out.println((j1 == j2) + " internal cache"); // true, internal cache
    Boolean bool1 = false;
    Boolean bool2 = false;
    System.out.println(bool1.equals(bool2)); // true
    System.out.println(bool2.equals(false)); // true
    System.out.println((bool1 == bool2) + " internal cache");

    String sss = new String("a");
    String ss1 = "a";
    String ss2 = "a";
    System.out.println(ss1 == ss2); // true
    System.out.println("a".equals(sss)); // true
    System.out.println(ss1 == sss); // false


  }

}
