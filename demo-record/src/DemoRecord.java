import java.util.HashSet;
import java.util.Set;

public class DemoRecord {
  public static void main(String[] args) {
    // Person class and record Person1 have no relation
    Person person = new Person("John", 30);

    Person1 person1 = new Person1("John", 30);
    Person1 anotherPerson1 = new Person1("John", 30);

    System.out.println(person.getAge()); // 30
    System.out.println(person1.age()); // 30

    System.out.println(person.getName()); // John
    System.out.println(person1.name()); // John

    System.out.println(person1.equals(anotherPerson1)); // true,
    System.out.println(person1); // Person1[name=John, age=30] // class[attributes]
    System.out.println(anotherPerson1); // Person1[name=John, age=30]

    System.out.println(person1.hashCode() == anotherPerson1.hashCode()); // true

    // HashMap, Set -> equals(). hashCode
    Set<Person1> set = new HashSet<>();
    set.add(person1);
    System.out.println(set.add(anotherPerson1)); // false

  }
}
