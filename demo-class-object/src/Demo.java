public class Demo {
  public static void main(String[] args) {
    Car car = new Car(); // empty constructor
    Car car2 = new Car(1, 2, "white");
    Person person = new Person();
    Computer computer = new Computer();
    String str = new String("Hello");

    // new = 生產 Object @ heap inside memory

    // primitives is not object
    // no: int a = new int();

    System.out.println(car2.getNoOfWheel());
    System.out.println(car2.getCapacity());
    System.out.println(car2.getColor());

    car2.setColor("RED"); // car2 -> it's called object reference, storing the objcet address
    String str2 = new String("Hello"); // str -> object reference
    System.out.println(car2); // will print the address of object reference
    System.out.println(str2); // String is different wrapper class, will print string

    car2.setCapacity(55);
    System.out.println(car2); // change car2 attributes doesn't change address
    double[] aa = new double[] {0, 1, 2};
    int[] aa2 = new int[] {0, 1, 2};
    char[] aa3 = new char[] {1, 'a', 't', 6, 'u', 90, 65};
    System.out.println(aa);
    aa[2] = 5;
    System.out.println(aa2);
    System.out.println(aa3); // ASCII code

    Car car3 = new Car(1, 2, "red");
    car3 = new Car(2, 3, "blue"); // Car(1, 2, "red")仍然存在，但car3 reference已連接住新address
    // 舊Car內容冇野連住address，過一段時間，JAVA會自動delete佢，釋放memory，過程叫 AUTO GC

    // LEADER SKILL
    // 如果Data一直有針指住，Memory越儲越多，最終會爆ram，Memory
    // 要長期run到要消除針
    car3 = null; // <- disconnect address, 令支針不再指住object, null 不是 object, 舊 object 之後會消失
    car3 = new Car(1, 1, "BLACK"); // 再指個新 object
    // car3 is reference; Car(1,1,"BLACK") is object

    for (int i = 0; i < 3; i++) {
      int[] try3 = new int[3];
      System.out.println(try3);
    }
    // System.out.println(try3); // outside {} try3 is gone

    for (int i = 0; i < 3; i++) {
      int[] try3 = new int[3];
      System.out.println(try3);
    } // different address

    CarFactory carFactory = new CarFactory(); // new 左一個 carFactory
    carFactory.changeColor(car3, "white"); // carFactory 有個獨有 method 改 car
    System.out.println(car3.getColor());

    Car car5= new Car(1,2, "a");
    Car car6=car5; // car6 指住 car5 地址，改緊用一個 object
    car5.setCapacity(10);
    car6.setNoOfWheel(20);
    System.out.println(car6.getCapacity());
    System.out.println(car5.getNoOfWheel());


  }
}
