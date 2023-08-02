public class Student1 extends Person1 implements Runnable, Swimable, Move { // class signature, 睇program一定睇先
  // common to write X...able
  private String name;
  int score = 0;

  @Override
  public void breath() {}

  @Override
  public void run() { // 合約是public , so it must be public
    System.out.println("Student is running");
  }

  @Override
  public void swim() {
    System.out.println("Student is swimming");
  }

  // @Override
  // public void up() {
  //   this.score += 1;
  // }

  // @Override
  // public void down() {}

  // @Override
  // public void left() {}

  // @Override
  // public void right() {}

  @Override
  public void jump() {}

  // @Override
  // public void eat() { // 合約是public , so it must be public
  // System.out.println("Student is eating");
  // }

  public static void main(String[] args) {
    System.out.println(Move.MAX_SPEED); // 10

    Move move = new Student1();
    // move.up();
    // move.down();
    // move.left();
    // move.right();
    // System.out.println(move.MAX_SPEED); // can but not recommend this 寫法

    Swimable swimable = new Student1();
    swimable.swim();

    Person1 person1 = new Student1();
    person1.breath();
    person1.getAge();

    Move dog = new Dog();
    // dog.up();
    // dog.down();
    // dog.left();
    // dog.right();
    


  }

}
