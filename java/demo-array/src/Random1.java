import java.util.Random;

public class Random1 {
  public static void main(String[] args) {
    int num = new Random().nextInt(3); // 0, 1, 2
    System.out.println(num);
    num++;
    System.out.println(num);
    System.out.println(randomAbcde());
  }

  // A, B, C, D, E
  public static char randomAbcde() {
    // int a = new Random().nextInt(5);
    // char abcde = 'A'+(char) a; // 不能只(char)a
    // return abcde;
    
    // char[] chars = new char[] {'A', 'B', 'C', 'D', 'E'};
    // return chars[new Random().nextInt(5)];
    return (char) (new Random().nextInt(5) + 'A'); // 要(char)(...+'A')
  }



}
