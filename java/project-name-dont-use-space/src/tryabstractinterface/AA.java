package tryabstractinterface;

import java.util.Currency;

public class AA extends BB {
  // public class AA extends BB { // now BB class 繼承了 CC

   int a;
  static int rr = 35;

  public AA(int a) {
    this.a = a;
  }

  // public void setA(int a) { // final int a cannot be assigned
  // this.a = a;
  // }

  @Override
  public void m1() {
    System.out.println("cca");
  }

    @Override
  public void m2() {
    System.out.println("cc2");
  }

  public static void main(String[] args) {
    BB bb = new AA(2); // 冇 AA Class: method, int a
    CC cc = new AA(3); // 冇 AA Class: method, int a
    AA aa = new AA(1); // AA() 有哂所有野
    System.out.println(aa.a);
    System.out.println(bb.b); // BB class 只有 int b
    System.out.println(aa.b); // AA class 繼承了 int b
    // System.out.println(bb.a); // BB class 冇 int a
    aa.m1(); // AA class 繼承了 CC m1 method
    // bb.m1(); // BB class 冇 implements CC, cannot
    cc.m1();
    // bb.m1(); // after BB class implements CC, can

    // AA ab = new BB(); // BB class 冇 int a, 做唔到 AA class
    System.out.println(aa instanceof BB); // true, aa bb cc is now all AA class
    System.out.println(bb instanceof AA); // true
    System.out.println(aa instanceof CC); // true
    System.out.println(cc instanceof AA); // true
    System.out.println(bb instanceof CC); // true, cos bb is AA class
    System.out.println(cc instanceof BB); // true, cos cc is AA class

    BB bbb = new BB();
    System.out.println(bbb instanceof AA); // false, cos bbb is BB class don't have int a
    System.out.println(bbb instanceof BB); // true

    // int a = (int) 200L;
    // double a2 = 200;
    // Double a3 = Double.valueOf(500000000000L);
    // Long a4 = 5000L;
    // Double a5 = (double) Long.valueOf(100000L);
    // System.out.println(a5);
    // Object a7 = "new String(asdd)";
    // String a6 = (String) a7;
    // System.out.println(a6);

    System.out.println(bb.equalsBB(aa)); // true, even aa has "int a" but bb don't
    System.out.println(((AA) bb).equalsBB(cc));
    System.out.println(((BB) aa).equalsBB(cc));
    System.out.println(bb.equalsBB(cc));

    AA.fff();

    // CC.VOLUME=5;
    // CC.cccc="g";
    // CC.ccccc=7L;
    BB bbb3=new BB();
    bbb3.m1();

    // aa.m1(); // AA class
    // bb.m1(); // AA class
    // bbb.m1(); // BB class
    // bbb.m1();
    String t1 = "a";
    String t2 = "a";
    System.out.println(t2.equals(t1));
    // int t1=AA.b;
    // System.out.println(this.b);
    System.out.println(aa.b);

    System.out.println(aa.rr);

int a;
String avs="5";
a=Integer.valueOf(avs);
System.out.println(a);
a=(int)Math.pow(a, 2);
System.out.println(a);
  }

  public static void fff() {}



}


