public class WhileLoop {
  public static void main(String[] args) {
    // while
    int count = 0;
    while (count < 5) { // continue condition: true/ false
      count++;
    } // count = 5
    System.out.println(count);

    boolean isHoliday = false;
    int counter = 0;
    while (!isHoliday) { // Is Not Holiday
      System.out.println("counter=" + counter);
      counter++;
      if (counter >= 6) {
        isHoliday = true; // counter=6 就不會進入while
      }
    }
    // while 用 boolean 比較有 business meaning, 較常用, while(一堆條件)
    // counter 就冇 business meaning
    // good name of boolean can make it readible is a group of conditions

    int c = 0;
    while (c >= 0 && c < 5) {
      System.out.println(c);
      c++;
    }

    int a = 0;
    int b = 10;
    while (a < 5 || b > 0) {
      System.out.println("hello");
      a++;
      b--;
    }

    // break, continue;
    int k = 0;
    while (k < 6) {
      System.out.println("break");
      k++;
      if (k > 3) {
        break;
      }
    }

    // continue
    int j = 0;
    while (j < 6) {
      j++;
      if (j > 3) {
        continue;
      }
      System.out.println("continue");
    }



  }
}
