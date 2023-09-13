public class Number2 {
  int number1;
  int number2;

  public void setNumber1(int number1) {
    this.number1 = number1;
  }

  public void setNumber2(int number2) {
    this.number2 = number2;
  }

  public int getNumber1() {
    return this.number1;
  }

  public int getNumber2() {
    return this.number2;
  }

  public int divide() { // non-static 要有 this. 才有meaning
    this.print(); // non-static method call non-static method
    System.out.println(Number2.add(this.number1, this.number2)); // non-static method call static method
    return this.number2 / this.number1; // 上面指明呢一頁Number2.add(...)係呢一頁define既method
  }

  public int divide(int number1, int number2) { // 冇static, 要用n1.divide(3,6), 冇用過this information, 冇意思
    return number2 / number1; // 咁寫好冇意思
  } // 咁寫好冇意思

  public static int divide2(int number1, int number2) { // 冇static, 要用n1.divide(3,6), 冇用過this information, 就冇意思
    Number2 a = new Number2();
    a.setNumber1(0);
    a.setNumber2(1);
    a.print(); // static method call non-static method, must new Object everytime
    return number2 / number1;
  } // 咁寫好冇意思
  // 同 public int divide(int number1, int number2) 撞名

  public void print() {
    System.out.println("this.number1=" + this.number1);
    System.out.println("this.number2=" + this.number2);
  }

  public static int add(int number1, int number2) {
    return number1 + number2;
  }

  public static void main(String[] args) {
    Number2 n1 = new Number2();
    n1.setNumber1(13);
    n1.setNumber2(26);

    Number2 n2 = new Number2();
    n2.setNumber1(10);
    n2.setNumber2(100);

    System.out.println(n1.divide());
    System.out.println(n2.divide());

    n1.print();
    n2.print();



  }
}
