public record Person1(String name, int age) implements TestInterface{
  // Immutable Objects
  // final class, i.e. cannot be extends
  // support Generics
  // support Interface, but cannot further extend (extends Object.class)
  // private final String name;
  // private final int age;
  // All-args constructor ONLY
  // ALL Getters
  // No Setters (final instance variable)
  // custom static methods, static variables
  // custom constant
  // custom instance methods
  // No other instance variables
  // Already @Override equals(), hashCode(), toString()

  // int salary

  // the instance become final, i.e. private final String name; // once assign
  // public void setName(String name){
  // this.name=name;
  // }

  static int counter = 0;

  static final int MAX_VALUE = 100; // constant, remember the naming, only constant can be all uppercase and underscore

  public boolean isElderly(int age) {
    return this.age >= 65;
  }

  // Tools
  public static int add(int x, int y) {
    return x + y;
  }

  @Override
  public void read(){}

}
