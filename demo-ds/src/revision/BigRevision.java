package revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class BigRevision {
  public static void main(String[] args) {
    // ArrayDeque & LinkedList
    Deque<String> arrayDeque = new ArrayDeque<>(); // Array // 相對少用&慢
    arrayDeque.addFirst("a");
    arrayDeque.addLast("b");
    arrayDeque.pollFirst();
    arrayDeque.pollLast();
    // LinkedList used most of the time
    Deque<String> linkedDeque = new LinkedList<>(); // linked list
    linkedDeque.addFirst("a");
    linkedDeque.addLast("b");
    linkedDeque.pollFirst();
    linkedDeque.pollLast();

    Queue<String> arrayQueue = new ArrayDeque<>(); // Array
    arrayQueue.add("a");
    arrayQueue.poll();

    Queue<String> linkedQueue = new LinkedList<>(); // linked list
    linkedQueue.add("a");
    linkedQueue.poll();
    
    Queue<String> pQueue = new PriorityQueue<>(); // Array
    pQueue.add("a");
    pQueue.poll();

    List<Integer> arraylist = new ArrayList<>(); // Array
    arraylist.add(3);
    arraylist.add(4);
    arraylist.add(5);
    arraylist.add(6);
    arraylist.remove(Integer.valueOf(3)); // it is obj [4,5,6]
    arraylist.remove(2); // it is idx [4,5]
    System.out.println(arraylist);
    List<Integer> linkedlist = new LinkedList<>(); // linked list
    // linkedlist.poll();
    linkedlist.add(3);
    linkedlist.add(4);
    linkedlist.add(5);
    linkedlist.add(6);
    linkedlist.remove(3); // it is idx
    System.out.println(linkedlist);

    List<String> stack = new Stack<>();
    stack.add("abc");
    stack.remove(0);

    Vector<String> stack2 = new Stack<>(); // Vector vs List
    stack2.add("abc");
    stack2.remove(0);

    Stack<String>stack3 = new Stack<>();
    stack3.push("abc");
    stack3.pop();



  }
}
