package queue1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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

    // 用 Deque / Queue 大大收窄 methods => 大大提高 Readibility，知道想做咩
    Deque<String> deque = new LinkedList<>(); // Polymarphism
    Queue<String> queue = new LinkedList<>(); // Polymorphism
    // Queue 單向 --- Deque 雙向
    // interface Deque<E> extends Queue<E> 不能被 new
    // class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable

    // 左邊收窄method，右邊決定用邊個 override method
    // add 的方法都不同，次序會不同

    queue.add("abc");
    deque.add("abc");
    deque.addFirst("def");
    deque.addLast("ijk");

    run1(new LinkedList<>());
    run1(new ArrayDeque<>());
    // run1(new PriorityQueue()); // compile-error

    run2(new LinkedList<>());
    run2(new ArrayDeque<>()); // 是Class
    run2(new PriorityQueue<>()); // 會自己排列，唔跟我加的次序
    
    Collection<String> arrayList=new ArrayList<>();
    
    List<String> list = new LinkedList<>(); // => hide all Deque methods

  }

  public static void run1(Deque<String> deque) {
    deque.add("ss");
    deque.add("ss");
  }

  public static void run2(Queue<String> queue) { // 用 interface 留空間比人裝唔同既野
    queue.add("ss");
    queue.add("ss");
  }

  public static void run3(Collection<String> collection){
    collection.add(null);
  }


}
