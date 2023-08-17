package shape;

public class Circle extends Shape {
  int radius;

  @Override
  public double area() {
    return Math.pow(radius, 2) * Math.PI;
  }

}
