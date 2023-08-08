package hashset1;

import java.util.Arrays;
import java.util.HashSet;

public class DemoHashSet2 {
  public static void main(String[] args) {
    // HashSet Byte
    HashSet<Byte> bytes = new HashSet<>();
    // bytes.add(4); // int cannot -> Byte
    bytes.add(Byte.valueOf((byte) 4)); // int -> byte -> Byte
    bytes.add((Byte) (byte) 4); // is the same
    // Java is not necessary to handle return value, 冇野接住 .add 的 true/false value
    boolean isAdded10 = bytes.add(bytes(10)); // true
    boolean isAdded4 = bytes.add(bytes(4)); // false
    System.out.println(isAdded10 + "+" + isAdded4); // true+false

    HashSet<Byte> bytes2 = new HashSet<>();
    bytes2.add(bytes(10));
    System.out.println(bytes2);
    bytes2.add(bytes(4));
    System.out.println(bytes2);
    System.out.println(bytes.equals(bytes2)); // true
    bytes2.add(bytes(100));
    bytes2.add(bytes(90));
    bytes2.add(bytes(58));
    bytes2.add(bytes(24));
    System.out.println(bytes2); // [4, 100, 10, 90] 次序亂左?
    System.out.println(Arrays.toString(bytes2.toArray()));

    boolean isRemoved10 = bytes.remove(bytes(10));
    System.out.println(isRemoved10); // true

    bytes.clear();
    bytes2.clear();
    System.out.println(bytes.size());
    System.out.println(bytes2.size());
    System.out.println(bytes.equals(bytes2)); // true

    bytes.add(bytes(0));
    bytes.add(bytes(4));
    bytes.add(bytes(4)); // 重複不會再加
    bytes.add(bytes(10));
    bytes.add(bytes(44));
    bytes.add(bytes(112));
    System.out.println(bytes); // [0, 112, 4, 10, 44]


    // 重溫
    String str = "hello";
    System.out.println(str.replace('h', 'l')); // replace 有 return value，但不改變 str
    System.out.println(str);



  }


  public static Byte bytes(int num) {
    return Byte.valueOf((byte) num);
  }

}
