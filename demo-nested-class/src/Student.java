// Outer Class // Can access static nested class attribute

import java.util.List;

public class Student {
  private String name;
  private Bag bag;

 
  // constructor, getter, setter, static method
  public Student() {}

  // method -> Bag.method, instance variable
  public int getBagSize() {
    return this.bag.size;
  }

  public Student(String name) {
    this.name = name;
    bag = new Student.Bag();
  }

  public String getName() {
    return this.name;
  }

  public Bag getBag() {
    return this.bag;
  }

  public void setName() {
    this.name = name;
  }

  public void clearBag() {
    // Outer Class access "Static nested class" static method
    Bag.clear(this.bag);
  }

  private static int add(int a, int b) { // if this is static, nested class can use, if no, cannot
    return a + b;
  }

  @Override
  public String toString() {
    return "Student[name=" + this.name + ", " + this.bag + "]";
  }

  public static void printHello() {
    System.out.print("i am Student");
    System.out.print(" ");
    Bag.printHello();
    System.out.print(" ");
    Grade.printHello();
  }

  public int getScoreAtOutter(int score) {
    return new Grade(score).getScore(); // ???
  }

  // method -> Bag.method, instance variable //

  // Static nested class // Cannot Access Outer Class Attribute
  private static class Bag { // Bag class and Student class is non-related
    int size;
    List<String> strings;

    // constructor
    // getter, setter
    // static method & variable
    // instance method
    public Bag() {}

    public Bag(int size) {
      this.size = size;
    }

    public int getSize() {
      return this.size;
    }

    public void setSize() {
      this.size = size;
    }

    public static void clear(Bag bag) {
      bag.strings.clear();
      add(1, 3); // compile error???
    }

    // public void printStudentGrade() {
    // System.out.println(this.name);
    // }

    public static void printHello() {
      System.out.print("i am bag");
      System.out.print(" ");
      Grade.printHello();
    }

    @Override
    public String toString() {
      return "Bag[size=" + this.size + ", strings=" + this.strings + "]";
    }

  }

  // Inner class (non-static nested class)
  private class Grade {
    private int score;

    private char getGrade() { // this is presentation method, A,B,C not attribute of Grade
      switch (this.score) {
        case 90:
          return 'A';
        case 80:
          return 'B';
        case 70:
          return 'C';
        default:
          return 'F';
      }
    }

    private Grade(int score) {
      this.score = score;
    }

    private int getScore() {
      return this.score;
    }

    private void printStudentName() {
      System.out.println(Student.this.name); // can get outter class attributes
    }

    private static void printHello() {
      System.out.print("Hello");
    }

  }

  public static void main(String[] args) {
    Student student = new Student("Ben");
    Student.Bag bag = new Student.Bag(); // Bag is just a class that is static and inside Student
    Student.Grade grade = new Student("BenBen").new Grade(70); // instance inner class, use outer obj to .new inner obj
    grade.printStudentName();
    Student.Grade math = student.new Grade(100);
    Student.Grade chem = student.new Grade(99);
    Student.Grade phy = student.new Grade(90);
    math.printStudentName();
    chem.printStudentName();
    phy.printStudentName();
    System.out.println(math.getGrade());
    System.out.println(chem.getGrade());
    System.out.println(phy.getGrade());
    // Student benben
    // Student.printHello();
    Bag.printHello();
    System.out.println();
    Student.printHello();


  }
}
