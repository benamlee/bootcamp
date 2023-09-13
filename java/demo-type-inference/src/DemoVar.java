import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoVar {

  // var age; // Not Allowed

  public static void main(String[] args) {
    // var become its default type
    var s = "Hello";
    // s = 3; // error, compile-check -> String
    var i = 2;
    var c = 'g';
    var ja = 6L;
    System.out.println(i + ja + c);

    var n = null; // not allowed, compile cannot refer the actual type
    // var[] x = new int[3]; // Not Allowed
    // int[] x = new var[3];

    // Loop
    List<String> strings = Arrays.asList("abc", "def");
    for (var str : strings) { // var
      System.out.println(str);
    }

    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);
    for (var entry : map.entrySet()) { // var = Map.Entry<String, Integer>
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

    var result = getString();
    result.add(Arrays.asList("def", "rty"));
    result.add(Arrays.asList("abijkc"));

  }

  public static List<List<String>> getString() {
    return Arrays.asList(Arrays.asList("abc"));
  }

  // Not Allowed
  // public static var add(int x, int y) {
  // return x + y;
  // }

  // Not Allowed
  // public static String add(var x, var y) {
  // return x + y;
  // }
}
