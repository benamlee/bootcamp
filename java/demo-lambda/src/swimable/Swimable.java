package swimable;
// lambda 係一種寫法
// Annotation: check if this interface has one abstract method only (one and only one)
// if no, compile-error

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface // when one and only one method -> default it's @FunctionalInterface
public interface Swimable {
  void swim();
  // void read();

  public static void main(String[] args) {
    // Lambda: have to use "return", if use {}
    Comparator<Person> sortByNameDesc = (Person p1, Person p2) -> {
      return p2.name.charAt(0) > p1.name.charAt(0) ? 1 : -1;
    };
    List<Person> persons = Arrays.asList(new Person("Chan"), new Person("Lee"));
    Collections.sort(persons, sortByNameDesc);
    System.out.println(persons);

    Swimable person1 = () -> System.out.println("Person 1 is swimming"); // () repersent the unique method, if(int a)
    person1.swim();

    Swimable person2 = () -> {
      System.out.println("Person 2 is swimming");
      System.out.println("Person 2 is swimming");
      System.out.println("Person 2 is swimming");
      System.out.println("Person 2 is swimming");
    };
    person2.swim();

    Swimable person3 = () -> { // use {}
      System.out.println("Person 1 is swimming");
    };
    person3.swim();
  }
}
