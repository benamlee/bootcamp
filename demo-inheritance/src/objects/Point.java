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



  }


}
