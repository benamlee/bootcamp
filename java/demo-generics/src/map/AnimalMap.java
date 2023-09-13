package map;

import java.util.HashMap;
import java.util.Map;

public class AnimalMap<T> { // Java 17 removed feature: "extends String | Integer", the "|"
  Map<T, String> map;

  public void put(T key, String animal) { // T {}入面 run-time 唔寫得
    map.put(key, animal);
    // map.put(T, animal); // cannot write this, and T is a class not variable
  }

  public String get(T key) { // for AnimalMap class use
    return map.get(key); // for its attribute Map class use
  }

  public AnimalMap() {
    map = new HashMap<>(); // 比object佢先用到呢個 map attribute
  }

  public static void main(String[] args) {
    AnimalMap<String> map1 = new AnimalMap<>();
    map1.put("abc", "Dog");

    AnimalMap<Integer> map2 = new AnimalMap<>();
    map2.put(1, "Dog");
    System.out.println(map1.get("abc"));



  }
}
