package objects;

import java.util.Objects;

public class Ball { // implicitly extends Object

  private String color;

  public Ball(String color) {
    this.color = color;
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.color);
  }

  // 唔 override 的話，a.equals(b) is a == b
  @Override // 要背 // 只要所有 attributes 一樣，他們就是 equal
  public boolean equals(Object o) {
    // if address same, values inside the object must be same
    if (this == o)
      return true;
    if (!(o instanceof Ball)) // to check is o belong to Ball class
      return false;
    Ball ball = (Ball) o; // downcast
    return ball.color.equals(this.color); // true or false // ball.color(String) .equals() here is using String class
  }

  @Override
  public String toString(){
    return "[color="+this.color+"]";
  }

  public static void main(String[] args) {
    Ball b1 = new Ball("Blue"); // address 1
    Ball b2 = new Ball("Blue"); // address 2
    System.out.println(b1 == b2); // false, cos address different
    System.out.println(b1.equals(b2)); // true, cos all attributes of b1 & b2 are the same
    System.out.println(b1); // 默認有 .toString
    System.out.println(b1.toString());



  }

}
