public class TestSynchronized {
  int number;

  public synchronized void increment() { // Like an "Atomic method"
    this.number++; // non-atomic operation
  } // synchronized:只要1個thread做緊，其他thread都要等

  public static void main(String[] args) {
    TestSynchronized s = new TestSynchronized();

    Runnable formula = () -> {
      for (int i = 0; i < 1000000; i++) {
        s.increment(); // concat()-> non-atomic operation
      }
    };

    Thread thread1 = new Thread(formula);
    Thread thread2 = new Thread(formula);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
    }

    System.out.println(s.number);
  }
}
