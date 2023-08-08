package linkedlist;

public class LinkedList1 {
  String str;
  LinkedList1 node;

  public LinkedList1() {}

  public LinkedList1(String str) {
    this.str = str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public void setNode(LinkedList1 node) {
    this.node = node;
  }

  public String getStr() {
    return this.str;
  }

  public LinkedList1 getNode() {
    return this.node;
  }

  public static void main(String[] args) {
    LinkedList1 ll = new LinkedList1();
    ll.setStr("head"); // here ll node address is null
    ll.setNode(new LinkedList1("body")); // here ll has both address, but "body" dont have name and its node address
    ll.getNode().setNode(new LinkedList1("tail"));

    LinkedList1 head = ll;
    String string = "";
    while (head.getNode() != null) {
      string += head.getStr();
      head = head.getNode(); // object reference
    }

    System.out.println(string);

    // LinkedList 不是 Array, 是每一個帶下一個地址

  }
}
