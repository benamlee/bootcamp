

// "final Class" means cannot be extends -> no "final abstract"
public abstract class Person { // abstract -> means cannot be new Person() 不想被人new
  
private int age;

private double height;

public Person(){}

public int getAge(){
  return this.age;
}

public double getHeight(){
  return this.height;
}

// May contain instance method with implementation
public void run(){
  System.out.println("I am Person, running");
}

// May contain abstract method (without implementation)
public abstract void sleep(); // childclass有各自的defination，呢度唔寫最後都要寫


}
