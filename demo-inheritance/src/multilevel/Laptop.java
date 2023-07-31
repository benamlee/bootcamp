package multilevel;

public class Laptop extends Machine { // Accepting Laptop is a kind of Machine
  // extends -> 在Machine的基礎上再形容Laptop
  // Laptop is subclass (childclass), Machine is superclass (parentclass)
  // Inherit Machine "double weight" (attribute)
  // Inherit Machine methods(start() and stop()) (behavier)

  private Keyboard keyboard;
  private Monitor monitor; // 形容詞 -> 組成部分

  private int volume;

  // subclass must call superclass constructor
  // -> Laptop 個波入面裝住另外 Machine 的一個細波

  public Laptop() {
    super(1.0d); // 可以 default 這個 Laptop empty constructor 帶 1.0 weight
    // implicitly call superclass empty constructor
    // new Machine()
  } // because they are extends relationship, and inside this constructor has no super(weight)

  public Laptop(Keyboard keyboard, Monitor monitor) { // implicitly call superclass empty constructor
    this.keyboard = keyboard;
    this.monitor = monitor;
  }

  public Laptop(String buttonType, int noOfButton, double length, // implicitly call superclass empty constructor
      double width) {
    this.keyboard = new Keyboard(buttonType, noOfButton);
    this.monitor = new Monitor(length, width); // new Laptop 同時 new Keyboard & Monitor
  }

  public Laptop(double weight, Keyboard keyboard, Monitor monitor) {
    super(weight); // new Machine(5); this is new a Machine object
    // super 放最前，before this. ，是規矩
    // i.e. super(); + this.setWeight(weight);
    // super() -> superclass empty constructor -> Machine()
    this.keyboard = keyboard;
    this.monitor = monitor;
  }

  @Override // Method Overriding, this is to double check parentclass method, 雖然唔寫都照做override
  public void start() { // 要繼承了才可以改寫
    super.start(); // Machine Start ...
    System.out.println("Laptop Start ...");
  }

  @Override // Method Overriding
  public void stop() {
    System.out.println("Laptop Stop ...");
  }

  // public static String staticMethod(String x, String y){ } // cannot be override a "final" method

  public void mute() {
    this.volume = 0;
  }

  public static void main(String[] args) {
    Laptop laptop = new Laptop("abc", 100, 15, 10);
    laptop.setWeight(3.0d);
    System.out.println(laptop.getWeight()); // 3.0
    laptop.start(); // Laptop start ...
    laptop.stop(); // Laptop stop ...

    Machine machine = new Machine(); // before set, weight = 0.0
    machine.setWeight(5.0d);
    System.out.println(machine.getWeight()); // 5.0
    machine.start(); // Machine start ...
    machine.stop(); // Machine stop ...

    Laptop laptop2 = new Laptop();
    laptop2.setWeight(10.0d);
    System.out.println(laptop2.getWeight()); // 10.0

    Laptop laptop3 = new Laptop();
    System.out.println(Machine.staticMethod("abc", "def"));
    System.out.println(Laptop.staticMethod("abc", "bcd"));
    // laptop3.staticMethod("abc", "def"); // can do, but not recommended, no meaning on laptop3 object

  }

}
