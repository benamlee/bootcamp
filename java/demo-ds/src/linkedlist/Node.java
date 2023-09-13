package linkedlist;

public class Node {
  
  int data; // data can be any type
  Node next; // The address of next node

  public Node(int data) {
    this.data = data;
  }

  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(5);
  }



}
