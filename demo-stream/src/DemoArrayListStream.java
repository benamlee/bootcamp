import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoArrayListStream {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("abc");
    strings.add("ghi");
    strings.add("def");

    // for-each
    for (String s : strings) {
      System.out.println(s);
    }
    // Stream
    Stream<String> streamStrings = strings.stream();
    // Stream.filtering
    streamStrings = streamStrings.filter(s -> s.startsWith("a"));
    // Stream.forEach
    streamStrings.forEach(s -> System.out.println(s)); // abc

    strings.stream() //
        .filter(s -> s.endsWith("i")) //
        .forEach(s -> System.out.println(s)); // ghi

    List<String> strings2 = strings.stream() //
        .filter(s -> s.length() == 3) //
        .collect(Collectors.toList());

    System.out.println(strings2.size()); // 3

    List<Integer> lengths = strings2.stream() //
        .filter(e -> e.startsWith("a") || e.startsWith("d"))
        .map(e -> e.length()) // Stream<Integer>
        .collect(Collectors.toList()); // List<Integer>

    lengths.forEach(e -> System.out.println(e)); // 3 3

    // Stream.sorted()
    strings2.stream() //
        // .sorted() // natural order
        .sorted((s1, s2) -> s2.compareTo(s1)) // descending order
        // .collect(Collectors.toList())
        .forEach(s -> System.out.println(s)); // ghi def abc // Both List/Stream can use forEach

    // Stream.anyMatch()
    if (strings2.stream().anyMatch(e -> e.startsWith("a"))) { // true
      System.out.println("One of the elements starts with a");
    }

    // interminate operations of Stream:
    // filter(), map(), sorted(), anyMatch()

    // terminated operations of Stream:
    // collect(), forEach()

    // Stream can only terminate once,
    // but it may have multiple interminate operations

    List<Person> persons =
        Arrays.asList(new Person("John", 30), new Person("Mary", 25));
    // stream -> get all the ages from persons
    persons.stream().forEach(e -> System.out.println(e.name + ", " + e.age));
    List<String> names = persons.stream().map(e -> {
      String word = "words ...";
      return e.getName() + word;
    }).collect(Collectors.toList());
    System.out.println(names);

    System.out
        .println(names.stream().filter(e -> e.startsWith("John")).count());


    // Stream static method
    Predicate<String> lengthFunc = e -> e.length() == 3;

    long l = Stream.of("abc", "defa", "ghiaa", "abc") //
        .filter(lengthFunc) //
        .distinct() // 消滅重複
        .count(); // 1

    Stream.of(1, 2, 3, 4) // example 1
        // .filter(e -> e > 0) //
        .map(e -> {
          System.out.println(e); // why no action? // without filter
          return e; // action with filter
        }).count(); // terminate operation

    Stream.of(1, 2, 3, 4) // example 2
        .filter(e -> e == 2).map(e -> {
          System.out.println(e); // why no action?
          return e;
          // }).forEach(e->System.out.println(2)); // terminate operation
        }).count();

    List<Integer> abc = Stream.of(1, 2, 3, 4) // example 3
        .filter(e -> e > 1).map(e -> {
          System.out.println(e); // why no action?
          return 100;
          // }).forEach(e->System.out.println(2)); // terminate operation
        }).collect(Collectors.toList());

    System.out.println(abc);

    int setSize = Stream.of(1, 2, 3, 3) //
        .collect(Collectors.toSet()).size();
    System.out.println(setSize); // 3

    Stream.of(1, 2, 3, 3, 5) //
        .filter(e -> e < 6 && e > 2) //
        .forEach(e -> System.out.println(e)); // 3 3 5

    List<String> animals = Arrays.asList("lion", "tiger", "bear");
    Map<String, Integer> animalMap = animals.stream() //
        .collect(Collectors.toMap(str -> str, str -> str.length()));

    // Loop Map
    for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

    // Stream.iterate()
    Stream.iterate(1, n -> n + 2) //
        .limit(10) //
        .forEach(e -> System.out.println(e));

    // Group by


  }

  public static boolean findElderly(List<Person> persons) { // Stream 很多 method 轉type ，可以一下直接return
    return persons.stream() // Stream<>
        .filter(e -> e.isElderly()) // Stream<>
        .findFirst() // Optional<Person>
        .isPresent(); // boolean
  }


}
