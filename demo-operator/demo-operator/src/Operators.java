public class Operators {
  public static void main(String[] args) {
    int a = 1;
    a = a + 1; // 2
    a = a - 2; // 0
    int b = 10 / 5; // 2
    b = b * 3 + 5; // 11
    System.out.println("a append b=" + a + b); // String後面+ 會強行變哂做String

    int x = 1;
    x = x + 1;
    x++; // means x = x + 1;
    System.out.println("x=" + x); // x=3
    ++x; // means x = x + 1;
    System.out.println("x=" + x); // x=4
    x += 1; // means x = x + 1;
    System.out.println("x=" + x); // x=5

    int y = 10;
    y = y - 1;
    y--; // means y = y - 1;
    System.out.println("y=" + y); // y=8
    --y; // means y = y - 1;
    System.out.println("y=" + y); // y=7
    y -= 1; // means y = y - 1;
    System.out.println("y=" + y); // y=6

    // Other +,-,*,/
    int z = 4;
    z = z + 2;
    z += 2;
    System.out.println("z=" + z);
    int i = 6;
    i = i - 3;
    i -= 3;
    System.out.println("i=" + i);
    int w = 9;
    w = w * 3;
    w *= 3;
    System.out.println("w=" + w);
    int u = 81;
    u = u / 9;
    u /= 3;
    System.out.println("u=" + u);

    int integer = 12 % 5; // 2
    int integer2 = 12;
    integer2 %= 5; // 2
    System.out.println(integer2);

    // ++, --
    int m = 3;
    m++; // 4
    int perIncrement = ++m; // ++ first? or assignment first?
    // m+1 first, 入5, assignment later
    System.out.println("preIncrement=" + perIncrement);
    System.out.println("m=" + m); //
    int postIncrement = m++;
    // assignment 5 first, +1 later, now m=6
    System.out.println("postIncrement=" + postIncrement);
    System.out.println("m=" + m); // 6

    // ++, --
    int n = 10;
    n--; // 9
    int perDncrement2 = --n;
    // -1+9 first, assignment 8
    System.out.println("preIncrement=" + perDncrement2);
    int postDncrement2 = n--;
    // assignment 8 into postIncrement2, n will -1 later, now n=7,--同assignment無關, 只影響n
    System.out.println("postIncrement=" + postDncrement2);
    System.out.println("n=" + n); // 6
    // --n, n--, 每次都會影響n的值

    int try1 = 1;
    int try2 = try1 += 3; // use += also like ++try1, operate, then assign the operated value, also it can be any integer besides 1
    System.out.println("try2=" + try2);
    System.out.println("try1=" + try1);

    // String +=
    String str = "hello";
    str += " world"; // hello world
    System.out.println(str);



  }
}
