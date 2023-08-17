package lambda;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
  public static void main(String[] args) {
    Function<String, Integer> lengthFunc = str -> str.length(); // this delare obj carrying a function
    Function<String, Character> firstCharFunc = str -> str.charAt(0); // 如果一個variable 可以唔寫()括號

    System.out.println(lengthFunc.apply("abc")); // in Function class, only .apply()
    System.out.println(firstCharFunc.apply("ben")); // obj(function) .apply() unique method

    LengthFunction lengthFunction = new LengthFunction();
    System.out.println(lengthFunction.apply("def")); // this make a new class to override

    // Function Example in Map
    Map<String, String> map = new HashMap<>();
    map.put("abc", "Mary");
    // Function<String, String> formula = s -> "default";
    // String result = map.computeIfAbsent("def", formula);
    String result = map.computeIfAbsent("def", s -> "default"); // 簡化寫法；揾不到會put埋入去
    System.out.println(result);
    System.out.println(map.size()); // 2

    // BiFunction
    BiFunction<Integer, Integer, BigDecimal> addition =
        (x, y) -> BigDecimal.valueOf(x + y);
    System.out.println(addition.apply(-4, 3).abs()); // .abs() is BigDecimal method

    // // // not good example
    // map.compute("bcd", (s1, s2) -> "value");
    // System.out.println(map.get("bcd"));
    // System.out.println(map.size()); // 3
    // map.compute("bcd", (s1, s2) -> "another value");
    // System.out.println(map.get("bcd"));

    Map<String, Integer> stock = new HashMap<>();
    stock.put("clothes", 100);

    stock.compute("clothes",
        (item, oldPrice) -> (int) (oldPrice - oldPrice * 0.1));
    System.out.println(stock.get("clothes")); // 90

    stock.compute("clothes", (item, oldPrice) -> null);
    System.out.println(stock.size());

    stock.compute("shoes", (item, oldPrice) -> 120);
    System.out.println(stock.get("shoes"));


  }
}
