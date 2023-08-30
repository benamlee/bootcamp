import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        // Stream support List, Map, Arrays .stream()
        List<String> strings = new LinkedList<>();
        strings.add("abc");
        strings.add("def");
        strings.stream() //
                .filter(e -> e.startsWith("a")) //
                .forEach(e -> System.out.println(e)); // abc

        strings.stream() //
                .map(e -> e.length()) // convert string to int
                .filter(l -> l < 5) //
                .forEach(e -> System.out.println(e)); // 3 3


    }

    public static List<Integer> getAges(List<String> list) {
        return list.stream() //
                .map(e -> e.length()) //
                .filter(e -> e < 5) //
                .collect(Collectors.toList());
    }
}
