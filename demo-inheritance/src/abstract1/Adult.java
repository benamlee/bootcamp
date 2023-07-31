
public abstract class Adult extends Person { // abstract -> means cannot be new Adult()
  // abstract class extends abstract class
  // implicitly "extends" abstract method


  public Adult(){
    super(); // new Person()
  }

  public abstract void read();

  public void eat() {
    System.out.println("I am Adult, eating");
  }

}
