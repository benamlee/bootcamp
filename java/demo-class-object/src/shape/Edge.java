package shape;

public class Edge {

  private int id;
  private double length;
  private String color;

  private static int counter; // static 屬於class , 不屬於 object

  public Edge(int id, double length, String color) {
    this.id = id; // 學寫法
    this.length = length;
    this.color = color;
  }



  public void setLength(double length) {
    this.length = length;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  public double getLength() {
    return this.length;
  }

  public static void main(String[] args) {
    Edge a=new Edge(1, 2,"a");
     Edge b=new Edge(1, 2,"a");
     String e=new String("a");
     System.out.println("a".equals(e));

     for(byte i=0;i<128;i--){
      System.out.println(1);
     }

    //  System.out.println(a.equals(b));
  }

}
