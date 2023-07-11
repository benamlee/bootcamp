public class DataType {
  public static void main(String[]args) {
    // number -> int
    // Declaration
    int num; // int is a way to declare a variable
    // from now on, you can only put integer to variable num.
    // Assignment
    num = 3; // from right to left -> Action: assignment 將3扔入num
    // declaration + assignment
    int n = 10;
    System.out.println("3");
    System.out.println(3);
    System.out.println(num);
    System.out.println(n);


    //text ->String
    String str = "Hello   !";
    System.out.println(str);

    // error
    // String str2 = 1;
    // int num2 = "asdhasl";

    // re-assignment
    num = 10;

    // floating point
    // int num3 = 1.2; //error, int can only store Interger
    double f = 1.03;
    double f2 = 1; // its ok


    byte a;
    a = 127;
    System.out.println(a);

    short b;
    b = 32700;
    System.out.println(b);

    long c;
    c = 470000000L;
    System.out.println(c);

    // floating point -> double/ float
    float f3 = 2.013336f;
    System.out.println(f3);

    // char, value should be assigned by single quote''
    char gender = 'M';
    System.out.println(gender);
    char space = ' ';
    // char empty = ''; //error

    // boolean
    boolean isMale = true;
    boolean isSalaryGreaterThan1000 = true;
    boolean isValid = false;

    //initialization, means the 1st time of assignment
    int a10 = 0;// before initialization, default =0 
    a10 = 100;
    System.out.println(a10);// 

    // String + operation
    String st1 = "Hello";
    String st2 = " world!";
    String result = st1 + st2;
    System.out.println(result);

    String result2 = "hello" + " w orlddd";
    System.out.println(result2);

    System.out.println(result + " " + "result2");

    int a44 = 1 + 3;// 4
    int b22 = 1 - 3;// -2
    int c10 = 2 - 40;// -38
    int i = 2 * 101;// 202
    int pp = 10 / 3;// 3
    int oo = 10%3;// 1, 1 is reminder
    System.out.println(a44);
    System.out.println(b22);
    System.out.println(c10);
    System.out.println(i);
    System.out.println(pp);
    System.out.println(oo);

    String str3 = "abc" + 13; // default behaviour: convert 13 to String
    //abc13
    String str4 = "abc" + 'A'; // 'A' -> String "A", abcA
    String str5 = "abcd" + true;
    System.out.println(str5); // abcdtrue
    //String str6 = 13 + 13; // error
    String str7 = "" + 13 + 13; // 13 -> String "13", result: 1313
    //String str8 = 'A'; // error

  }
}
