import java.util.Arrays;

public class Try {

  public static void main(String[] args) {
    String str = "1233";
    int i = 968675;
    System.out.println(i);


    int digit = 1;
    while (i > 10) {
      i /= 10;
      digit *= 10;
    }
    System.out.println(digit);

    int n = 9696;
    System.out.println(n % 10000 - n % 1000);
    System.out.println(n % 1000 - n % 100);
    System.out.println(n % 100 - n % 10);
    System.out.println(n % 10 - n % 1);

    boolean[] iii = new boolean[2];
    System.out.println(iii[0]);

    String afda = "ad ii";
    // System.out.println(afda.charAt(3)); // error
    String[] aaad = afda.split("");
    System.out.println(Arrays.toString(aaad));


    int a = 1;
    int b = 2;
    int c = 0;
    c = a > b ? a : b; // -> if(a>b){a}else{b}
    // ? 之後一定要retuen野，不能是 void
    System.out.println(c);
    // a>b?System.out.println(1):System.out.println(2);;
    System.out.println(a > b ? 1 : 2);
    System.out.println();

    String s = "abc";
    System.out.println(s.replace('a', 'b'));
    System.out.println(s); // replace dont change itself

    StringBuilder ssss = new StringBuilder("abc");
    char asd = ssss.append("null").charAt(1);
    System.out.println(ssss);


  }
}
