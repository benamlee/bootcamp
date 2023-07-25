public class Integer3 {

  // Internal Cache [-128,127]
  public static void main(String[] args) {
    Integer i1 = 100;
    Integer i2 = 100;
    System.out.println(i1 == i2); // address, true

    Integer i3 = 128;
    Integer i4 = 128;
    System.out.println(i3 == i4); // address, false

    Integer i5 = -128;
    Integer i6 = -128;
    System.out.println(i5 == i6); // address, true

    Byte b1 = 127;
    // Byte b2 = new Byte(127); // destroy Internal Cache
    // 內部用緊指定的內容 256 個指定 object [-128,127]
    // 所以唔比用新針

    System.out.println();

    Short s1 = 128;
    Short s2 = 128;
    System.out.println(s1 == s2);

    Short s3 = 127;
    Short s4 = 127;
    System.out.println(s3 == s4);

    System.out.println();

    Long l1 = 128L;
    Long l2 = 128L;
    System.out.println(s1 == s2);

    Long l3 = 127L;
    Long l4 = 127L;
    System.out.println(s3 == s4);
    // Byte, Short, Integer, Long 都係用相同的 Internal Cache

    // No Internal Cache for Double and Float
    System.out.println();

    // Boolean
    Boolean bool1 = true;
    Boolean bool2 = true;
    System.out.println(bool1 == bool2); // true, same address

    System.out.println();

    // Internal Cache -> ASCII
    Character c1 = 'a';
    Character c2 = 'a';
    System.out.println(c1 == c2);
    Character c3 = 'Ϩ'; // 'Ϩ' is 1000 in ASCII
    Character c4 = 'Ϩ';
    System.out.println(c3 == c4);

    System.out.println();

    Integer i10 = Integer.valueOf(127); // 127 仍然指同一個位
    Integer i11 = 127;
    System.out.println(i10 == i11);

    Integer i12 = Integer.valueOf(128); // 128 指新位置
    Integer i13 = 128;
    System.out.println(i12 == i13);


  }
}
