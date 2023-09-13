package unchecked;

public class DemoNumberFormatException {
  public static void main(String[] args) {
    try {
      Integer.valueOf("abc");
    } catch (NumberFormatException e) {
      System.out.println("Number Format Issue");
    }
  }
}
