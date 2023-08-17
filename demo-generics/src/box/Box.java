package box;
import java.util.ArrayList;

public class Box<T extends Number> { // compile-time check

  private ArrayList<T> numbers;

  private Box() {
    numbers = new ArrayList<>(); // new Box, have to new object(ArrayList), otherwise numbers is null, just name without object
  }

  public Box(T number) {
    this(); // call the empty constructor of Class Box
    numbers.add(number);
  }

  public ArrayList<T> getNumbers() {
    return this.numbers;
  }

  public void add(T number) {
    numbers.add(number); // null pointer
  }

  public int size() {
    return this.numbers.size();
  }

  // public void setNumbers(T[] numbers) {
  // this.numbers=numbers;
  // }



  public static void main(String[] args) {
    // Box<String> box1 = new Box<>(); // String not Number // compile-time check
    Box<Integer> box1 = new Box<>(100);
    System.out.println(box1.size()); // 1

    // box1 = new Box<>("abc"); // new Box<>("abc") is not Box<Number>

  }

}
