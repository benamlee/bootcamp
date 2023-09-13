public class TestString {

  String str = "";

  public static void main(String[] args) {
    TestString s = new TestString();

    Runnable addS = () -> {
      for (int i = 0; i < 100; i++) {
        s.str = s.str.concat("s"); // concat()-> non-atomic operation
      }
    };

    Thread thread1 = new Thread(addS);
    Thread thread2 = new Thread(addS);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
    }

    System.out.println(s.str.length());
  }
}
