public class Revision {

  // instance variable
  String name; // non-primitive -> address

  public void print(String input) {
    System.out.println("hello " + input + " " + this.name);
  }

  public static void print2(String input) {
    System.out.println("hello " + input);
  }


  public static void main(String[] args) {
    Revision r1 = new Revision();
    r1.name = "John";
    Revision r2 = new Revision();
    r2.name = "John";

    System.out.println(r1.equals(r2));

    r1.print("world");
    Revision.print2("world");

    System.out.println(r1 == r2); // false
    System.out.println(r1.name == r2.name); // true

    r2.name = new String("John");
    System.out.println(r1.name == r2.name); // false

    String s1 = "abc"; // double quote, no "new" key word
    String s2 = "abc";
    System.out.println(s1 == s2); // true, Literal Pool


    String s3 = new String("abc");
    System.out.println(s1 == s3); // false

    Integer i1 = 127;
    Integer i2 = 127;
    System.out.println(i1 == i2); // true, cache
    Integer i3 = 128;
    Integer i4 = 128;
    System.out.println(i3 == i4); // false

    String temp = s1;
    s1 += "d";
    System.out.println(temp == s1); // false, pass by value


    String aa = "a";
    String bb = new String("a");
    String cc = "a";
    System.out.println(aa == cc);
    System.out.println(bb == cc);

    Integer aaa=129;
    Integer bbb=aaa;
    Integer ccc=129;
    System.out.println(aaa==bbb);
    System.out.println(aaa==ccc);
    aaa=4;
    System.out.println(bbb);
    System.out.println(aaa==bbb);


  }

}
