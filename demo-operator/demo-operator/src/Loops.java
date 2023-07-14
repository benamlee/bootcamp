public class Loops {
  public static void main(String[] args) {
    // For Loop, ()入面有3舊野
    int a = 0;
    ++a;
    a++; // 當獨立expression, 2個一樣

    int try2 = 40; // can use outside declaration
    for (float i = 3.0f; i >= 0.0000000005; i /= try2) { // initialize; condition; change on i
      // change expression can only use +=, -=, /=, etc, to calculate other numbers,
      // cannot i=i+2, i+2,
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

    // continue
    for (int i = 0; i < 6; i++) {
      System.out.println("Hello!");
      if (i > 3) {
        continue; // go to the next iteration, i.e. skip below action and go to i+1 loop
      }
      System.out.println("Bye!");
    }
    // i = 0, hello, bye
    // i = 2, hello, bye
    // i = 3, hello, bye
    // i = 4, hello
    // i = 5, hello
    // i = 6, exit

    for (int i = 0; i < 4; i++) {
      System.out.println("HI");
      if (i == 2) {
        continue;
      }
      System.out.println("B");
    }

    for (int i = 0; i < 8; i++) {
      if (i % 2 == 0) {
        if (i % 3 == 0) {
          System.out.println("i=" + i);
        }
      }
    }
    // if(){if(){action}}, -> if(&&){action} AND
    // if(){action}else if(){action} -> if(||){action} OR
    // when the action is the same, the condition shoud merge

    // Nested Loop
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(i + "," + j);
      }
    }
    // i=0, j=0
    // i=0, j=1
    // i=0, j=2
    // i=0, j=3, exit
    // i=1, j=0
    // i=1, j=1
    // i=1, j=2
    // i=1, j=3, exit
    // i=2, j=0
    // i=2, j=1
    // i=2, j=2
    // i=2, j=3, exit
    // i=3, j=0
    // i=3, j=1
    // i=3, j=2
    // i=3, j=3, exit
    // i=4, exit

    // System.out.println(); -> nextline after print out
    // System.out.print(); -> continue after print out, no nextline
    int numOfStar = 5;
    for (int i = 0; i < numOfStar; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println(); // ()inside can be nothing, no need ""
    }

    String try1 = "";
    for (int i = 0; i < 5; i++) {
      // for (int j = 0; j <= i; j++) {
      try1 += "1";
      // }
      System.out.println(try1);
    }



    for (int i = 0; i < 5; i++) {
      String try4 = "";
      for (int j = 0; j <= i; j++) {
        try4 += "2";
      }
      System.out.println(try4);
    } // when try4 is declared in a block, try4 cannot be used outside that block

    for (int i = 0; i < 5; i++) {
      String try4 = "";
      for (int j = i; j < 5; j++) {
        try4 += "3";
      }
      System.out.println(try4);
    } // when try4 is declared in a block, try4 cannot be used outside that block, can redeclare inside another block



  }
}
