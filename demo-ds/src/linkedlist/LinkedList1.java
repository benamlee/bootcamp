package linkedlist;

public class LinkedList1 {
  String str;
  LinkedList1 node; // this is just a name carrying address of next obj

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
    return this.node; // node is LinkedList1 class itself
  }

  public static void main(String[] args) {
    LinkedList1 ll = new LinkedList1();
    ll.setStr("head"); // here ll node address is null
    ll.setNode(new LinkedList1("body")); // here ll has both address, but "body" dont have name and its node address
    ll.getNode().setNode(new LinkedList1("tail")); 
    // ll.getNode() is itself class and "body" null node to setNode address with "tail" and "tail"nullnode

    LinkedList1 head = ll;
    String string = "";
    while (head != null) {
      string += head.getStr();
      head = head.getNode(); // object reference, it become next obj
    }

    System.out.println(string); // headbodytail

    // LinkedList 不是 Array, 是每一個帶下一個地址

  }
}
