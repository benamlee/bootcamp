package shape;

public class Edge {
  private double length;
  private String color;

  public Edge(double length, String color) {
    this.length = length;
    this.color = color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor(){
    return this.color;
  }



}
