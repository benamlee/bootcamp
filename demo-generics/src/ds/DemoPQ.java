package ds;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;



public class DemoPQ implements Comparator<String>{


  @Override
  public int compare(String o1, String o2) {
    return o2.charAt(0) > o1.charAt(0) ? 1 : -1;
  }


  public static void main(String[] args) {
    // natural order by default
    Queue<String> queue = new PriorityQueue<>(); 
    queue.add("bcd");
    queue.add("abb");
    queue.add("def");
    queue.add("abc");
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    queue.add("bcd");
    queue.add("abc");
    queue.add("def");
    queue.add("abb");
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());

    Queue<String> custom = new PriorityQueue<>(new DemoPQ()); // constructor 已鎖定成條queue 點排
    custom.add("bcd");
    custom.add("abb");
    custom.add("def");
    custom.add("abc");
    System.out.println(custom.poll());
    System.out.println(custom.poll());
    System.out.println(custom.poll());
    System.out.println(custom.poll());



  }
}
