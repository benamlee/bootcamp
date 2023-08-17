package unchecked;
public class DemoStringIndex {
  public static void main(String[] args) {
    try {
      System.out.println("abc".charAt(3));
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("String index issue");
    }
  }
}
