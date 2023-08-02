// Before Java 8 - 100% Abstraction

public interface Runnable { // interface is a contract
// 拆越細越好，描述得越清晰越好

  void run(); // implicitly public & abstract

  // void eat(); // implicitly public & abstract

  // private void eat2(); // no private or other
}
