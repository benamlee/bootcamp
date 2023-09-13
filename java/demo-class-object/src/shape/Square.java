package shape;

public class Square {

  private static int edgeCounter;
  private Edge[] edges; // instance variable // edges is array name // element is Edge class
  // private final Edge[] edges; // final Edge[] 唔比改array地址

  // Edge Class Type 的 Array -> Array , each element is Edge Class Type

  // public Square() {
  // edges = new Edge[4];
  // edges[0] = new Edge(3.0d, "RED");
  // edges[1] = new Edge(3.0d, "YELLOW");
  // edges[2] = new Edge(3.0d, "BLACK");
  // edges[3] = new Edge(3.0d, "BLUE");
  // }

  private Square(double length) {
    if (length <= 0.0)
      length = 1.0d;
    int id = 0;
    this.edges = new Edge[4]; // assign address
    this.edges[0] = new Edge(++id, length, "RED");
    this.edges[1] = new Edge(++id, length, "RED");
    this.edges[2] = new Edge(++id, length, "RED");
    this.edges[3] = new Edge(++id, length, "RED");
    // Square.resetId();; // class.staticmethod
  }

public static Square of(double length){
  return new Square(length);
}

public static Square of(int length){
  return new Square(length);
}

public static Square of(float length){
  return new Square(length);
}

public static Square of(String length){
  return new Square(Double.valueOf(length));
}

  // public void setLength(double length) {
  // this.edges[0].length = length;
  // }

  // public static void resetId() { // static 屬於class , 不屬於 object
  // edgeCounter = 0;
  // }

  public Edge getEdge(int edgeId) {
    return this.edges[edgeId - 1];
  }


  private Edge[] getEdges() { // private edges array address
    return this.edges;
  }

  // public void setEdges(Edge[] edges){
  // this.edges=edges;
  // }
  // if -> private final Edge[] edges; -> the address cannot be reassigned

  public void modify(double length) {
    this.getEdges()[0].setLength(length);
    this.getEdges()[1].setLength(length);
    this.getEdges()[2].setLength(length);
    this.getEdges()[3].setLength(length);
  }

  public void modify(String color) {
    this.getEdges()[0].setColor(color);
    this.getEdges()[1].setColor(color);
    this.getEdges()[2].setColor(color);
    this.getEdges()[3].setColor(color);
  }

  public void modify(int edgeId, String color) {
    this.getEdge(edgeId).setColor(color);
  }



}
