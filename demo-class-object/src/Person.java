public class Person { // template 模，這是一個工廠去生產Person
  // Describe the Person by attributes 形容詞/屬性
  private int age;
  private char gender;
  String name;
  // ...每個新Person有什麼形容詞

  // all these method belongs to each created Person, like attributes: int, char, String, ...
  // getter
  public int getAge() {
    return this.age; // 唔用默認的表達式，寫this.age就present得好
  }

  public char getGender() {
    return this.gender;
  }

  public String getName() {
    return this.name;
  }

  // setter
  public void setAge(int age) { // 每個p都有呢個改寫工具，p.setAge(13)進入到p去改寫p的age
    this.age = age; // 指明進入來p的範圍，改寫這個形容詞；其他Person不關事
    // 如果進入int 同 attribute同名，JVM會唔知你講咩，就一定要有this
    // 唔同名冇事，只係默認左有this.
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public void setName(String name) {
    this.name = name;
  }

  // static, 冇object, 不會用this. , 直接公家使用
  public static boolean isMale(char gender) { // static belongs to the class, every place can use
    if (gender == 'F') {
      return false;
    }
    return true;
  }

  // non-static, 就係為了攞「this.information」，要有 this. 才有meaning
  public boolean isMale() { // belongs to Person, must follow Person, p.isMale(), p.setAge(50), p.getGender
    if (this.gender == 'F') {
      return false;
    }
    return true;
  }


  public static void main(String[] args) { // main不屬於Person，main是工具比JVM認讀，叫JVM幫我係memory操作做野
    String s = "abcd"; // 本質都是做new一個string係heap
    String s2 = new String("abc"); // new an object in heap
    String s3 = String.valueOf("abcde"); // heap is in memory
    int a = 10;
    Boolean b = new Boolean("true"); // too old expression
    Boolean b2 = Boolean.valueOf("true");
    Boolean b3 = true; // auto-box


    Person p = new Person(); // Produce empty person object, with default value
    Person p2 = new Person(); // Produce empty person object, with default value
    p.setAge(13);
    // s.setAge(2);
    Person p3 = new Person();
    System.out.println(p.age);
    System.out.println(p2.age);
    // System.out.println(s.ageeee);
    System.out.println(p3.age);

    p.setGender('M');
    p2.setGender('F');
    System.out.println(p.getAge());
    System.out.println(p2.getGender());

    // try
    p.setName("abc");
    p2.setName("Ben");
    System.out.println(p.getName());

    // static vs non-static
    // static
    System.out.println(isMale('F')); // -> false
    System.out.println(Person.isMale('F')); // -> false，Person.isMale('F')咁寫更readible
    String.valueOf(213);
    String result = "122";

    p.setGender('M');
    System.out.println(p.isMale());
    int aa = 1;


    Computer computer = new Computer("YELLOW"); // Computer() -> empty constructor
    computer.setColor("RED");
    // computer.color; // set private -> cannot read
    computer.setRam(128);
    computer.setWeight(2);
    Computer comp2 = new Computer();
    Computer comp3 = new Computer(8, 5, "ORANGE");
    Computer comp4 = new Computer(1, 1, "White");
    computer.getColor();
    comp2.setRam(5);
    System.out.println(comp2.getRam());


  }

}
