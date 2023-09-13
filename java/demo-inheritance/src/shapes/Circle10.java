package shapes;

public class Circle10 extends Shape {

  private double radius;

  public Circle10(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.pow(this.radius, 2) * Math.PI;
  }

public void print(){
  System.out.println("I am Circle10");
}

}
