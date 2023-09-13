package queue1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DemoQueue {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>(); // 有排隊的 list
    // First In First Out
    queue.add("hello");
    queue.add("world");
    System.out.println(queue.peek()); // 只看一看, hello 仍然係度
    System.out.println(queue.poll()); // hello 攞一個element出來, 水管剩下 world
    System.out.println(queue.poll()); // world 再攞一個element出來
    System.out.println(queue.poll()); // null
    System.out.println(queue.poll()); // null
    System.out.println(queue.size()); // 0

    queue.add("abc");
    queue.add("def");
    queue.add("xyz");
    System.out.println(queue.remove("def")); // true
    System.out.println(queue.poll()); // abc
    System.out.println(queue.poll()); // xyz

    System.out.println(queue.offer("ijk"));
    System.out.println(queue.offer("abc"));
    System.out.println(queue.offer("abc2"));
    System.out.println(queue.offer("ijk")); // 重複都會排入去
    System.out.println(queue.size());

    if (queue.contains("ijk")) {
      queue.remove("ijk"); // remove first occurrence
    }

    for (String str : queue) {
      System.out.println(str); // this for loop not guarantee the order!!
    }

    Queue<String> backup = queue;

    while (!queue.isEmpty()) {
      System.out.println(queue.poll()); // this loop poll guarantee the order
    } // abc, ijk

    System.out.println(backup.size()); // 0 , cos backup is object reference

    LinkedList<Integer> queueNum = new LinkedList<>();
    queueNum.add(10);
    queueNum.add(9);
    queueNum.add(0);
    queueNum.add(-3);
    queueNum.add(100);

    // System.out.println();
    // while (!queueNum.isEmpty()) {
    // System.out.println(queueNum.poll());
    // }

    // // my try
    // int count = 2;
    // int t = 0;
    // int size = queueNum.size();
    // while (t++ < size) { // always 做多了一次 因為當變了4 最後一次會再調
    // if (queueNum.peek() % 2 == 0 && --count == 0) {// 兩個if 可以放埋一齊再有埋 action
    // queueNum.poll();
    // t++; // 宜家確保去到最尾element都loop到, poll走果個就要提早一下完
    // }
    // queueNum.add(queueNum.poll());
    // }

    // vincent template
    System.out.println();
    int count = 0;
    int element = 0;
    int i = 0;
    int size = queueNum.size(); // size save size as constant
    while (i++ < size) { // if i++ < queueNum.size(), the size change during the loop
      element = queueNum.poll();
      if (element % 2 == 0 && ++count == 2)
        continue;
      queueNum.add(element);
    }

    System.out.println(queueNum);

    System.out.println();
    while (!queueNum.isEmpty()) {
      System.out.println(queueNum.poll());
    }

    PriorityQueue<Integer> aaa = new PriorityQueue<>();
    aaa.add(5);
    aaa.add(5);
    aaa.add(10);
    aaa.add(-4);
    System.out.println(aaa.peek());
    
  }
}
