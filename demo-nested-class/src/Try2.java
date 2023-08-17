public class Try2 {
  int abab;

  private Try2() {}

  public static Try2 buildTry2() { // meaning is the same
    return new Try2();
  }

  public Try2 setTry22(int a) {
    this.abab = a;
    return this;
  }

  public static void main(String[] args) {
    Try2 try100 = Try2.buildTry2();
    Try2 try101 = Try2.buildTry2().setTry22(50).setTry22(90).setTry22(40);

   System.out.println( try101.setTry22(500));


    Try2 abasb= new Try2().setTry22(50).setTry22(90).setTry22(40);// private 
  }

}
