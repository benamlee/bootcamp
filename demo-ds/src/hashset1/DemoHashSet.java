package hashset1;

import java.util.HashSet;

public class DemoHashSet {
  public static void main(String[] args) {
    // Example 1: HashSet
    HashSet<String> strings = new HashSet<>(); // 特別用來處理會 duplicate 的情況
    System.out.println(strings.add("abc")); // true
    System.out.println(strings.add("def")); // true
    System.out.println(strings.size()); // 2

    // HashSet
    boolean result = strings.add("abc");
    System.out.println(strings.size()); // 2 // default remove duplicate
    System.out.println(result); // false

    if (strings.add("def")) { // false
      System.out.println("add def");
    } else {
      System.out.println("def exists and is not added again");
    }

    // Example 2:
    HashSet<Coordinate> coordinates = new HashSet<>();
    Coordinate c1 = new Coordinate(1, 1);
    Coordinate c2 = new Coordinate(1, 1);
    System.out.println(coordinates.add(c1)); // true
    System.out.println(coordinates.add(c2)); // false
    System.out.println(coordinates.size()); // 1
    // HashSet 入面的 .add 會call -> .equals() and .hashCode()
    // HashSet add() -> Coordinate c2.equals(any of coordinates in hashset)
    // ---------------> c2.equals(c1) -> true
    // ---------------> HashSet not allow duplicates
    // ---------------> return false
    Coordinate c3 = new Coordinate(2, 1);
    System.out.println(coordinates.add(c3)); // true, Coordinate
    System.out.println(coordinates.size()); // 2

    // Example 3: Without Override equal() method
    HashSet<Book> books = new HashSet<>();
    System.out.println(books.add(new Book("dummy","Eric"))); // true
    System.out.println(books.add(new Book("dummy","Eric"))); // true
    System.out.println(books.add(new Book("dummy","Steven"))); // true
    System.out.println(books); // books 宜家裝住3個冇代名的地址


  }
}
