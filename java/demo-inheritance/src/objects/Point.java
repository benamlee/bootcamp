package objects;

import java.util.Objects;
import shapes.Circle10;
import shapes.Shape;

public class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  // @Override
  // public String toString(){
  // return "[x="+this.x+", y="+this.y+"]";
  // }


  @Override
  public boolean equals(Object o) {
    if (this == o) // address
      return true;
    if (!(o instanceof Point)) // Class
      return false;
    Point point = (Point) o;
    // return point.x == this.x && point.y == this.y;
    return Objects.equals(point.x, this.x) && Objects.equals(point.y, this.y);
  }


  public static void main(String[] args) {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 1);
    Point p3 = new Point(1, 2);
    System.out.println(p1 == p2); // false
    System.out.println(p1.equals(p2)); // true
    System.out.println(p1.equals(p3)); // false

    System.out.println(p1.toString()); // objects.Point@3e1
    System.out.println(Points.toString(p1)); //

    long l1 = 4200000000L;
    long l2 = 4200000000L;
    System.out.println(l1 == l2);

    Long l = 1L; // Long = Long.valueOf(1L); 原本要咁寫
    int i = 1;
    // l, unbox Long -> primitive long
    System.out.println((l == i) + " auto box & unbox "); // true, finnally long vs int
    // not the same TYPE
    // i, auto-box -> Integer, Object -> Integer 裝住 int
    System.out.println(Objects.equals(l, i) + " use Objects.equals()"); // false, this is a big bug
    System.out.println(l.equals(i) + " reason"); // reason: "Integer instanceof Long" is false

    Point.print(10L); // long -> autobox -> Long
    // Point.print(10); // connot convert int to Long, compile error
    Point.print(Long.valueOf("10")); // Long object
    Point.print((long) 10); // int -> long -> autobox -> Long

    if (Long.valueOf("100") < 101) {
      // convert Long 100 -> long 100
      // 101 -> int
      // long vs int
      System.out.println("hi");
    }

    if (Boolean.valueOf(false) == false) {
      // right: false -> boolean
      // left: Boolean false -> boolean false
      // boolean vs boolean
      System.out.println("yo");
    }
    System.out.println(Boolean.valueOf(false).equals(false));

    System.out.println((10000L == 10000) + " true long vs int"); // primitives compare

  }

  public static void print(Long l) {
    System.out.println("l=" + l);
  }

}
