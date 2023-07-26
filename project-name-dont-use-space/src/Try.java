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




  }
}
