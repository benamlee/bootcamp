package shape;

public class DemoShape {

  public static void main(String[] args) {
    // Square s = new Square(2);
    // Square s2 = new Square(10);

    // System.out.println(s.length);
    // s.length=5.0d; // cannot change final
    // System.out.println(s.length.toString()); // 溫習 Wrapper Class 可以 .method
    // Square s3 = new Square(5);

    // System.out.println(s3.edges[0].length);
    // s3.setLength(100);
    // System.out.println(s3.edges[0].length);

    // s3.getEdges()[0].setColor("YELLOW");
    // System.out.println(s3.getEdges()[0].getColor()); // getEdges() set private

    // s3.getEdges() is the address of array
    // s3.getEdges()[i] is the address of edge

    Square s2 = Square.of(2.0f);
    Square s3 = Square.of(5.0d);
    Square s4 = Square.of("6.8");

    System.out.println(s3.getEdge(1).getLength());

    s3.modify(2, "a");
    System.out.println(s3.getEdge(2).getColor());


  }
}
