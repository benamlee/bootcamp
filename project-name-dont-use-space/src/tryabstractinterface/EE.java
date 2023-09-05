package tryabstractinterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class EE {
  AA a;
  BB b;

  public static void main(String[] args) {
    EE e = new EE();
    // e.a=new AA(100);
    // System.out.println(e.a.a);; // e.a not yet define is null and its all method attributes cannot use
    e.b = new AA(100); // here e.b can declare AA || BB class
    System.out.println(e.b.b);

    List<Integer> li = Arrays.asList(1, 2, 3);
    li.forEach(et -> System.out.println(et));

    Map<String, Integer> map = new HashMap<>();
    map.put("aa", 2);
    BiFunction<Integer, Integer, Integer> bf = Integer::sum;
    bf = (x, y) -> x * y; // assign a new function
    Integer ii = map.merge("aa", 3, bf);
    System.out.println(ii);
    BinaryOperator<String> strConcat = String::concat; // one input class
    System.out.println("aa".concat("bb"));

    Stream<Double> infinitenum = Stream.generate(Math::random);

    // infinitenum.limit(10).forEach(System.out::println); // still infinite
    // Optional<Integer> nu = Optional.of(null); // .of cannot input null
    Optional<Integer> nu = Optional.ofNullable(null); // .of cannot input null
    System.out.println(nu.isPresent()); // false
    nu.ifPresent(s -> System.out.println(s));
    nu.filter(s -> s > 4); // ?
    List<String> strings = Arrays.asList("HI", "Bh", "GOOD", "BB");
    System.out.println(
        strings.stream().filter(s -> s.startsWith("B")).findAny().isPresent()
            ? strings.stream().filter(s -> s.startsWith("B")).findAny()
            : "nothing found");

    int[] arr = new int[] {6, 4, 3, 6, 8, 3};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = 0;
      }
      // for (int abc : arr) {
      // abc = 0;
      // } // don't work???????
    });
    Thread thread2 = new Thread(() -> {
      for (int n : arr) {
        System.out.println(n);
      }
    });
    // thread1.setPriority(Thread.MIN_PRIORITY);
    // thread2.setPriority(Thread.MAX_PRIORITY);
    thread1.start();
    thread2.start();
    // thread1.start();
    try {
      // thread2.join();
      thread1.join();
      thread2.join();
    } catch (InterruptedException rr) {
      // rr.printStackTrace();
    }
    System.out.println(Arrays.toString(arr));

  }

  public static <T extends Number> int method10(T t) throws Exception {
    if (t instanceof Number)
      throw new Exception();
    return 10;
  }

  public static int method11(List<? extends Number> t) throws Exception {
    try {
      throw new Exception(); // polymorphism

    } catch (Exception e) {

    }
    return 5;
  }

  public static int method11(int n) {
    int a = 1;
    if (a == 1)
      throw new IllegalArgumentException(); // RuntimeException 就唔洗簽名接

    return 5;
  }
}
