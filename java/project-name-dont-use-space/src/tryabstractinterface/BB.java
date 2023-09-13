package tryabstractinterface;

// public class BB {
  // public abstract class BB { // cannot be new
  // public abstract class BB implements CC { // now implements CC, cos its a abstract class, so m1 can be defined in subclass
  public class BB implements CC{

  int b = 2;

  @Override
  public void m1() {
  System.out.println("bb");
  }

  public boolean equalsBB(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof BB))
      return false;
    BB bbb = (BB) o;
    return this.b == bbb.b;
  }

  public static void main(String[] args) {
    BB b=new BB();
    b.m1();
    
  }

}
