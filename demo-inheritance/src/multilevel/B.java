package multilevel;
public class B extends A {
  String str;

  public void setStr(String str) {
    this.str = str;
  }

  public String geStr() {
    return this.str;
  }

  public void print(String anotherStr) {
    System.out.println(this.str + " " + anotherStr);
  }


}
