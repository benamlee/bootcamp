import java.util.Hashtable;
import java.util.Map;

public class DemoHashTable {

  Map<String, Integer> table = new Hashtable<>();

  public static void main(String[] args) {
    DemoHashTable t = new DemoHashTable();

    Runnable putOne = () -> {
      for (int i = 0; i < 1000000; i++) {
        t.table.compute("abc", (key, old) -> old == null ? 1 : old + 1);
      }
    };

    Thread thread1 = new Thread(putOne);
    Thread thread2 = new Thread(putOne);
    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {

    }
    System.out.println(t.table.get("abc"));

  }
}
