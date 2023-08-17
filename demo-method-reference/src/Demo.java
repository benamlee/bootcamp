import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Demo {
  public static void main(String[] args) throws Exception {
    Consumer<String> sysout = s -> System.out.println(s);
    Consumer<String> sysout2 = System.out::println; // static method // if input() is just exactly parameter,

    Arrays.asList("abc", "sd").forEach(sysout2);

    String name = "john";
    Supplier<Integer> strLength = () -> name.length(); // can use class .mehtod, can also obj .method
    Supplier<Integer> strLength2 = name::length;

    List<String> words = Arrays.asList("banan", "apple", "orange");
    Comparator<String> compare = (s1, s2) -> s2.compareTo(s1); // 逆
    Comparator<String> compare2 = String::compareTo; // 順
    Collections.sort(words, compare); // review
    System.out.println(words);

    Function<String, Integer> stringToInteger = str -> Integer.valueOf(str);
    Function<String, Integer> stringToInteger2 = Integer::valueOf;
    // Constructor
    Function<String, Integer> stringToInteger3 = Integer::new;
    System.out.println(Integer.valueOf("123"));
    // System.out.println(Integer.valueOf("a")); // NumberFormatException



  }
}
