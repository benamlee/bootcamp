package shapes;

import java.math.BigDecimal;
import multilevel.B;

public abstract class Shape { // abstract class 不一定有 abstract method

  public abstract double area(); // 有 abstract method => 一定係 abstract class
  // area(): each shape has its way to calculate
  // must abstract to force each subclass to write its method

  public static void main(String[] args) {
    // BigDecimal b = BigDecimal.valueOf(5.0d);
    // b.add(BigDecimal.valueOf(3.0d));
    // System.out.println(b.doubleValue());
    // BigDecimal review

    // Shape area() example
    Circle10 circle = new Circle10(10.0d);
    Square10 square = new Square10(3.0d);
    Shape[] shapes = new Shape[] {circle, square}; // Shape Class 裝住所有不同的 childclass 的 element
    System.out.println(Shape.area(shapes));

  }

  // Factory Pattern
  // 概括所有subclass自己define的method，計算總和
  public static double area(Shape[] shapes) {
    BigDecimal total = BigDecimal.valueOf(0);
    for (Shape s : shapes) {
      total = total.add(BigDecimal.valueOf(s.area())); // 每個 area() 用番自己 class, override area() method 
    }
    return total.doubleValue();
  }


}
