import java.util.ArrayList;
import box.Box;
import zoo.Animal;
import zoo.Cat;
import zoo.Dog;
import zoo.Zoo;

public class DemoGenerics {

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<>();

    // Animal Example
    Zoo<Dog> zoo1 = Zoo.of(Dog.of("xyz"));
    // zoo1.setAnimal(new Cat()); Compile error, strong type check
    zoo1.setAnimal(Dog.of("def"));

    Zoo<Animal> zoo2 = Zoo.of(new Cat());
    zoo2.setAnimal(new Animal());
    zoo2.setAnimal(Dog.of("abc"));
    zoo2.setAnimal(new Cat());

    // Zoo<String> zoo3 = Zoo.of("abc"); // String is not extending Animal

    Box<Integer> box = getBox(Integer.valueOf(100));
    Object object = getBox(Double.valueOf(1.0d));
    // Object object <- Box<Double>
    Box<Double> d1 = (Box<Double>) object;
    for (double d : d1.getNumbers()) {
      System.out.println(d); // 1.0
    }
  }

  public static <T extends Number> Box<T> getBox(T element) {
    return new Box<T>(element);
  }
}
