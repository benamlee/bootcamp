package shape;

public class Circle {

  private int id; // instance variable/ attribute
  private double radius;

  // static -> shared variable
  // final -> one time initialization ONLY
  private static final double pi = 3.14159; // final value cannot be changed anymore // static variable

  public Circle() {
    this.id = AddCounter();
  }

  public int getId() {
    return this.id;
  }

  private static int counter; // calculate the number of circle objects being created
  // 如果 non-static -> 每個 object 都裝一個 counter==1
  // staitc -> 公家數 counter , create 左幾多個 object

  public static int AddCounter() {
    return ++counter; // +左先 代入value
  }

  public double area() {
    // pi=1; // The final field Circle.pi cannot be assigned
    return Math.pow(this.radius, 2) * pi;
  }


  public double circumference() { // instance method
    return 2 * radius * pi;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public static void main(String[] args) {
    Circle c = new Circle();
    c.setRadius(2);
    c.area();
    c.circumference();
    Circle c2 = new Circle();
    System.out.println(counter); // counter
    Circle c3 = new Circle();
    System.out.println(counter);
    System.out.println(c2.getId());
    System.out.println(c3.getId());


  }

}
