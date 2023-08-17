package shape;

public class Square extends Shape {

  int length;

  @Override
  public double area() {
    return Math.pow(this.length, 2);
  }

}
