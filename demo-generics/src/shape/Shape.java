package shape;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Shape { // 是描象，是歸納，不是功能，不會寫成 interface

  abstract double area(); // implicitly public

  // public static <T extends Shape> double area(List<T> shapes) {
  public static double area(List<? extends Shape> shapes) { // 更簡潔
    // double area = 0; // double 相加有問題!!!!
    // shapes.add(new Circle()); // compile-time check, type-safe // polymorphism not apply inside <>
    BigDecimal total = BigDecimal.ZERO;
    for (Shape shape : shapes) {
      total = total.add(BigDecimal.valueOf(shape.area()));
    }
    return total.doubleValue();
  }

  public static void main(String[] args) {
    // Polymorphism
    Shape shape = new Circle(); // Polymorphism
    Shape shape2 = new Square(); // Polymorphism
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    // shapes = new ArrayList<Circle>(); // compile-error, this is not polymorphism

    // 內文唔會咁寫(next line...<? extends Shape>)
    List<? extends Shape> list = new ArrayList<Circle>(); // 只可以入一種同類//咁寫add唔到野, =>廢了
    List<Circle> list11 = new ArrayList<Circle>();
    List<Square> list12 = new ArrayList<Square>();
    list = list11;
    list = list12;
    for (Shape s : list) {
      System.out.println(s);
    }
    Circle c1 = new Circle();
    Circle c2 = new Circle();
    list11.add(c1);
    list11.add(c2);
    list = list11;
    for (Shape s : list) {
      System.out.println(s);
    }
    // list = new ArrayList<Square>();
    // Shape s1 = new Square();
    // Shape s2 = new Square();

    // list.add(new Circle()); // compile check refer declaration



    List<Shape> list2 = new ArrayList<>(); // 所有 Shape都入得
    list2.add(shape);
    list2.add(shape2);
    list2.add(c1);
    // list2.add(123);

    List<Map<String, String>> list3 = new ArrayList<>();

  }


}
