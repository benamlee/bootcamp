package swimable;
public class Person implements Swimable {
  String name;

  public Person(String name) {
    this.name = name;
  }

  @Override
  public void swim() {
    System.out.println("Person is swimming");
  }

  @Override
  public String toString(){
    return "[name="+this.name+"]";
  }

  public static void main(String[] args) {
    Person person = new Person("ben");
    person.swim();

    // Swimable person1 = () -> System.out.println("Person 1 is swimming");
    // person1.swim();

    // Swimable person2 = () -> System.out.println("Person 2 is swimming");
    // person2.swim();
  }
}
