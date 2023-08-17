package person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements Swimable {


  @Override
  public void swim() {
    System.out.println("Person is swimming");
  }

  public static void main(String[] args) {
    Person p1 = new Person();
    Staff s1 = new Staff();
    List<? extends Swimable> l1 = Arrays.asList(p1, s1); // this is OK
    // review (below is not OK)
    // List<? extends Swimable> l2 = new ArrayList<>();
    // l2.add(s1); // List<? extends Swimable> 太闊 add 不到，也不能downcast
    // l2.add(p1);
    
    Swimable.start(l1);

  }
}
