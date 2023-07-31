package multilevel;
import javax.crypto.Mac;
// abstract -> 只比人地 extends (deleted)
public class Machine { 
  // learn how to describe a class
  // 不寫constructor -> 有 empty constructor

  // (here) 形容詞 要比所有 Machine 繼承

  private double weight;


  public Machine() {}

  public Machine(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void start() {
    System.out.println("Machine start ...");
  }

  public void stop() {
    System.out.println("Machine stop ...");
  }

  public static final String staticMethod(String x, String y) {
    return x + y;
  }

  // Factory Pattern
  public static Machine produce(int code) { // 一個 parent type 接得住所有 childclass type
    switch (code) {
      case 1:
        return new Machine();
      case 2:
        return new Laptop(); // Laptop type can be a kind of Machine type
    }
    return new Machine();
  }

  public static void main(String[] args) {
    Machine machine1 = Machine.produce(1); // Machine
    machine1.stop(); // Machine stop ...
    Machine machine2 = Machine.produce(2); // Laptop
    machine2.stop(); // Laptop Stop ...

    int pocketMoney = 100;
    boolean stopCondition = pocketMoney < 0;
    int code = 1;
    if (stopCondition) {
      Machine.stop(code);
    }

  }

  public static void stop(int code) {
    Machine machine = Machine.produce(code);
    machine.stop(); // different child class will have different implementation
  }



}
