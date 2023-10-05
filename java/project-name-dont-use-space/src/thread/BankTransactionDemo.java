package thread;

public class BankTransactionDemo {
    public static void main(String[] args) {
        // Create two bank accounts with initial balances
        BankAccount account1 = new BankAccount("Account 1", 1000.0);
        BankAccount account2 = new BankAccount("Account 2", 100000.0);

        // Create multiple threads to perform transactions
        Thread thread1 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 1");
        Thread thread2 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 2");
        Thread thread3 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 3");
        Thread thread4 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 4");
        Thread thread5 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 5");
        Thread thread6 = new Thread(
                new TransactionTask(account2, account1, 1.0), "Thread 6");

        // TransactionTask implements Runnable, Override .run()

        System.out.println(
                "1=" + account1.getBalance() + ", 2=" + account2.getBalance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        // Start the threads
        thread1.start();
        thread2.start();
        // thread3.start();
        // thread4.start();
        // thread5.start();
        // thread6.start();
        // 模擬有一堆transaction衝入去，同一時間做
        System.out.println(
                "1=" + account1.getBalance() + ", 2=" + account2.getBalance());
        try {
            thread1.join();
            thread2.join();
        //     thread3.join();
        //     thread4.join();
        //     thread5.join();
        //     thread6.join(); // join means end
            Thread.sleep(500); // wait 1.5s
            System.out.println("1=" + account1.getBalance() + ", 2="
                    + account2.getBalance());
            System.out.println(account1.getBalance() + account2.getBalance());
        } catch (InterruptedException e) {
            // System.out.println("1="+account1.getBalance()+", 2="+account2.getBalance());
        }

        // 直線做
        // account1.transaction(account2, 100);
        // account1.transaction(account2, 200);
        // account1.transaction(account2, 300);


    }
}
