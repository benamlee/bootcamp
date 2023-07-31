
public class Student extends Adult {

public Student(){
  super(); // new Adult()
}

  public void sleep(){
    System.out.println("I am student, sleeping");
  }

  public void read(){ // 終結所有abstract method
    System.out.println("I am student, reading");
  }

  public static void main(String[] args) {
    Student student = new Student();
    student.sleep();
    student.read();
    student.run();
    student.eat();

    System.out.println(student.getAge()); // 0
  }

}
