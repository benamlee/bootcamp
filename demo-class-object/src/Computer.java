public class Computer {
  // attributes
  private int ram;
  private int weight;
  private String color;



  // Constructors (唔寫係default左有係度)
  public Computer() {} // 可以有empty -> default value

  // 2個都寫，可以係default value，可以係有set color
  public Computer(String color) { // (1) No return type, (2) Constructor name = Class name ; then it is a constructor
    this.color = color;
  }

  public Computer(int ram, int weight, String color) { // (1) No return type, (2) Constructor name = Class name ; then it is a constructor
    this.ram = ram;
    this.weight = weight;
    this.color = color;
  }

 public int getRam() {
    return this.ram;
  }

 public int getWeight() {
    return this.weight;
  }


  public String getColor() {
    return this.color;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setColor(String color) {
    this.color = color;
  }


}
