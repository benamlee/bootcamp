import java.util.Scanner;

public class DoWhileLoop {
  public static void main(String[] args) {
    // do-while, do first, then check condition to start looping
    int count = 0;
    do {
      System.out.println("hello, count=" + count);
      count++;
      System.out.println("hello, count=" + count);
    } while (count < 3);
    // 永遠做第一次先，再check條件
    // =do
    // while(){
    // do}
    System.out.println();
    count = 0;
    while (count < 3) {
      System.out.println("hello, count=" + count);
      count++;
      System.out.println("hello, count=" + count);
    }

    int input = 0;
    Scanner scanner;
    do {
      System.out.println("Please input an integer:");
      scanner = new Scanner(System.in);
      input = scanner.nextInt();
    } while (input % 2 == 0);
    System.out.println("input is odd=" + input); // 一直中條件仲loop緊，唔會去到出面
    // 所以出到來唔中條例，唔洗if(input%2==1){}
    scanner.close();


  }
}
