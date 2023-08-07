package arraylist1;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoArrayList {
  public static void main(String[] args) {
    // fixed-length
    // for both primitive and class
    int[] arr = new int[] {1, 2, 3};
    Integer[] integers = new Integer[] {1, 3, 2};
    // resize, create new object
    integers = new Integer[] {1, 3, 2, 4};
    // integers[2] = "abc"; // compile-time error

    // Declaration
    ArrayList<Integer> numbers; // ArrayList<type> name = new ArrayList<>();
    // Initialization
    numbers = new ArrayList<>(); // ArrayList has its ArrayList address, different from array address
    ArrayList<Integer> numbers2 = new ArrayList<>(); // empty array
    numbers2.add(1); // length 1 array // .add() delete old array and create new array
    numbers2.add(2); // length 2 array
    numbers2.add(3); // length 3 array
    numbers2.add(4); // length 4 array
    numbers2.add(null); // length 5 array
    // numbers2.add((Integer) Long.valueOf(3)); // Cannot cast Long to Integer
    // variable-length
    System.out.println(numbers2.size()); // 5 , ArrayList 用 .size()

    // ArrayList<> always create a new array address for array

    // Conversion, ArrayList -> Array
    Integer[] arr2 = new Integer[numbers.size()];
    // Define output array type for toArray() perform conversion
    arr2 = numbers2.toArray(arr2);
    System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4]

    // ArrayList<int>, not support primitive

    // Access elements in ArrayList
    for (int i = 0; i < numbers2.size(); i++) {
      System.out.println(numbers2.get(i)); // Posible to have IndexOutOfBound
    }

    int original = numbers2.set(2, 100); // unbox , replace the element but return the previous element
    System.out.println("original=" + original); // 3
    System.out.println(numbers2.get(2));

    System.out.println(numbers2.isEmpty()); // false
    System.out.println(numbers2.size() == 0); // false

    ArrayList<Integer> numbers3 = new ArrayList<>();
    numbers3.add(1000);
    numbers3.add(2000);

    numbers2.addAll(numbers3); // add all items from numbers3 to numbers2
    System.out.println(numbers2.size()); // 7

    // Remove
    numbers2.remove(2); // remove by index, remove integer 3
    System.out.println(Arrays.toString(numbers2.toArray())); // [1, 2, 4, null, 1000, 2000] // 唔洗咁print

    numbers2.removeAll(numbers3); // remove Integer 1000, 2000
    System.out.println(numbers2); // [1, 2, 4, null] // 可以就咁 print

    System.out.println(numbers2.indexOf(1000)); // -1
    System.out.println(numbers2.indexOf(2)); // 1

    System.out.println(numbers2.contains(2)); // true
    System.out.println(numbers2.contains(900)); // false
    System.out.println(numbers2.containsAll(numbers3)); // false
    numbers2.add(4);
    System.out.println(numbers2);
    System.out.println(numbers2.lastIndexOf(4));

    numbers2.add(1, 6); // insert
    System.out.println(numbers2); // [1, 6, 2, 4, null, 4]


    numbers2.clear(); // remove all elements
    System.out.println(numbers2); // []



  }
}
