public class Circle {

  public static double area(double radius) {
    return radius * radius * 3.14159;
  }

  public static double perimeter(double radius) {
    return 2 * radius * 3.14159;
  }

  public static void main(String[] args) {
    double area = area(4.3d);
    double perimeter = perimeter(4.3d);
  }

}
