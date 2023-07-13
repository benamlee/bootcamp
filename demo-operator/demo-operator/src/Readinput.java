import java.util.Scanner;

public class Readinput {
  public static void main(String[] args) {
    String str = "Hello";
    str.charAt(0); // H

    // Scanner -> read user input
    System.out.println("Please input an integer:");
    Scanner s = new Scanner(System.in); // new 當佢係動詞
    int input = s.nextInt(); // read user input, expecting it is an integer
    System.out.println("input=" + input);

    for (int i = 0; i < input; i++) {// input係幾多就loop幾多次,0,1,2,...,n-1 =n次
      System.out.println("Hello");
    }

  }
}
