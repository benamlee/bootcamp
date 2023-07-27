package shape;

public class Square {
  private Edge[] edges; // instance variable
  // Edge Class Type 的 Array -> Array , each element is Edge Class Type

  // public Square() {
  // edges = new Edge[4];
  // edges[0] = new Edge(3.0d, "RED");
  // edges[1] = new Edge(3.0d, "YELLOW");
  // edges[2] = new Edge(3.0d, "BLACK");
  // edges[3] = new Edge(3.0d, "BLUE");
  // }

  public Square(double length) {
    if (length <= 0.0)
      length = 1.0d;
    edges = new Edge[4];
    edges[0] = new Edge(length, "RED");
    edges[1] = new Edge(length, "RED");
    edges[2] = new Edge(length, "RED");
    edges[3] = new Edge(length, "RED");
  }

  // public void setLength(double length) {
  // this.edges[0].length = length;
  // }

  public Edge[] getEdges() {
    return this.edges;
  }


  public static void main(String[] args) {
    // Square s = new Square(2);
    // Square s2 = new Square(10);
    // System.out.println(s.length);
    // s.length=5.0d; // cannot change final
    // System.out.println(s.length.toString()); // 溫習 Wrapper Class 可以 .method
    Square s3 = new Square(5);
    // System.out.println(s3.edges[0].length);
    // s3.setLength(100);
    // System.out.println(s3.edges[0].length);

    s3.getEdges()[0].setColor("YELLOW");
    System.out.println(s3.getEdges()[0].getColor());

  }
}
