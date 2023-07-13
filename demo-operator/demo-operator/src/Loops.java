public class Loops {
  public static void main(String[] args) {
    // For Loop, ()入面有3舊野
    int a = 0;
    ++a;
    a++; // 當獨立expression, 2個一樣

    int try2 = 40; // can use outside declaration
    for (float i = 3.0f; i >= 0.0000000005; i /= try2) { // initialize; condition; change on i
      // change expression can only use +=, -=, /=, etc, to calculate other numbers, cannot i=i+2, i+2,
      System.out.println("i=" + i + ", Hello");
      // i = 0, 1st Hello
      // i = 1, 2nd Hello
      // i = 2, 3rd Hello
      // i = 3, 4th Hello
    } // when the loop end, variable name "i" is finish, can be used outside

    for (int i = 0; i < 4; ++i) {
      System.out.println("i=" + i + ", Hello");
      // Logic flow:
      // i = 0, -> 0 < 4, print 1st Hello
      // ++i -> i = 1 -> 1 < 4, print 2nd Hello
      // ++i -> i = 2 -> 2 < 4, print 3rd Hello
      // ++i -> i = 3 -> 3 < 4, print 4th Hello
      // ++i -> i = 4 -> 4 is Not smaller than 4, exit loop
    }

    // for (byte i = 4; i != 0; ++i) { // byte here is a loop 127 -> -128
    // System.out.println("i=" + i + ", Hello");
    // } // i can reuse in another for loop

    // int i=0; // initialize cannot be done outside ()
    // for(i;i<2;++i){
    // System.out.println("h");
    // }

    for (int j = 0; j < 3; ++j) { // 習慣用 0 開始, 因為之後好多pre set都係咁
      j = 100; // j value can be used and changed inside
      System.out.println("j=" + j);
    }

    // int i = 0;
    // for(int i=0;i<3;++i){ // 出面用了，入面都唔用得

    // }

    for (int j = 3; j > 0; --j) {
      System.out.println("j=" + j);
    }

    int max = 10;
    int count = 0;
    for (int i = 0; i < max; ++i) {
      count += i;
    }
    System.out.println(count);

    int sum = 0;
    int sumOddNumWithout5 = 0;
    for (int i = 0; i < 10; i++) {
      if (i % 2 != 0) {
        sum += i;
      }
      if (i % 2 == 1 && i != 5) {
        sumOddNumWithout5 += i;
      }
    }
    System.out.println(sum);
    System.out.println(sumOddNumWithout5);
    // 一個loop入面可以用盡佢做多D野

    for (int i = 0; i < 5; ++i) {
      System.out.println("hi" + i);
      if (i > 2) {
        break; // when i=3, print 完先check到 3>2, 才break
      }
      if (i == 1) {
        break;
      }
    } // 用 break 即加 conditions to end loop,

    // sum = 0;
    // for (int i = 1; i < 10; i += 2) {
    // sum += i;
    // }
    // System.out.println(sum);


    

    // loop用途: 1. 重複做動作, 2. 累積
  }
}
