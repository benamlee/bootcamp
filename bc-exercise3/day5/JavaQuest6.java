/**
 * Expected output:
 * 1 1 2 3 5 8 13 21 ...
 * 
 */
// Count the target of character in a String.
public class JavaQuest6 {
  public static void main(String[] args) {
    // for loop to print first 15 numbers in Fibonacci Sequence
    int a = 1;
    int b = 0;
    int c = 0;
    String str = "";
    for(int i = 0; i < 15; i++){
      str += a + " ";
      c = a + b;
      b = a;
      a = c;
    }
    System.out.println(str);
  }
}
