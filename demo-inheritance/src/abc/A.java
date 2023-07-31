package abc;
public class A {

  int num;

  public void setNum(int num) {
    this.num = num;
  }

  public int getNum() {
    return this.num;
  }

  public void print(int anotherNum) {
    System.out.println(this.num + " " + anotherNum);
  }

}
