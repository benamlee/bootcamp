public abstract class Building {

  double height;

  public void print() {
    System.out.println("I am Building");
  }

  public void print2(){
    this.print(); // House address still direct to House override method
  }


}
