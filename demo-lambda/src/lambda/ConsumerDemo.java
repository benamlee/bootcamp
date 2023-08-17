package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo { // void -> no return
  public static void main(String[] args) {
    Consumer<String> consumer = str -> System.out.println(str);
    consumer.accept("I love java");

    BiConsumer<String, String> biConsumer =
        (s1, s2) -> System.out.println(s1 + s2);
    biConsumer.accept("abc", "def"); // abcdef

    // Example
    List<String> strings = new ArrayList<>();
    strings.add("dog");
    strings.add("cat");
    strings.add("cow");
    strings.add("dog");
    strings.forEach(s -> {
      int i = 0;
      if (i < 1)
        s += " is an animal";
      System.out.println(s);
    });

    Map<String, Integer> map = new HashMap<>();
    map.put("orange", 3);
    map.put("lemon", 2);
    map.put("watermelon", 10);
    map.forEach((key, value) -> {
      if ("lemon".equals(key))
        System.out.println(value); // 2
    });



  }
}
