package queue1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DemoArrayDeque {
  public static void main(String[] args) {
    ArrayDeque<String> strings = new ArrayDeque<>();
    strings.add("abc");
    strings.add("def");
    strings.add("abc");
    System.out.println(strings.poll()); // abc
    System.out.println(strings.size()); // 2
    strings.addLast("xyz"); // addLast() = add()
    System.out.println(strings.poll()); // def
    strings.addFirst("ijk");
    System.out.println(strings.peek()); // ijk
    System.out.println(strings.pollFirst()); // ijk pollFirst() = poll()
    System.out.println(strings.pollLast()); // xyz

    Deque<String> queue = new LinkedList<>();
    Queue<String> queue2 = new LinkedList<>();




    
  }
}
