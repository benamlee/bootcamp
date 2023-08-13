package arraylist1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.FactoryConfigurationError;

public class DemoArrayList2 {
  public static void main(String[] args) {
    // ArrayList String
    ArrayList<String> strs = new ArrayList<>();
    strs.add("abc");
    strs.add("def");
    strs.add("xyz");
    strs.add("def");

    System.out.println(strs.subList(1, 4)); // from idx 1 to idx 3 // [def, xyz, def]
    boolean try1 = strs.remove("def"); // remove the first occurence
    boolean try2 = strs.remove("ttt"); // return boolean true if contains "..."
    System.out.println(try1 + " " + try2);
    System.out.println(strs); // [abc, xyz, def]
    strs.remove(0);
    System.out.println(strs); // [xyz, def]

    Iterator<String> iterator = strs.iterator(); // 另一個方法裝住 ArrayList
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    for (String s : strs) { // for-each support Array and ArrayList
      System.out.println(s);
    }

    Object[] objects = strs.toArray(); // ArrayList<String> -> Object[]
    for (Object o : objects) {
      if (o instanceof String) { // 防守
        String str = (String) o;
        System.out.println(str);
      }
    }

    // Array -> ArrayList
    String[] strings = new String[] {"hello", "world", "!"};

    List<String> s2 = new ArrayList<>(); // List is interface is kind of parent
    s2.add("abc"); // add() method must be reflecting the add() in ArrayList

    // Read Only -> big bug
    List<String> stringList = Arrays.asList(strings);
    // stringList.add("ijk"); // run-time error // cannot 改寫
    System.out.println(stringList.getClass().getName());
    System.out.println(strs.getClass().getName());

    // Read & Write (Solution)
    List<String> stringList2 = new ArrayList<>(Arrays.asList(strings));
    stringList2.add("ijk");
    System.out.println(stringList2);
    System.out.println(stringList2.getClass().getName());

    System.out.println(strs.toString());


  }
}
