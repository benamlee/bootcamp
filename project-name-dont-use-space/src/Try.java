import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

    int[] aa = new int[] {1, 2, 3};
    Queue<Integer> na = new LinkedList(Arrays.asList(aa));
    System.out.println(na);

    List<Integer> aaa = Arrays.asList(new Integer[] {1, 2, 3}); // from array to list
    List<Integer> aaa2 = Arrays.asList(1, 2, 3, 4);
    List<String> sss = Arrays.asList("a", "f");

    System.out.println(sss); // print list

    Integer ab = 5;
    byte cccc = (byte) (ab + 4);
    System.out.println(cccc);

    LinkedList<Integer> asds = new LinkedList<>();
    asds.addLast(1);
    asds.addLast(2);
    asds.addLast(3);
    System.out.println(asds);

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

  }
}
