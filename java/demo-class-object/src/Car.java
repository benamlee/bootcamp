public class Car {
  // Instance Variable (Instance -> Object)
  // Member Variable
  private int noOfWheel;
  private int capacity;
  private String color;

  public Car() {}

  public Car(int noOfWheel) {
    this.noOfWheel = noOfWheel;
  }

  // public Car(int capacity){ // 就咁撞左Car(int ...) , input 唔知係邊個 , 所以冇得同名又同input
  // }

  public Car(int noOfWheel, int capacity, String color) {
    this.noOfWheel = noOfWheel;
    this.capacity = capacity;
    this.color = color;
  }

  public void setNoOfWheel(int noOfWheel) {
    this.noOfWheel = noOfWheel;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getNoOfWheel() {
    return this.noOfWheel;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public String getColor() {
    return this.color;
  }



}
