package tryabstractinterface;

public class AA extends BB implements CC {
  // public class AA extends BB { // now BB class 繼承了 CC

  int a = 1;

  @Override
  public void m1() {
    System.out.println("cc");
  }

  public static void main(String[] args) {
    BB bb = new AA();
    CC cc = new AA();
    AA aa = new AA(); // AA() 有哂所有野
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

    int a = (int) 200L;
    double a2 = 200; 
    Double a3 = Double.valueOf(500000000000L); 
    Long a4 = 5000L;


  }


}
