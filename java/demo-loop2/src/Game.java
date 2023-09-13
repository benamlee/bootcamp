import java.util.Random;
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    // 1 - 100
    // bomb = 45 (random number)
    // Please Input a number (1-100):
    // user input: 30 -> 31-100
    // Next round: Please input a number (31-100)
    // 60
    // Next round: Please input a number (31-59)
    // 45
    // exit loop. Bomb!


    int bomb = new Random().nextInt(100) + 1; // 1 - 100


    int input = 0;
    int min = 1;
    int max = 100;
    Scanner scanner;
    do {
      System.out.println("Please input an number (" + min + "-" + max + "):");
      scanner = new Scanner(System.in);
      input = scanner.nextInt();
      if (input < min || input > max) {
        continue;
      }
      if (input < bomb) {
        min = input + 1;
      } else if (input > bomb) {
        // 如果input=bomb，唔寫else if會有人challenge，所以為了readibility要寫得平衡
        // 雖然呢個位就咁else都OK
        max = input - 1;
      }
    } while (input != bomb); // true 繼續行，false先停
    System.out.println("exit loop. Bomb" + input);
    scanner.close();


  }
}
